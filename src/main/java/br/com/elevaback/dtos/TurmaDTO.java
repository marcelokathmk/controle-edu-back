package br.com.elevaback.dtos;

import javax.validation.constraints.Positive;

public class TurmaDTO extends BaseDTO{

	@Positive(message = "A escola é de preenchimento obrigatório")
	private Long escola;

	public Long getEscola() {
		return escola;
	}

	public void setEscola(Long escola) {
		this.escola = escola;
	}
}
