/**
 *
 */
package com.br.alldreams.jupiter.base;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import com.br.alldreams.jupiter.base.exception.BaseException;
import com.br.alldreams.jupiter.base.exception.service.DadosInvalidosServiceException;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @since 12 de jan de 2020 04:25:14
 * @version 1.0
 */
@Log
public abstract class BaseCommonsController { // extends AbstractController {

    public ModelAndView tratarException(final Exception ex, final String exceptionPath) {
        final ModelAndView model = new ModelAndView(exceptionPath);
        if (ex instanceof BaseException) {
            model.addObject("mensagem", ((BaseException) ex).getDescricao());
            model.addObject("codigo", ((BaseException) ex).getCodigo());
            model.setStatus(((BaseException) ex).getStatus());
            if (ex instanceof DadosInvalidosServiceException) {
                model.addObject("campos", ((DadosInvalidosServiceException) ex).getCampos());
                model.addObject("mensagens", ((DadosInvalidosServiceException) ex).getMensagens());
            }
        } else {
            model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            model.addObject("mensagem", ex.getMessage());
        }
        model.addObject("exception", ex);
        return model;
    }
}
