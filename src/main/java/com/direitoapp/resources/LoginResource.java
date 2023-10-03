package com.direitoapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.direitoapp.domain.Pessoa;
import com.direitoapp.domain.dtos.CredenciaisDTO;
import com.direitoapp.domain.dtos.UsuarioDTO;
import com.direitoapp.services.AdvogadoService;
import com.direitoapp.services.ClienteService;
import com.direitoapp.services.LoginService;

@RestController
@RequestMapping(value = "/login")
public class LoginResource {
	
	@Autowired private LoginService loginService;
	@Autowired private AdvogadoService advogadoService;
	@Autowired private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> login(@RequestBody CredenciaisDTO credenciaisDTO) {
		Pessoa pessoa = loginService.getLogin(credenciaisDTO);
		UsuarioDTO result;
		if (pessoa.getIsAdvogado()) {
			result = new UsuarioDTO(advogadoService.findById(pessoa.getId()));
		}
		else {
			result = new UsuarioDTO(clienteService.findById(pessoa.getId()));
		}
		
		return ResponseEntity.ok().body(result);
		
	}
}
