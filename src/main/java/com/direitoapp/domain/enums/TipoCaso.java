package com.direitoapp.domain.enums;

public enum TipoCaso {
	CIVIL(0,"CAUSA_CIVIL"), CRIMINAL(1,"CAUSA_CRIMINAL"), TRABALHISTA(2,"CAUSA_TRABALHISTA"), CONSUMIDOR(3,"CAUSA_CONSUMIDOR");
	
	private Integer codigo;
	private String descricao;
	
	private TipoCaso(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCaso toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (TipoCaso p : TipoCaso.values()) {
			if (cod.equals(p.getCodigo())) {
				return p;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido");
		
	}
	
	public static TipoCaso toEnum(String name) {
		if (name == null) {
			return null;
		}
		
		for (TipoCaso p : TipoCaso.values()) {
			if (name.equals(p.name())) {
				return p;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido");
		
	}
	
	
}
