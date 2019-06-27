package br.com.elevaback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.elevaback.entities.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long>{

	public Escola findByDescricao(String descricao);

}
