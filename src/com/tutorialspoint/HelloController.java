package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	// @Autowired
	// DataService dataService;

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
		return "Welcome to your first Spring Security Example";
	}

	@RequestMapping(value = "/addNewPatient", method = RequestMethod.GET)
	public ModelAndView addNewPatient(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView("addNewPatient");
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNew(ModelMap model) {
		return "stupid";
	}

}
