package com.tts.hello.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.hello.models.Greeting;

@Controller
public class GreetingController {

	@GetMapping(path="/greeting")	
	public String greeting(
		@RequestParam(
			name="name",
			required=false,
			defaultValue="World"
		) String name,
	    Model model
	) {	
		model.addAttribute("greeting", new Greeting());		
		return "greeting";
	}
	
	@PostMapping(path="/greeting")
	public String greetingSubmit(Greeting greeting, Model model) {
		model.addAttribute("greeting", greeting);
		return "result";
	}
	
	
	@GetMapping(path="/")
	public String redirectRoot() {
		return "redirect:/index.html";
	}
}
