package com.jkalango.webapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/fase")
public class FaseJogoController {
	
	@GetMapping
	public int mostrearQtdeFases() {
		return 7;
	}
}
