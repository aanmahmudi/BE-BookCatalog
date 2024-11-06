package com.latihan.catalog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	//@RequestMapping(value= "/home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("name", "Aan");
		return "home";
	}

}
