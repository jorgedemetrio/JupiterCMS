/**
 *
 */
package com.br.alldreams.jupiter.termo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.alldreams.jupiter.base.BaseService;
import com.br.alldreams.jupiter.termo.repository.TermoRepository;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 14:03:34
 */
@Log
@Service
public class TermoService extends BaseService {

    @Autowired
    private TermoRepository repositorio;

}
