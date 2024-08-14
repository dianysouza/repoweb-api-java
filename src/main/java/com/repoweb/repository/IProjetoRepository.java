package com.repoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repoweb.model.Projeto;

public interface IProjetoRepository extends JpaRepository<Projeto, Long> {
    
}
