/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdg.hackathon.eucidadao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lucas
 */
@Entity
public class Servico extends BaseEntity<Long> {

    public Servico(TipoServicoEnum tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Servico() {
    }

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column
    private TipoServicoEnum tipo;

    @NotNull
    @Column(length = 255)
    private String descricao;

    public TipoServicoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicoEnum tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
