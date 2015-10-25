/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdg.hackathon.eucidadao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Solicitacao extends BaseEntity<Long> {

    public Solicitacao(Servico servico, Usuario usuario, Double latitude, Double longitude, String observacao) {
        this.servico = servico;
        this.usuario = usuario;
        this.latitude = latitude;
        this.longitude = longitude;
        this.observacao = observacao;
    }

    public Solicitacao() {
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "servico_id", nullable = false)
    private Servico servico;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @NotNull
    @Column
    private Double latitude;

    @NotNull
    @Column
    private Double longitude;

    @Column
    private String observacao;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    @Column(name = "data_abertura", updatable = false)
    private Date dataAbertura;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_resolucao")
    private Date dataResolucao;
    
    @OneToMany(mappedBy = "solicitacao")
    private List<Visualizacao> visualizacoes;

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @JsonProperty
    public Date getDataAbertura() {
        return dataAbertura;
    }

    public Date getDataResolucao() {
        return dataResolucao;
    }

    public void setDataResolucao(Date dataResolucao) {
        this.dataResolucao = dataResolucao;
    }

    public List<Visualizacao> getVisualizacoes() {
        return visualizacoes;
    }

    public void setVisualizacoes(List<Visualizacao> visualizacoes) {
        this.visualizacoes = visualizacoes;
    }

    @PrePersist
    public void prePersist() {
        this.dataAbertura = new Date();
    }

}
