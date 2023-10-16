package com.direitoapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.direitoapp.domain.Pessoa;
import com.direitoapp.repositories.PessoaRepository;
import com.direitoapp.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired private PessoaRepository pessoaRepository;
	
	public Pessoa findByCelular(String celular) {
		Optional<Pessoa> pesssoa = pessoaRepository.findByCelular(celular);
		return pesssoa.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado celular: " + celular));
	}
}
