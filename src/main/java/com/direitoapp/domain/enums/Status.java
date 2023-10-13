package com.direitoapp.domain.enums;

public enum Status {
	RECUSADO(0,"Recusado"), ACEITO(1,"Aceito"), AGUARDANDO(2,"Aguardando Advogados"), AGUARDANDO_CLIENTE(1,"Aguardando Cliente");
	
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
