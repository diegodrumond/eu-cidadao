/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdg.hackathon.eucidadao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Visualizacao extends BaseEntity<Long>{

    public Visualizacao() {
    }

    public Visualizacao(Usuario usuario, Solicitacao solicitacao) {
        this.usuario = usuario;
        this.solicitacao = solicitacao;
    }
    
    @JsonIgnore
    @ManyToOne(optional=false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @JsonIgnore
    @NotNull
    @ManyToOne(optional=false)
    @JoinColumn(name = "solicitacao_id", nullable = false)
    private Solicitacao solicitacao;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date dataVisualizacao;
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }
    
    @JsonProperty
    public Date getDataVisualizacao() {
        return dataVisualizacao;
    }

    @PrePersist
    public void prePersist(){
        this.dataVisualizacao = new Date();
    }
}
