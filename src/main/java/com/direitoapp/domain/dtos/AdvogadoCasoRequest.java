package com.direitoapp.domain.dtos;

public class AdvogadoCasoRequest{
	
	private Integer casoId;
	private Integer clienteId;
	private Integer advogadoId;
	
	AdvogadoCasoRequest(Integer casoId, Integer clienteId, Integer advogadoId){
		this.casoId = casoId;
		this.clienteId = clienteId;
		this.advogadoId = advogadoId;
	}
	
	public AdvogadoCasoRequest() {
		super();
	}

	public Integer getCasoId() {
		return casoId;
	}

	public void setCasoId(Integer casoId) {
		this.casoId = casoId;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Integer getAdvogadoId() {
		return advogadoId;
	}

	public void setAdvogadoId(Integer advogadoId) {
		this.advogadoId = advogadoId;
	}




	
	
}