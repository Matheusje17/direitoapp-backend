package com.direitoapp.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.direitoapp.domain.Cliente;
import com.direitoapp.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;




public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	protected Integer id;
	
	@NotNull(message = "O campo nome é obrigatório")
	protected String nome;
	
	@NotNull(message = "O campo celular é obrigatório")
	protected String celular;
	
	protected Boolean isAdvogado;
	
	@NotNull(message = "O campo senha é obrigatório")
	protected String senha;
	
	protected String cep;
	protected String estado;
	protected String cidade;
	
	protected Set<Integer> perfis = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/YYYY")
	protected LocalDate dataCriacao = LocalDate.now();

	public ClienteDTO() {
		super();
		addPerfis(Perfil.CLIENTE);

	}

	public ClienteDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.celular = cliente.getCelular();
		this.isAdvogado = cliente.getIsAdvogado();
		this.senha = cliente.getSenha();
		this.cep = cliente.getCep();
		this.estado = cliente.getEstado();
		this.cidade = cliente.getCidade();
		this.perfis = cliente.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = cliente.getDataCriacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Boolean getIsAdvogado() {
		return isAdvogado;
	}

	public void setIsAdvogado(Boolean isAdvogado) {
		this.isAdvogado = isAdvogado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfis(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
	
	
}
