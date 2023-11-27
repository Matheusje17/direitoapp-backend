package com.direitoapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.direitoapp.domain.Pessoa;
import com.direitoapp.domain.dtos.CredenciaisDTO;
import com.direitoapp.repositories.PessoaRepository;
import com.direitoapp.services.exceptions.DataIntegrityViolationException;
import com.direitoapp.services.exceptions.ObjectNotFoundException;

@Service
public class LoginService {

	@Autowired private PessoaRepository pessoaRepository;
	
	public Pessoa getLogin(CredenciaisDTO credenciaisDTO) {
		Optional<Pessoa> pessoa = pessoaRepository.findByCelular(credenciaisDTO.getCelular());
		pessoa.orElseThrow(() -> new ObjectNotFoundException("Usuario inexistente"));
		String passRequest = credenciaisDTO.getSenha();
		String userPass = pessoa.get().getSenha();
		
		
		if(!passRequest.equals(userPass)) {
			throw  new DataIntegrityViolationException("Senha invalida!");
		}
		return pessoa.get();
		
		
	}
	
	public Pessoa getUserByCelular(String celular) {
		Optional<Pessoa> pessoa = pessoaRepository.findByCelular(celular);
		return pessoa.orElseThrow(() -> new ObjectNotFoundException("Usuario inexistente "));
	}
	

}
