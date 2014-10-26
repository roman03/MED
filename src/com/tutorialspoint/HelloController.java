package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class HelloController{
 
	@RequestMapping(value = "/login", method = RequestMethod.GET)
   public ModelAndView  login( 
		@RequestParam(value = "error", required = false) String error) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username or password!");
		}
		model.setViewName("login");
 
		return model;
   }
	
	@RequestMapping(value = {"", "/", "welcome"}, method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {  
        return "welcome";  
    }  

	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String printIndex(ModelMap model) {  
        model.addAttribute("message",  
                "Welcome to your first Spring Security Example");  
        return "index";  
    } 
}
