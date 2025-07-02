package com.jkalango.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jkalango.webapi.jogadores.DadosCadastroJogador;
import com.jkalango.webapi.jogadores.Jogador;
import com.jkalango.webapi.jogadores.JogadorRepository;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
		
	@Autowired //injeção de dependência
	private JogadorRepository repository;
	
		@PostMapping
		@Transactional
		public void cadastrar(@RequestBody DadosCadastroJogador dados) {
			//System.out.println(dados);
			repository.save(new Jogador(dados));
		}
}
