package com.mherman22.KTMInv.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeCOntroller {

	@GetMapping("/welcome")
	public String welcomeToKTM() {
		return "You're most welcome to KTM-INV Backend API";
		
	}
}
