package com.tutorialspoint;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dhtmlx.planner.DHXPlanner;
import com.dhtmlx.planner.DHXSkin;
import com.tutorials.domain.Doctor;
import com.tutorials.domain.Hospital;
import com.tutorials.domain.Patient;
import com.tutorials.service.DataService;
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

	@RequestMapping(value = "/showPatient", method = RequestMethod.GET)
	public @ResponseBody String showPatient(@RequestParam String patientId) {
		Patient patient = dataService.getPatient(Integer.parseInt(patientId));

		Map<String, String> pationtMap = Utils.fillPatientMap(patient);
		Map<String, String> result = new LinkedHashMap<String, String>();

		result.put("success", patient != null ? "true" : "false");
		result.put("patient", JSONValue.toJSONString(pationtMap));

		return JSONValue.toJSONString(result);
	}

	@RequestMapping(value = "/addNewPatient", method = RequestMethod.GET)
	public String addPatientForm(ModelMap model, Principal principal, HttpSession session) {
		model.addAttribute("patient", new Patient());
		List<String> h = dataService.getHospitalsName();
		log.warn("warning");
		log.debug("debug");
		log.info("info");
		log.error("error");
		log.fatal("fatal");
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

		Integer hospitalId = ((Hospital) dataService.getHospitalIdByName(hospital)).getId();

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
		// p.load("events", DHXDataFormat.JSON);

		ModelAndView mnv = new ModelAndView("calendarPage");
		mnv.addObject("body", p.render());
		return mnv;
	}

}
