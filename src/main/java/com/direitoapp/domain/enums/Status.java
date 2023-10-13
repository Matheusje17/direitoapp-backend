package com.direitoapp.domain.enums;

public enum Status {
	RECUSADO(0,"Recusado"), ACEITO(1,"Aceito"), AGUARDANDO_ADVOGADOS(2,"Aguardando Advogados"), AGUARDANDO_CLIENTE(1,"Aguardando Cliente"), COM_ACEITES(1,"Ccom Aceites");
	
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
	
	public static Status toEnum(String descricao) {
		if (descricao == null) {
			return null;
		}
		
		for (Status p : Status.values()) {
			if (descricao.equals(p.getDescricao())) {
				return p;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido");
		
	}
	
	
}
