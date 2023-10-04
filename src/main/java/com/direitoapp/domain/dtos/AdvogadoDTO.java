package com.direitoapp.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.direitoapp.domain.Advogado;
import com.direitoapp.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;


public class AdvogadoDTO implements Serializable{
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
	
	
	@NotNull(message = "O campo oab é obrigatório")
	private String oab;
	private Integer quantidadeCasosAtendidos;
	
	protected Set<Integer> perfis = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/YYYY")
	protected LocalDate dataCriacao = LocalDate.now();
	
	private List<AdvogadoCasoDTO> advogadoCasoDTO = new ArrayList<>();

	public AdvogadoDTO() {
		super();
		addPerfis(Perfil.ADVOGADO);
	}

	public AdvogadoDTO(Advogado adv) {
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
		this.estado = adv.getEstado();
		this.cidade = adv.getCidade();
		this.quantidadeCasosAtendidos = adv.getQuantidadeCasosAtendidos();
		this.advogadoCasoDTO = adv.getAdvogadoCaso().stream().map(ac -> new AdvogadoCasoDTO(ac)).collect(Collectors.toList());
		
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

	public String getOab() {
		return oab;
	}

	public void setOab(String oab) {
		this.oab = oab;
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

	public Integer getQuantidadeCasosAtendidos() {
		return quantidadeCasosAtendidos;
	}

	public void setQuantidadeCasosAtendidos(Integer quantidadeCasosAtendidos) {
		this.quantidadeCasosAtendidos = quantidadeCasosAtendidos;
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

	public List<AdvogadoCasoDTO> getAdvogadoCasoDTO() {
		return advogadoCasoDTO;
	}

	public void addAdvogadoCasoDTO(AdvogadoCasoDTO advogadoCasoDTO) {
		this.advogadoCasoDTO.add(advogadoCasoDTO);
	}
	
	
	
	
	
	
}
