package com.example.contattoservice.controller;

import com.example.contattoservice.model.Contatto;
import com.example.contattoservice.service.ContattoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api/v1/contatti") //specifico mapping
public class ContattoController {

    @Autowired
    private ContattoServiceInterface contattoServiceI;

    @GetMapping("/api/v1/contatti")//specifico endpoint
    public List<Contatto> getAllContacs(){
        return contattoServiceI.findAll();
    }

    @GetMapping("/api/v1/contatti/{id}") //specifico endpoint
    public Optional<Contatto> getContactById(Long id){
        return contattoServiceI.findById(id);
    }

}
