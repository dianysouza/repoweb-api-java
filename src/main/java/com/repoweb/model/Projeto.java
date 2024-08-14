package com.repoweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cd_projeto;
    
    @Column(nullable = false)
	@NotEmpty(message = "{campo.nm_autores.obrigatorio}")
	@Length(max = 150,message="{campo.nm_autores.caracteres}")
	@NotNull(message="{campo.nm_autores.nulo}")
	private String nm_autores;

    @Column(nullable = false)
	@NotEmpty(message = "{campo.nm_orientador.obrigatorio}")
	@Length(max = 45,message="{campo.nm_orientador.caracteres}")
	@NotNull(message="{campo.nm_orientador.nulo}")
	private String nm_orientador;

    @Column(nullable = false)
	@NotEmpty(message = "{campo.nm_curso.obrigatorio}")
	@Length(max = 45,message="{campo.nm_curso.caracteres}")
	@NotNull(message="{campo.nm_curso.nulo}")
	private String nm_curso;

    @Column(nullable = false)
	@NotEmpty(message = "{campo.aa_projeto.obrigatorio}")
	@Length(max = 4,message="{campo.aa_projeto.caracteres}")
	@NotNull(message="{campo.aa_projeto.nulo}")
	private String aa_projeto;

    @Column(nullable = false)
	@NotEmpty(message = "{campo.nm_projeto.obrigatorio}")
	@Length(max = 45,message="{campo.nm_projeto.caracteres}")
	@NotNull(message="{campo.nm_projeto.nulo}")
	private String nm_projeto;

    @Column(nullable = false)
	@NotEmpty(message = "{campo.nm_classificacao.obrigatorio}")
	@Length(max = 45,message="{campo.nm_classificacao.caracteres}")
	@NotNull(message="{campo.nm_classificacao.nulo}")
	private String nm_classificacao;

    @Column(nullable = false)
	@NotEmpty(message = "{campo.cd_cutter.obrigatorio}")
	@Length(max = 45,message="{campo.cd_cutter.caracteres}")
	@NotNull(message="{campo.cd_cutter.nulo}")
	private String cd_cutter;

    @Column(nullable = false)
	@NotEmpty(message = "{campo.ar_projeto.obrigatorio}")
	@Length(max = 500,message="{campo.ar_projeto.caracteres}")
	@NotNull(message="{campo.ar_projeto.nulo}")
	private String ar_projeto;

    @Column(nullable = false)
    @NotNull()
	private Integer qt_acesso = 0;

	public void incrementaQtAcesso() {
        this.qt_acesso++;
    }
}
