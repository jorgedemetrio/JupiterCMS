/**
 *
 */
package com.br.alldreams.jupiter.site.repository.domain;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.alldreams.jupiter.base.domain.ControleInformacaoAlteravel;

/**
 * @author Jorge Demetrio
 * @since 26 de jan de 2020 22:52:39
 * @version 1.0
 */
public class EmailConfig extends ControleInformacaoAlteravel {

    @NotEmpty
    @Column(name = "email", insertable = true, updatable = true, nullable = false, length = 200)
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type", insertable = true, updatable = true, nullable = false)
    private TipoClienteEmail tipo;

    @NotNull
    @Column(name = "default", insertable = true, updatable = true, nullable = false)
    private Boolean padrao;

    @NotNull
    @Column(name = "encrypted", insertable = true, updatable = true, nullable = false)
    private Boolean criptografado;

    @NotEmpty
    @Column(name = "server", insertable = true, updatable = true, nullable = false, length = 200)
    private String servidor;

    @NotEmpty
    @Column(name = "user", insertable = true, updatable = true, nullable = false, length = 200)
    private String usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "encryption_type", insertable = true, updatable = true, nullable = true)
    private TipoCriptografiaEmail tipoCriptografia;

}
