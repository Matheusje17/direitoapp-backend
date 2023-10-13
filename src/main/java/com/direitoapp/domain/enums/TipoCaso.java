package com.direitoapp.domain.enums;

public enum TipoCaso {
	CIVIL(0,"Civil"), CRIMINAL(1,"Criminal"), TRABALHISTA(2,"Trabalhista"), CONSUMIDOR(3,"Consumidor");
	
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
	
	public static TipoCaso toEnum(String descricao) {
		if (descricao == null) {
			return null;
		}
		
		for (TipoCaso p : TipoCaso.values()) {
			if (descricao.equals(p.getDescricao())) {
				return p;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido");
		
	}
	
	
}
