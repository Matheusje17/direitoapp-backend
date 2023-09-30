package com.direitoapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.direitoapp.domain.dtos.CasoDTO;
import com.direitoapp.domain.enums.Status;
import com.direitoapp.domain.enums.TipoCaso;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;



@Entity
public class Caso implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private Boolean isUrgente;
	private String descricao;
	private Status status;
	private TipoCaso tipoCaso;
	private String estado;
	private String cidade;
	
	@JsonFormat(pattern = "dd/MM/YYYY")
	private LocalDate dataCriacao = LocalDate.now();
	
	@ManyToOne
	@JoinColumn(name = "advogado_id")
	private Advogado advogado;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "caso")
	private List<AdvogadoCaso> advogadoCaso = new ArrayList<>();
	

	public Caso() {
		super();
	}

	public Caso(Integer id, String titulo, Boolean isUrgente, String descricao, Status status, TipoCaso tipoCaso,
			 Cliente cliente, Advogado advogado, String estado, String cidade) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.isUrgente = isUrgente;
		this.descricao = descricao;
		this.status = status;
		this.tipoCaso = tipoCaso;
		this.cliente = cliente;
		this.advogado = advogado;
		this.estado = estado;
		this.cidade = cidade;
	}
	
	public Caso(CasoDTO casoDTO) {
		super();
		this.id = casoDTO.getId();
		this.titulo = casoDTO.getTitulo();
		this.isUrgente = casoDTO.getIsUrgente();
		this.descricao = casoDTO.getDescricao();
		this.status = Status.toEnum(casoDTO.getStatus()) ;
		this.tipoCaso = TipoCaso.toEnum(casoDTO.getTipoCaso());
		this.estado = casoDTO.getEstado();
		this.cidade = casoDTO.getCidade();
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

	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return this.status;
	}

	public TipoCaso getTipoCaso() {
		return tipoCaso;
	}

	public void setTipoCaso(TipoCaso tipoCaso) {
		this.tipoCaso = tipoCaso;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<AdvogadoCaso> getAdvogadoCaso() {
		return advogadoCaso;
	}

	public void setAdvogadoCaso(AdvogadoCaso advogadoCaso) {
		this.advogadoCaso.add(advogadoCaso);
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
