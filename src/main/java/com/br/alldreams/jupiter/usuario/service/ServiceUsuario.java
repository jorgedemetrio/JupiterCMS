/**
 *
 */
package com.br.alldreams.jupiter.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.alldreams.jupiter.base.BaseService;
import com.br.alldreams.jupiter.usuario.repository.UsuarioRepository;

import lombok.extern.java.Log;

/**
 * @author Jorge Demetrio
 * @version 1.0.0
 * @since 15 de jan de 2020 15:04:30
 */
@Log
@Service
public class ServiceUsuario extends BaseService{

    @Autowired
    private UsuarioRepository repositorio;

}
