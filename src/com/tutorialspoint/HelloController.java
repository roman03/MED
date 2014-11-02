package com.tutorialspoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.domain.Patient;
import com.tutorials.service.DataService;

@Controller
public class HelloController {

	private final static int LAST_PATIENT_COUNT = 4;
	@Autowired
	DataService dataService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username or password!");
		}
		model.setViewName("login");

		return model;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/newPatient", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("message",
				"Welcome to your first Spring Security Example");
		return "login";
	}

	@RequestMapping(value = "/addNewPatient", method = RequestMethod.GET)
	public ModelAndView addNewPatient(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView("addNewPatient");
		return modelAndView;
	}

	@RequestMapping(value = "/recentPatients", method = RequestMethod.GET)
	public ModelAndView recentPatients(ModelMap model) {

		List<Patient> patients = dataService.getRecentPatinets(getInterval());
		ModelAndView mav = new ModelAndView();
		mav.addObject("object", patients);
		return mav;
	}

	private Integer[] getInterval() {
		int lastPatinetId = dataService.getLastId();
		Integer[] patients;
		if (lastPatinetId > LAST_PATIENT_COUNT) {
			patients = new Integer[LAST_PATIENT_COUNT];
			for (int i = lastPatinetId, y = 0; i > lastPatinetId
					- LAST_PATIENT_COUNT; i--, y++) {
				patients[y] = new Integer(i);
			}
		} else {
			patients = new Integer[lastPatinetId];
			for (int i = 0; i < lastPatinetId; i++) {
				patients[i] = new Integer(i);
			}
		}

		return patients;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public String testGet(@RequestParam String patientname,
			@RequestParam String firstname, @RequestParam String lastname,
			@RequestParam String age, @RequestParam String sex,
			@RequestParam String address, @RequestParam String workPlace,
			@RequestParam String diagnosis, @RequestParam String dataArrived) {

		Patient patient = new Patient();
		patient.setName(patientname);
		patient.setFirstname(firstname);
		patient.setLastname(lastname);
		patient.setAge(age);
		patient.setSex(sex);
		patient.setAddress(address);
		patient.setWorkplace(workPlace);
		patient.setDiagnosis(diagnosis);
		patient.setDateArrived(dataArrived);

		dataService.insertRow(patient);
		return "redirect:/newPatient";
	}

}
