package com.direitoapp.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.direitoapp.domain.dtos.AdvogadoDTO;
import com.direitoapp.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;



@Entity
public class Advogado extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	@Column(unique = true)
	private String oab;
	private Integer quantidadeCasosAtendidos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "advogadoAtendimento")
	private List<AdvogadoCaso> advogadoCaso = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "advogado")
	private List<Caso> casos = new ArrayList<Caso>();
	
	public Advogado() {
		super();
	}
	
	public Advogado(Integer id, String nome, String email, String celular, Boolean isAdvogado, String senha,
			String cep, String oab) {
		super(id, nome, email, celular, isAdvogado, senha, cep);
		this.oab = oab;
		addPerfil(Perfil.ADVOGADO);
		setQuantidadeCasosAtendidos(0);
	}
	
	public Advogado(AdvogadoDTO advDTO) {
		super();
		this.id = advDTO.getId();
		this.nome = advDTO.getNome();
		this.celular = advDTO.getCelular();
		this.isAdvogado = advDTO.getIsAdvogado();
		this.senha = advDTO.getSenha();
		this.cep = advDTO.getCep();
		this.perfis = advDTO.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = advDTO.getDataCriacao();
		this.oab = advDTO.getOab();
		this.quantidadeCasosAtendidos = advDTO.getQuantidadeCasosAtendidos();
	}
	

	public String getOab() {
		return oab;
	}

	public void setOab(String oab) {
		this.oab = oab;
	}

	public Integer getQuantidadeCasosAtendidos() {
		return quantidadeCasosAtendidos;
	}

	public void setQuantidadeCasosAtendidos(Integer quantidadeCasosAtendidos) {
		this.quantidadeCasosAtendidos = quantidadeCasosAtendidos;
	}

	public List<Caso> getCasos() {
		return casos;
	}

	public void setCasos(List<Caso> casos) {
		this.casos = casos;
	}

	public List<AdvogadoCaso> getAdvogadoCaso() {
		return advogadoCaso;
	}

	public void addAdvogadoCaso(AdvogadoCaso advogadoCaso) {
		this.advogadoCaso.add(advogadoCaso);
	}
	
	
	
	
	
	
}
