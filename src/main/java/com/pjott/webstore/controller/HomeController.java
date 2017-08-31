package com.pjott.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping
	public String welcome(Model model) {
		
		model.addAttribute("welcomeText", "Welcome to my awsome Web Store !!!");
		model.addAttribute("taglineText", "The best web store in the world !!!");
		
		return "welcomePage";
	}
}
