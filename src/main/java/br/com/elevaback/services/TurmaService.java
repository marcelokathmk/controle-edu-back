package br.com.elevaback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.elevaback.converters.TurmaConverter;
import br.com.elevaback.dtos.TurmaDTO;
import br.com.elevaback.entities.Turma;
import br.com.elevaback.repositories.TurmaRepository;

@Service
public class TurmaService implements BaseService<TurmaDTO>{

	@Autowired
	private TurmaRepository repository;
	
	@Override
	public TurmaDTO findById(Long id) {
		Turma turma = repository.findById(id).orElse(null);
		return turma != null ? TurmaConverter.entityToDto(turma) : null;
	}

	@Override
	@Transactional
	public void save(TurmaDTO turmaDto) {
		repository.save(TurmaConverter.dtoToEntity(turmaDto));
	}

	@Override
	public List<TurmaDTO> findAll() {
		List<Turma> turmas = repository.findAll();
		return TurmaConverter.entitiesToDtos(turmas);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public List<TurmaDTO> findByEscola(Long id) {
		List<Turma> turmas = repository.findByEscolaId(id);
		return TurmaConverter.entitiesToDtos(turmas);
	}

}
