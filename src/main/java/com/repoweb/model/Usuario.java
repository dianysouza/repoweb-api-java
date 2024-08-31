package com.repoweb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_usuario;

    @Column(nullable = false)
    @NotEmpty(message = "{campo.nm_usuario.obrigatorio}")
    @Length(max = 45,message="{campo.nm_usuario.caracteres}")
    @NotNull(message="{campo.nm_usuario.nulo}")
    private String nm_usuario;

    @Column(nullable = false)
    @NotEmpty(message = "{campo.ds_senha.obrigatorio}")
    @Length(max = 45,message="{campo.ds_senha.caracteres}")
    @NotNull(message="{campo.ds_senha.nulo}")
    private String ds_senha;
}
