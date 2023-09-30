package com.direitoapp.domain.dtos;

import java.io.Serializable;

import com.direitoapp.domain.Advogado;
import com.direitoapp.domain.AdvogadoCaso;
import com.direitoapp.domain.Caso;
import com.direitoapp.domain.Cliente;

public class AdvogadoCasoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	//CASO
	private Integer id;
	private Integer idCaso;
	private String titulo;
	private Boolean isUrgente;
	private String descricao;
	private Integer status;
	private Integer tipoCaso;
	
	//ADVOGADO
	private Integer idAdvogadoAtendimento;
	private String oab;
	private Integer quantidadeCasosAtendidos;
	private String nomeAdvogado;
	
	//CLIENTE
	private Integer idCliente;
	private String nomeCliente;
	
	public AdvogadoCasoDTO() {
		super();
	}

	public AdvogadoCasoDTO(Integer id
		, Integer idCaso
		, String titulo
		, Boolean isUrgente
		, String descricao
		, Integer status
		, Integer tipoCaso
		, Integer idAdvogadoAtendimento
		, String oab
		,Integer quantidadeCasosAtendidos
		, String nomeAdvogado
		, Integer idCliente
		, String nomeCliente
		){
		
		super();
		this.id = id;
		this.idCaso = idCaso;
		this.titulo = titulo;
		this.isUrgente = isUrgente;
		this.descricao = descricao;
		this.status = status;
		this.tipoCaso = tipoCaso;
		this.idAdvogadoAtendimento = idAdvogadoAtendimento;
		this.oab = oab;
		this.quantidadeCasosAtendidos = quantidadeCasosAtendidos;
		this.nomeAdvogado = nomeAdvogado;
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
	}
	
	
	public AdvogadoCasoDTO(Caso caso, Advogado advogado, Cliente cliente) {
		this.idCaso = caso.getId();
		this.titulo = caso.getTitulo();
		this.isUrgente = caso.getIsUrgente();
		this.descricao = caso.getDescricao();
		this.status = caso.getStatus().getCodigo();
		this.tipoCaso = caso.getTipoCaso().getCodigo();
		this.idAdvogadoAtendimento = advogado.getId();
		this.oab = advogado.getOab();
		this.quantidadeCasosAtendidos = advogado.getQuantidadeCasosAtendidos();
		this.nomeAdvogado = advogado.getNome();
		this.idCliente = cliente.getId();
		this.nomeCliente = cliente.getNome();
	}
	
	public AdvogadoCasoDTO(AdvogadoCaso advogadoCaso) {
		this.id = advogadoCaso.getId();
		this.idCaso = advogadoCaso.getCaso().getId();
		this.titulo = advogadoCaso.getCaso().getTitulo();
		this.isUrgente = advogadoCaso.getCaso().getIsUrgente();
		this.descricao = advogadoCaso.getCaso().getDescricao();
		this.status = advogadoCaso.getStatus();
		this.tipoCaso = advogadoCaso.getCaso().getTipoCaso().getCodigo();
		this.idAdvogadoAtendimento = advogadoCaso.getAdvogadoAtendimento().getId();
		this.oab = advogadoCaso.getAdvogadoAtendimento().getOab();
		this.quantidadeCasosAtendidos = advogadoCaso.getAdvogadoAtendimento().getQuantidadeCasosAtendidos();
		this.nomeAdvogado = advogadoCaso.getAdvogadoAtendimento().getNome();
		this.idCliente = advogadoCaso.getCliente().getId();
		this.nomeCliente = advogadoCaso.getCliente().getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCaso() {
		return idCaso;
	}

	public void setIdCaso(Integer idCaso) {
		this.idCaso = idCaso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Boolean getIsUrgente() {
		return isUrgente;
	}

	public void setIsUrgente(Boolean isUrgente) {
		this.isUrgente = isUrgente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTipoCaso() {
		return tipoCaso;
	}

	public void setTipoCaso(Integer tipoCaso) {
		this.tipoCaso = tipoCaso;
	}

	public Integer getIdAdvogadoAtendimento() {
		return idAdvogadoAtendimento;
	}

	public void setIdAdvogadoAtendimento(Integer idAdvogadoAtendimento) {
		this.idAdvogadoAtendimento = idAdvogadoAtendimento;
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

	public String getNomeAdvogado() {
		return nomeAdvogado;
	}

	public void setNomeAdvogado(String nomeAdvogado) {
		this.nomeAdvogado = nomeAdvogado;
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	
	
	
	
	
	
	

}
