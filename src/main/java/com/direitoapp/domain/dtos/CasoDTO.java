package com.direitoapp.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.direitoapp.domain.Caso;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;



public class CasoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotNull(message = "O titulo deve ser informado!")
	private String titulo;
	
	@NotNull(message = "A urgência deve ser informada!")
	private Boolean isUrgente;
	
	@NotNull(message = "A descrição deve ser informado!")
	private String descricao;
	private String status;
	
	@NotNull(message = "O tipo de causa deve ser informado!")
	private String tipoCaso;
	private String nomeAdvogado;
	private String nomeCliente;
	private Integer advogadoId;
	private Integer clienteId;
	
	@JsonFormat(pattern = "dd/MM/YYYY")
	private LocalDate dataCriacao = LocalDate.now();
	
	private String cidade;
	private String estado;

	private List<AdvogadoCasoDTO> advogadoCasosList = new ArrayList<AdvogadoCasoDTO>();
	 

	public CasoDTO() {
		super();
	}

	public CasoDTO(Caso caso) {
		super();
		this.id = caso.getId();
		this.titulo = caso.getTitulo();
		this.isUrgente = caso.getIsUrgente();
		this.descricao = caso.getDescricao();
		this.status = caso.getStatus().name();
		this.tipoCaso = caso.getTipoCaso().name();
		this.nomeCliente = caso.getCliente().getNome();
		this.clienteId = caso.getCliente().getId();
		this.dataCriacao = caso.getDataCriacao();
		this.cidade = caso.getCidade();
		this.estado = caso.getEstado();
		this.advogadoCasosList = caso.getAdvogadoCaso().stream().map(ac -> new AdvogadoCasoDTO(ac)).collect(Collectors.toList());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipoCaso() {
		return tipoCaso;
	}

	public void setTipoCaso(String tipoCaso) {
		this.tipoCaso = tipoCaso;
	}

	public String getNomeAdvogado() {
		return nomeAdvogado;
	}

	public void setNomeAdvogado(String nomeAdvogado) {
		this.nomeAdvogado = nomeAdvogado;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Integer getAdvogadoId() {
		return advogadoId;
	}

	public void setAdvogadoId(Integer advogadoId) {
		this.advogadoId = advogadoId;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public List<AdvogadoCasoDTO> getAdvogadoCasoDTOList() {
		return this.advogadoCasosList;
	}
	
	public void addAdvogadoCasoDTOList(AdvogadoCasoDTO advogadoCasoDTO) {
		this.advogadoCasosList.add(advogadoCasoDTO);
	}
	
	
	
	
	
}
