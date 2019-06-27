package br.com.elevaback.dtos;

import javax.validation.constraints.NotEmpty;

public class BaseDTO {

	private Long id;

	@NotEmpty(message = "O nome é de preenchimento obrigatório")
	private String descricao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
