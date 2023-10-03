package com.direitoapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.direitoapp.domain.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	 Optional<Pessoa> findByCelular(String celular);
	 
}
