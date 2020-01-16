/**
 *
 */
package com.br.alldreams.jupiter.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.alldreams.jupiter.base.BaseService;
import com.br.alldreams.jupiter.usuario.repository.GrupoRepository;

import lombok.extern.java.Log;

/**
 * @author Jess
 * @version 1.0
 * @since 16 de jan de 2020 00:37:24
 */
@Log
@Service
public class GrupoService extends BaseService {

    @Autowired
    private GrupoRepository repositorio;

    public void salvarGrupo() {

    }
}
