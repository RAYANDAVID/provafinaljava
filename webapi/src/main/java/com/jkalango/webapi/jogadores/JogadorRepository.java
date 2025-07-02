package com.jkalango.webapi.jogadores;

import org.springframework.data.jpa.repository.JpaRepository;

										   //Generics
public interface JogadorRepository extends JpaRepository<Jogador, Long>{

}
