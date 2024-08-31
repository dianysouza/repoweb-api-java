package com.repoweb.controller;

import com.repoweb.model.Usuario;
import com.repoweb.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Usuario> buscarUsuarioPorUsuarioESenha(@RequestParam(value = "nomeUsuario") String nomeUsuario,
                                                                 @RequestParam(value = "senhaUsuario") String senhaUsuario) {

        Usuario usuarioExample = new Usuario();
        usuarioExample.setNm_usuario(nomeUsuario);
        usuarioExample.setDs_senha(senhaUsuario);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("nm_usuario", exact())
                .withMatcher("ds_senha", exact());

        Example<Usuario> example = Example.of(usuarioExample, matcher);

        Optional<Usuario> usuario = usuarioRepository.findOne(example);

        return usuario
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
