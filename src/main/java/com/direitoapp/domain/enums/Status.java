package com.direitoapp.domain.enums;

public enum Status {
	RECUSADO(0,"STATUS_RECUSADO"), ACEITO(1,"STATUS_ACEITO"), AGUARDANDO(2,"STATUS_AGUARDANDO");
	
	private Integer codigo;
	private String descricao;
	
	private Status(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Status toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (Status p : Status.values()) {
			if (cod.equals(p.getCodigo())) {
				return p;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido");
		
	}
	
	public static Status toEnum(String name) {
		if (name == null) {
			return null;
		}
		
		for (Status p : Status.values()) {
			if (name.equals(p.name())) {
				return p;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido");
		
	}
	
	
}
