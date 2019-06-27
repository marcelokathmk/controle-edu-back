package br.com.elevaback.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.elevaback.dtos.TurmaDTO;
import br.com.elevaback.entities.Escola;
import br.com.elevaback.entities.Turma;

public class TurmaConverter {

	private TurmaConverter() {
	}
	
	public static TurmaDTO entityToDto(Turma turma) {
		TurmaDTO dto = new TurmaDTO();
		BeanUtils.copyProperties(turma, dto);
		dto.setEscola(turma.getEscola().getId());
		return dto;
	}
	
	public static Turma dtoToEntity(TurmaDTO turmaDto) {
		Turma turma = new Turma();
		BeanUtils.copyProperties(turmaDto, turma);
		Escola escola = new Escola();
		escola.setId(turmaDto.getEscola());
		turma.setEscola(escola);
		return turma;
	}
	
	public static List<TurmaDTO> entitiesToDtos(List<Turma> turmas){
		List<TurmaDTO> turmasDto = new ArrayList<>();
		for	(Turma t: turmas) {
			turmasDto.add(entityToDto(t));
		}
		return turmasDto;
	}
}
