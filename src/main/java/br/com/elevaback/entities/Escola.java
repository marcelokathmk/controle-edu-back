package br.com.elevaback.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Escola extends BaseEntity {

	@Column(name = "ds_escola", nullable = false, unique = true)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
