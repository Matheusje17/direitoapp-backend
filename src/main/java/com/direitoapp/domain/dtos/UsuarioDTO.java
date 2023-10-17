package com.direitoapp.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.direitoapp.domain.Advogado;
import com.direitoapp.domain.Cliente;

public class UsuarioDTO implements Serializable{
private static final long serialVersionUID = 1L; 
	
	protected Integer id;
	protected String nome;
	protected String celular;
	
	protected Boolean isAdvogado;
	protected String senha;
	protected String cep;
	private String oab;
	private Integer quantidadeCasosAtendidos;
	protected Set<Integer> perfis = new HashSet<>();
	protected LocalDate dataCriacao = LocalDate.now();
	protected String estado;
	protected String cidade;
	
	
	public UsuarioDTO(Advogado adv) {	
		super();
		this.id = adv.getId();
		this.nome = adv.getNome();
		this.celular = adv.getCelular();
		this.isAdvogado = adv.getIsAdvogado();
		this.senha = adv.getSenha();
		this.cep = adv.getCep();
		this.perfis = adv.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = adv.getDataCriacao();
		this.oab = adv.getOab();
		this.quantidadeCasosAtendidos = adv.getQuantidadeCasosAtendidos();
		this.estado = adv.getEstado();
		this.cidade = adv.getCidade();
		
		//this.advogadoCasoDTO = adv.getAdvogadoCaso().stream().map(ac -> new AdvogadoCasoDTO(ac)).collect(Collectors.toList());	
	}
	
	public UsuarioDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.celular = cliente.getCelular();
		this.isAdvogado = cliente.getIsAdvogado();
		this.senha = cliente.getSenha();
		this.cep = cliente.getCep();
		this.perfis = cliente.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = cliente.getDataCriacao();
		this.estado = cliente.getEstado();
		this.cidade = cliente.getCidade();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCelular() {
		return celular;
	}

	public Boolean getIsAdvogado() {
		return isAdvogado;
	}

	public String getSenha() {
		return senha;
	}

	public String getCep() {
		return cep;
	}

	public String getOab() {
		return oab;
	}

	public Integer getQuantidadeCasosAtendidos() {
		return quantidadeCasosAtendidos;
	}

	public Set<Integer> getPerfis() {
		return perfis;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	
	
	
}
