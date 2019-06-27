package br.com.elevaback.services.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.elevaback.dtos.TurmaDTO;
import br.com.elevaback.entities.Turma;
import br.com.elevaback.repositories.TurmaRepository;
import br.com.elevaback.services.exception.RegistroExistenteException;

@Component
public class TurmaValidation {

	@Autowired
	private TurmaRepository repository;
	
	public void validate(TurmaDTO turmaDto) {
		validateTurmaExistente(turmaDto.getDescricao());
	}
	
	private void validateTurmaExistente(String descricao) {
		Turma turma = repository.findByDescricao(descricao);
		if	(turma != null) {
			throw new RegistroExistenteException("Já existe uma turma com este nome.");
		}
	}
}
