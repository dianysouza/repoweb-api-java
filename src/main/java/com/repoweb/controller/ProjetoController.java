package com.repoweb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.repoweb.model.Projeto;
import com.repoweb.repository.IProjetoRepository;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class ProjetoController {
    
    @Autowired
	private IProjetoRepository projetoRepository;
	
	@RequestMapping(value = "/cadastraProjeto", method =  RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Projeto salvarProjeto(@RequestBody @Valid Projeto projeto) {
		return projetoRepository.save(projeto);
	}

	@RequestMapping(value = "/visualizaProjeto/{id}", method=RequestMethod.GET)
	public ResponseEntity<Projeto> visualizarProjeto(@PathVariable(value = "id") long id) {
		Optional<Projeto> projeto = projetoRepository.findById(id);
        if(projeto.isPresent()) {
			return new ResponseEntity<Projeto>(projeto.get(), HttpStatus.OK);
		}
        else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/atualizaAcessos/{id}", method = RequestMethod.PUT)
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

	@RequestMapping(value = "/removeProjeto/{id}", method=RequestMethod.DELETE)
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
