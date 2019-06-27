package br.com.elevaback.services;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elevaback.converters.EscolaConverter;
import br.com.elevaback.dtos.EscolaDTO;
import br.com.elevaback.entities.Escola;
import br.com.elevaback.repositories.EscolaRepository;
import br.com.elevaback.services.exception.ViolacaoChaveEstrangeiraException;

@Service
public class EscolaService implements BaseService<EscolaDTO>{

	@Autowired
	private EscolaRepository repository;
	
	public EscolaDTO findById(Long idEscola) {
		Escola escola = repository.findById(idEscola).orElse(null);
		return escola != null ? EscolaConverter.entityToDto(escola) : null;
	}

	public void save(EscolaDTO escolaDto) {
		Escola escola = null;
		if	(escolaDto.getId() != null) {
			escola = repository.findById(escolaDto.getId()).orElse(null);
			escola.setDescricao(escolaDto.getDescricao());
		}else {
			escola = EscolaConverter.dtoToEntity(escolaDto);
		}
		
		try {
			repository.save(escola);
		} catch (ConstraintViolationException e) {
			throw new ViolacaoChaveEstrangeiraException("Já existe uma escola com este nome.");
		}
		
	}

	public List<EscolaDTO> findAll() {
		List<Escola> escolas = repository.findAll();
		return EscolaConverter.entitiesToDtos(escolas);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
