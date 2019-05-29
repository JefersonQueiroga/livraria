package br.ifrn.edu.livraria.model;

public enum Sexo {
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private String descricao;
	
	private Sexo(String desc) {
		this.descricao=desc;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
			
}
