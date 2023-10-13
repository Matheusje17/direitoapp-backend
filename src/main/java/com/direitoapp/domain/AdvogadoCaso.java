package com.direitoapp.domain;

import java.io.Serializable;
import java.util.Objects;

import com.direitoapp.domain.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class AdvogadoCaso implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "caso_id")
	private Caso caso;
		
	@ManyToOne()
	@JoinColumn(name = "advogado_id")
	private Advogado advogadoAtendimento;
	
	@ManyToOne()
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	private Integer status;
	
	
	
	public AdvogadoCaso() {
		super();
	}
	public AdvogadoCaso(Caso caso, Advogado advogadoAtendimento, Cliente cliente) {
		super();
		this.caso = caso;
		this.cliente = cliente;
		this.advogadoAtendimento = advogadoAtendimento;
		this.status = Status.AGUARDANDO_CLIENTE.getCodigo();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Caso getCaso() {
		return caso;
	}
	public void setCaso(Caso caso) {
		this.caso = caso;
	}
	public Advogado getAdvogado() {
		return advogadoAtendimento;
	}
	public void setAdvogado(Advogado advogadoAtendimento) {
		this.advogadoAtendimento = advogadoAtendimento;
	}
	
	public Advogado getAdvogadoAtendimento() {
		return advogadoAtendimento;
	}
	public void setAdvogadoAtendimento(Advogado advogadoAtendimento) {
		this.advogadoAtendimento = advogadoAtendimento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(advogadoAtendimento, id, caso);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdvogadoCaso other = (AdvogadoCaso) obj;
		return Objects.equals(advogadoAtendimento, other.advogadoAtendimento) && Objects.equals(id, other.id)
				&& Objects.equals(caso, other.caso);
	}
	
	
}
