/**
 *
 */
package com.br.alldreams.jupiter.conteudo.termo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.alldreams.jupiter.base.BaseCommonsService;
import com.br.alldreams.jupiter.conteudo.termo.repository.TermoRepository;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 14:03:34
 */
@Log
@Service
public class TermoService extends BaseCommonsService {

    @Autowired
    private TermoRepository repositorio;

}
