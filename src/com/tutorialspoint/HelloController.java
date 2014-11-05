package com.tutorialspoint;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
	public String addPatientForm(ModelMap model, Principal principal,
			HttpSession session) {
		model.addAttribute("patient", new Patient());
		return "addNewPatient";
	}

	@RequestMapping(value = "/recentPatients", method = RequestMethod.GET)
	public ModelAndView recentPatients(ModelMap model) {
		ModelAndView mav = new ModelAndView();
		int lastPatinetId = dataService.getLastId();
		List<Patient> patients = dataService.getRecentPatinets(Utils
				.getInterval(lastPatinetId));
		mav.addObject("object", patients);

		return mav;
	}

	@RequestMapping(value = "/addNewPatient", method = RequestMethod.POST)
	public String addPatient(@ModelAttribute("patient") @Valid Patient patient,
			BindingResult result, ModelMap model) {

		patientValidation.validate(patient, result);

		if (result.hasErrors()) {
			return "addNewPatient";
		}
		dataService.insertRow(patient);

		return "redirect:recentPatients";
	}
}
