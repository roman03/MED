package com.tutorialspoint;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.domain.Patient;
import com.tutorials.service.DataService;
import com.tutorialspoint.validator.NewPatientValidator;

@Controller
public class HelloController {

	private final static int LAST_PATIENT_COUNT = 4;
	@Autowired
	DataService dataService;

	@Autowired
	NewPatientValidator patientValidation;

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
	public String addPatientForm(ModelMap model, Principal principal,
			HttpSession session) {
		model.addAttribute("patient", new Patient());
		return "addNewPatient";
	}

	@RequestMapping(value = "/recentPatients", method = RequestMethod.GET)
	public ModelAndView recentPatients(ModelMap model) {
		ModelAndView mav = new ModelAndView();

		List<Patient> patients = dataService.getRecentPatinets(getInterval());
		mav.addObject("object", patients);

		return mav;
	}

	private Integer[] getInterval() {
		int lastPatinetId = dataService.getLastId();
		Integer[] patients = null;
		if (lastPatinetId > LAST_PATIENT_COUNT) {
			patients = new Integer[LAST_PATIENT_COUNT];
			for (int i = lastPatinetId, y = 0; i > LAST_PATIENT_COUNT; i--, y++) {
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

	@RequestMapping(value = "/addNewPatient", method = RequestMethod.POST)
	public String addPatient(@ModelAttribute("patient") @Valid Patient patient,
			BindingResult result, ModelMap model) {

		patientValidation.validate(patient, result);

		if (result.hasErrors()) {
			return "addNewPatient";
		}
		dataService.insertRow(patient);

		return "recentPatients";
	}
}
