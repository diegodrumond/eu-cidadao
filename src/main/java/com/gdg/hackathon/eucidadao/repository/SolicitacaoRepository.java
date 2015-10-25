/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdg.hackathon.eucidadao.repository;

import com.gdg.hackathon.eucidadao.model.Solicitacao;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author lucas
 */
public interface SolicitacaoRepository extends CrudRepository<Solicitacao, Long> {
    
}
