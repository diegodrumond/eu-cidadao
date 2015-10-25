/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdg.hackathon.eucidadao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;

@Entity
public class Usuario extends BaseEntity<Long>{

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Usuario() {
        
    }
    
    @NotNull
    @Column(length = 150)
    private String nome;
    
    @NotNull
    @Column (length = 200)
    private String email;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    @Column(name = "data_cadastro", updatable = false)
    private Date dataCadastro;
    
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Visualizacao> visualizacoes;
    
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Solicitacao> solicitacoes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Visualizacao> getVisualizacoes() {
        return visualizacoes;
    }

    public void setVisualizacoes(List<Visualizacao> visualizacoes) {
        this.visualizacoes = visualizacoes;
    }

    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<Solicitacao> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }
    
    @PrePersist
    public void prePersist() {
        this.dataCadastro = new Date();
    }
    
    
}
