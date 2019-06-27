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

import br.com.elevaback.dtos.EscolaDTO;
import br.com.elevaback.services.EscolaService;
import br.com.elevaback.services.validation.EscolaValidation;

@RestController
@RequestMapping(value = "/escola")
public class EscolaHandler {

	@Autowired
	private EscolaService service;
	
	@Autowired
	private EscolaValidation validation;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EscolaDTO> find(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<EscolaDTO>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody EscolaDTO escolaDto){
		validation.validate(escolaDto);
		service.save(escolaDto);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody EscolaDTO escolaDto, @PathVariable Long id){
		validation.validate(escolaDto);
		service.save(escolaDto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		validation.validateDelete(id);
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
