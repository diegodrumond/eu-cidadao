package com.gdg.hackathon.eucidadao.controller;

import com.gdg.hackathon.eucidadao.model.Solicitacao;
import com.gdg.hackathon.eucidadao.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController("/solicitacoes")
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoRepository repository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Solicitacao> getAll() {
        return repository.findAll();
    }

    @RequestMapping(value ="/save", method = RequestMethod.POST)
    public Long save(Solicitacao solicitacao) {
        return repository.save(solicitacao).getId();
    }

    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public Solicitacao getOne(@PathVariable Long id) {
        return repository.findOne(id);
    }

}
