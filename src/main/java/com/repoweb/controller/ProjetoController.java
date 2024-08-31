package com.repoweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.repoweb.model.Projeto;
import com.repoweb.repository.IProjetoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    
    @Autowired
	private IProjetoRepository projetoRepository;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Projeto salvarProjeto(@RequestBody @Valid Projeto projeto) {
		return projetoRepository.save(projeto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Projeto> visualizarProjeto(@PathVariable(value = "id") long id) {
		Optional<Projeto> projeto = projetoRepository.findById(id);
        return projeto.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping
	public ResponseEntity<List<Projeto>> listarProjetos() throws InterruptedException {
		List<Projeto> projeto = projetoRepository.findAll();
		return new ResponseEntity<>(projeto, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}/acessos")
	public ResponseEntity<Projeto> atualizaAcessos(@PathVariable(value = "id") long id) {
		try {
			Optional<Projeto> projeto = projetoRepository.findById(id);

			if (projeto.isPresent()) {
				Projeto retornoProjeto = projeto.get();
				retornoProjeto.incrementaQtAcesso();
				projetoRepository.save(retornoProjeto);
				return new ResponseEntity<Projeto>(projeto.get(), HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Projeto> removeProjeto (@PathVariable(value = "id") long id) {
		Optional<Projeto> projeto = projetoRepository.findById(id);
		if(projeto.isPresent()) {
			projetoRepository.delete(projeto.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
