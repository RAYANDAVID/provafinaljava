package com.jkalango.webapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/alo")
public class AloController {
	
	//Responsavel por:
	//requisição e resposta (REQUEST E RESPONSE)
	
	@GetMapping
	public String aloMundo() {
		return "Alo mundo - JKalango!";
	}

}
