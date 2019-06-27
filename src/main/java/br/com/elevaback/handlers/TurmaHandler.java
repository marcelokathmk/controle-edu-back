package br.com.elevaback.handlers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.elevaback.dtos.TurmaDTO;
import br.com.elevaback.services.TurmaService;
import br.com.elevaback.services.validation.TurmaValidation;

@RestController
@RequestMapping(value = "/turma")
public class TurmaHandler {

	@Autowired
	private TurmaService service;
	
	@Autowired
	private TurmaValidation validator;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TurmaDTO> find(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@GetMapping(value = "/escola/{id}")
	public ResponseEntity<List<TurmaDTO>> findByEscola(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findByEscola(id));
	}
	
	@GetMapping
	public ResponseEntity<List<TurmaDTO>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody TurmaDTO turmaDto){
		validator.validate(turmaDto);
		service.save(turmaDto);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody TurmaDTO turmaDto, @PathVariable Long id){
		validator.validate(turmaDto);
		service.save(turmaDto);
		return ResponseEntity.ok().build();
	}
}
