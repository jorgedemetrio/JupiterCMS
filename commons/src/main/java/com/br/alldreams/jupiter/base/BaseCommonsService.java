/**
 *
 */
package com.br.alldreams.jupiter.base;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.br.alldreams.jupiter.base.exception.BaseException;
import com.br.alldreams.jupiter.base.exception.service.DadosInvalidosServiceException;
import com.br.alldreams.jupiter.base.messagem.Messagem;

import lombok.Getter;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 03:46:14
 * @version 1.0
 */
@Getter
public abstract class BaseCommonsService {

    public static final int PADRO_MAXIMO_ITENS_PAGINA = 10;

    public static final int PAGINA_INICIAL = 1;

    @Autowired
    private Messagem mensagem;

    @Autowired
    private Validator validator;

    public <T extends BaseException> T createException(final String chave, final Class<T> tipo, final String... parametros) {
        return mensagem.createExcetion(chave, tipo, parametros);
    }

    public BaseException createException(final String chave, final String... parametros) {
        return mensagem.createExcetion(chave, parametros);
    }

    public String getNewId() {
        return UUID.randomUUID().toString();
    }

    public Pageable getPageable(final Integer pagina, final Integer itensPorPagina, final String ordem, final String sentido) {
        if (isNull(ordem) || ordem.isEmpty()) {
            return PageRequest.of(nonNull(pagina) ? pagina : PAGINA_INICIAL, nonNull(itensPorPagina) ? itensPorPagina : PADRO_MAXIMO_ITENS_PAGINA);
        }

        return PageRequest.of(nonNull(pagina) ? pagina : PAGINA_INICIAL, nonNull(itensPorPagina) ? itensPorPagina : PADRO_MAXIMO_ITENS_PAGINA,
                nonNull(sentido) ? Direction.fromString(sentido) : Direction.ASC, ordem);
    }

    public <T extends Object, X extends Serializable> Page<T> getPagina(final List<T> itens, final Page<X> origin) {
        return new PageImpl<>(itens, origin.getPageable(), origin.getTotalElements());
    }

    public void validar(final Serializable entidade) throws DadosInvalidosServiceException {
        final Set<ConstraintViolation<Object>> constraints = validator.validate(entidade);
        if (Objects.nonNull(constraints) && !constraints.isEmpty()) {
            final HashSet<String> campos = new HashSet<>();
            final HashSet<String> mensagens = new HashSet<>();
            final StringBuilder campoStr = new StringBuilder();
            for (final ConstraintViolation<Object> constraintViolation : constraints) {
                mensagens.add(constraintViolation.getMessage());
                campos.add(constraintViolation.getInvalidValue().toString());
                campoStr.append(constraintViolation.getInvalidValue().toString());
            }

            final DadosInvalidosServiceException exception = mensagem.createExcetion("campos-invalidos", DadosInvalidosServiceException.class,
                    campoStr.toString());

            exception.getCampos().addAll(campos);
            exception.getMensagens().addAll(mensagens);

            throw exception;

        }
    }
}
