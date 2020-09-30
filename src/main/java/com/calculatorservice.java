package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class calculatorservice {
	
	@GetMapping("/sum")
	public int sum() {
		int a=7,b=7;

		return a+b;
	}
	@GetMapping("/substraction")
	public int substraction() {
		int a=100,b=50;

		return a-b;
	}
	@GetMapping("/multiply")
	public int multiply() {
		int a=100,b=50;

		return a*b;
	}
	@GetMapping("/division")
	public int division() {
		int a=240,b=6;

		return a/b;
	}
}

