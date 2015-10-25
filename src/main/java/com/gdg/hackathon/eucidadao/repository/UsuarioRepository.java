/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdg.hackathon.eucidadao.repository;

import com.gdg.hackathon.eucidadao.model.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author lucas
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    public Usuario findByEmail(String email);
}
