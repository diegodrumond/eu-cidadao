package com.gdg.hackathon.eucidadao.controller;

import com.gdg.hackathon.eucidadao.model.Servico;
import com.gdg.hackathon.eucidadao.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
    @Autowired
    private ServicoRepository repository;
    
    @RequestMapping("/all")
    public Iterable<Servico> getAll() {
        return repository.findAll();
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Long save(Servico servico) {
        return repository.save(servico).getId();
    }

    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public Servico getOne(@PathVariable Long id) {
        return repository.findOne(id);
    }
    
}

