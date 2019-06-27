package br.com.elevaback.services.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.elevaback.dtos.EscolaDTO;
import br.com.elevaback.entities.Escola;
import br.com.elevaback.entities.Turma;
import br.com.elevaback.repositories.EscolaRepository;
import br.com.elevaback.repositories.TurmaRepository;
import br.com.elevaback.services.exception.RegistroExistenteException;
import br.com.elevaback.services.exception.ViolacaoChaveEstrangeiraException;

@Component
public class EscolaValidation {

	@Autowired
	private EscolaRepository repository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public void validate(EscolaDTO escolaDto) {
		validarDescricaoEscola(escolaDto.getDescricao());
	}
	
	public void validarDescricaoEscola(String descricao) {
		Escola escola = repository.findByDescricao(descricao);
		if	(escola != null) {
			throw new RegistroExistenteException("Já existe uma escola com este nome.");
		}
	}

	public void validateDelete(Long id) {
		List<Turma> turmas = turmaRepository.findByEscolaId(id);
		if	(!turmas.isEmpty()) {
			throw new ViolacaoChaveEstrangeiraException("Não é possível apagar a escola, pois a mesma possui turmas cadastradas.");
		}
	}
}
