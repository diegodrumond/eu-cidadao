package com.gdg.hackathon.eucidadao.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class EuCidadaoController {
    
    @RequestMapping("/")
    public String index() {
        return "Hi";
    }
    
}

