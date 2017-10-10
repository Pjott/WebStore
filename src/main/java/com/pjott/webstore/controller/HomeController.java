package com.pjott.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping
	public String welcome(Model model, RedirectAttributes redirectAttributes) {
		
		model.addAttribute("welcomeText", "Welcome to my awsome Web Store !!!");
		model.addAttribute("taglineText", "The best web store in the world !!!");
		redirectAttributes.addFlashAttribute("welcomeText", "Welcome to my awsome Web Store !!!");
		redirectAttributes.addFlashAttribute("taglineText", "The best web store in the world !!!");
		
		return "redirect:/welcome/greeting";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcomePage";
	}
}
