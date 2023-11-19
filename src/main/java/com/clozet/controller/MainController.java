package com.clozet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	///Constructor
	public MainController(){
		System.out.println("==> MainController default Constructor call.............");
	}
//
//	@GetMapping("/")
//	public String index() {
//
//		System.out.println("[ MainController.index() start........]");
//		return "hi";
//
//	}
}
