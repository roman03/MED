package com.tutorialspoint;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dhtmlx.planner.DHXPlanner;
import com.dhtmlx.planner.DHXSkin;
import com.dhtmlx.planner.data.DHXDataFormat;
import com.tutorials.domain.Analyzes;
import com.tutorials.domain.Doctor;
import com.tutorials.domain.Hospital;
import com.tutorials.domain.Patient;
import com.tutorials.domain.Procedures;
import com.tutorials.domain.Relation;
import com.tutorials.domain.Treatment;
import com.tutorials.service.DataService;
import com.tutorialspoint.misc.TREATMENT_ENUM;
import com.tutorialspoint.utils.Utils;
import com.tutorialspoint.validator.NewPatientValidator;

@Controller
public class HelloController {

	@Autowired
	DataService dataService;

	@Autowired
	NewPatientValidator patientValidation;

	private static final Logger log = Logger.getLogger(HelloController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username or password!");
		}
		model.setViewName("loginPage");

		return model;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		return "indexPage";
	}

	@RequestMapping(value = "/newPatient", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("message", "Welcome to your first Spring Security Example");
		return "loginPage";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/sendAnalyzes", method = RequestMethod.POST)
	public @ResponseBody String processAnalizes(@RequestParam(value = "title") String title,
			@RequestParam(value = "place") String place, @RequestParam(value = "time") String time,
			@RequestParam(value = "patientId") String patientId, @RequestParam(value = "doctorId") String doctorId) {

		JSONObject responseDetailsJson = new JSONObject();

		Calendar convertedTime = Utils.convertStringToCalendar(time, "dd/MM/yyyy HH:mm a");

		if (convertedTime == null) {
			responseDetailsJson.put("success", false);
			return JSONValue.toJSONString(responseDetailsJson);
		}

		Analyzes analizes = Utils.createAnalizes(title, place, convertedTime);
		Integer analyzesId = dataService.addAnalyzes(analizes);
		Treatment treatment = Utils.createTreatment(analyzesId, doctorId, patientId, TREATMENT_ENUM.ANALIZES);

		dataService.addTreatment(treatment);

		responseDetailsJson.put("success", true);
		return JSONValue.toJSONString(responseDetailsJson);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/sendProcedures", method = RequestMethod.POST)
	public @ResponseBody String processProcedures(@RequestParam(value = "title") String title,
			@RequestParam(value = "place") String place, @RequestParam(value = "time") String time,
			@RequestParam(value = "patientId") String patientId, @RequestParam(value = "doctorId") String doctorId) {

		JSONObject responseDetailsJson = new JSONObject();

		Calendar convertedTime = Utils.convertStringToCalendar(time, "dd/MM/yyyy HH:mm a");

		if (convertedTime == null) {
			responseDetailsJson.put("success", false);
			return JSONValue.toJSONString(responseDetailsJson);
		}

		Procedures procedures = Utils.createProcedures(title, place, convertedTime);
		Integer proceduresId = dataService.addProcedures(procedures);
		Treatment treatment = Utils.createTreatment(proceduresId, doctorId, patientId, TREATMENT_ENUM.PROCEDURES);

		dataService.addTreatment(treatment);

		responseDetailsJson.put("success", true);
		return JSONValue.toJSONString(responseDetailsJson);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/showPatient", method = RequestMethod.GET)
	public @ResponseBody String showPatient(@RequestParam String patientId) {

		JSONObject responseDetailsJson = new JSONObject();

		Patient patient = dataService.getPatient(Integer.parseInt(patientId));
		List<Integer> doctorsIdList = dataService.getPatientDoctors(Integer.parseInt(patientId));
		List<Doctor> doctorList = new ArrayList<Doctor>();

		for (Integer id : doctorsIdList) {
			doctorList.add(dataService.getDoctorById(id));
		}

		Hospital hospital = dataService.getHospital(patient.getHospitalId());
		responseDetailsJson.put("success", patient != null ? "true" : "false");
		responseDetailsJson.put("patient", JSONValue.toJSONString(Utils.fillPatientMap(patient)));
		responseDetailsJson.put("doctors", Utils.getDoctors(doctorList));
		responseDetailsJson.put("hospital", JSONValue.toJSONString(Utils.fillHospitalMap(hospital)));

		return JSONValue.toJSONString(responseDetailsJson);
	}

	@RequestMapping(value = "/addNewPatient", method = RequestMethod.GET)
	public String addPatientForm(ModelMap model, Principal principal, HttpSession session) {
		model.addAttribute("patient", new Patient());
		List<String> h = dataService.getHospitalsName();

		model.addAttribute("hospitals", h);
		return "addNewPatientPage";
	}

	@RequestMapping(value = "/recentPatients", method = RequestMethod.GET)
	public ModelAndView recentPatients(ModelMap model) {
		ModelAndView mav = new ModelAndView("recentPatientsPage");
		int lastPatinetId = dataService.getLastId();
		List<Patient> patients = dataService.getRecentPatinets(Utils.getInterval(lastPatinetId));
		mav.addObject("object", patients);

		return mav;
	}

	@RequestMapping(value = "/addNewPatient", method = RequestMethod.POST)
	public String addPatient(@ModelAttribute("patient") @Valid Patient patient, BindingResult result, ModelMap model) {

		patientValidation.validate(patient, result);

		if (result.hasErrors()) {
			return "addNewPatientPage";
		}

		Integer hospitalId = ((Hospital) dataService.getHospitalIdByName(patient.getHospitalName())).getId();
		patient.setHospitalId(hospitalId);
		dataService.insertRow(patient);

		return "redirect:recentPatients";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/DoctorList", method = RequestMethod.GET)
	public @ResponseBody String showDoctors(@RequestParam(value = "hospital") String hospital) {

		JSONObject responseDetailsJson = new JSONObject();

		if (hospital == null || hospital.isEmpty()) {
			responseDetailsJson.put("sucess", "false");
			return JSONValue.toJSONString(responseDetailsJson);
		}
		Hospital s = ((Hospital) dataService.getHospitalIdByName(hospital));
		Integer hospitalId = s.getId();

		List<Doctor> doctorList = dataService.getDoctorsFromHospital(hospitalId);

		log.warn("HospitalId " + hospitalId.toString());
		log.warn("doctorList " + doctorList);

		responseDetailsJson.put("doctors", Utils.getDoctors(doctorList));
		responseDetailsJson.put("sucess", "true");

		return JSONValue.toJSONString(responseDetailsJson);
	}

	@RequestMapping("/GetCalendar")
	public ModelAndView planner(HttpServletRequest request) throws Exception {
		DHXPlanner p = new DHXPlanner("resources/codebase/", DHXSkin.GLOSSY);
		p.setInitialDate(2013, 1, 7);
		p.config.setScrollHour(8);
		p.setWidth(700);
		p.setHeight(500);
		p.load("events", DHXDataFormat.JSON);

		ModelAndView mnv = new ModelAndView("calendarPage");
		mnv.addObject("body", p.render());
		return mnv;
	}

	@RequestMapping("/events")
	@ResponseBody
	public String events(HttpServletRequest request) {
		CustomEventsManager evs = new CustomEventsManager(request);
		return evs.run();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addDoctor", method = RequestMethod.POST)
	public @ResponseBody String addDoctor(@RequestParam(value = "patient") String patient,
			@RequestParam(value = "doctors[]") String[] doctors) {
		JSONObject responseDetailsJson = new JSONObject();

		log.info("patinetId" + patient);
		log.info("doctors " + doctors);
		try {
			for (int i = 0; i < doctors.length; i++) {
				Relation card = new Relation();
				card.setPatientId(Integer.parseInt(patient));
				card.setDoctorId(Integer.parseInt(doctors[i]));
				dataService.insertMedCard(card);
			}
			responseDetailsJson.put("sucess", true);
		} catch (NumberFormatException e) {
			responseDetailsJson.put("sucess", false);
			e.printStackTrace();
		} catch (Exception e) {
			responseDetailsJson.put("sucess", false);
			e.printStackTrace();
		}
		return JSONValue.toJSONString(responseDetailsJson);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/update/patient/{id}", method = RequestMethod.POST)
	public @ResponseBody String update(@PathVariable("id") int Id, @RequestParam(value = "name") String name,
			@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName,
			@RequestParam(value = "age") String age, @RequestParam(value = "sex") String sex,
			@RequestParam(value = "adress") String address, @RequestParam(value = "about") String about) {

		Patient patient = new Patient(firstName, lastName, name, age, sex, address, about);
		dataService.updatePatient(Id, patient);
		JSONObject responseDetailsJson = new JSONObject();
		responseDetailsJson.put("sucess", true);
		return JSONValue.toJSONString(responseDetailsJson);
	}

}
