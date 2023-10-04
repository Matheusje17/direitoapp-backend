package com.direitoapp.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.direitoapp.domain.dtos.ClienteDTO;
import com.direitoapp.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;


@Entity
public class Cliente extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Caso> casos = new ArrayList<Caso>();
	
	public Cliente() {
		super();
	}

	public Cliente(ClienteDTO clienteDTO) {
		super();
		this.id = clienteDTO.getId();
		this.nome = clienteDTO.getNome();
		this.celular = clienteDTO.getCelular();
		this.isAdvogado = clienteDTO.getIsAdvogado();
		this.senha = clienteDTO.getSenha();
		this.cep = clienteDTO.getCep();
		this.perfis = clienteDTO.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = clienteDTO.getDataCriacao();
	}
	
	public Cliente(Integer id, String nome, String email, String celular, Boolean isAdvogado, String senha,String cep) {
		super(id, nome, email, celular, isAdvogado, senha, cep);
		addPerfil(Perfil.CLIENTE);
	}

	public List<Caso> getCasos() {
		return casos;
	}

	public void setCasos(List<Caso> casos) {
		this.casos = casos;
	}


	
	
	
	
}
