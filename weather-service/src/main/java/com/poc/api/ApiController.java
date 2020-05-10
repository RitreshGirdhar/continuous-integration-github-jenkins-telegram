package com.poc.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@GetMapping("/v1/weather/{city}")
	public String test(@PathVariable(name = "city") String city) {
		return "test";
	}

}
