package br.com.elevaback.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.elevaback.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{

	List<Turma> findByEscolaId(Long id);
	
	Turma findByDescricao(String descricao);

}
