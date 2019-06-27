package br.com.elevaback.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.elevaback.dtos.EscolaDTO;
import br.com.elevaback.entities.Escola;

public class EscolaConverter {

	private EscolaConverter() {
		
	}
	
	public static EscolaDTO entityToDto(Escola escola) {
		EscolaDTO dto = new EscolaDTO();
		BeanUtils.copyProperties(escola, dto);
		return dto;
	}
	
	public static Escola dtoToEntity(EscolaDTO escolaDto) {
		Escola escola = new Escola();
		BeanUtils.copyProperties(escolaDto, escola);
		return escola;
	}
	
	public static List<EscolaDTO> entitiesToDtos(List<Escola> escolas){
		List<EscolaDTO> escolasDto = new ArrayList<>();
		for	(Escola e: escolas) {
			escolasDto.add(entityToDto(e));
		}
		
		return escolasDto;
	}
}
