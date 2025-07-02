package com.jkalango.webapi.jogadores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="jogador")
@Entity(name="Jogador")
@Getter
@NoArgsConstructor //JPA - solicita um construtor vazio
@AllArgsConstructor
@EqualsAndHashCode(of = "id") //comparar objetos, collections
public class Jogador {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String nickName;
	private String email;
	private String telefone;
	private String senha;
	
	public Jogador(DadosCadastroJogador dados) {
		this.nome = dados.nome();
		this.nickName = dados.nickName();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.senha = dados.senha();
	}

}
