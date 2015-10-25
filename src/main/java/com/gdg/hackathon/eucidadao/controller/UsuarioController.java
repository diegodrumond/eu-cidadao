package com.gdg.hackathon.eucidadao.controller;

import com.gdg.hackathon.eucidadao.model.Usuario;
import com.gdg.hackathon.eucidadao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController("/usuarios")
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public Iterable<Usuario> getAll() {
        return repository.findAll();
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Long save(Usuario usuario) {
        return repository.save(usuario).getId();
    }

    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public Usuario getOne(@PathVariable Long id) {
        return repository.findOne(id);
    }
}

