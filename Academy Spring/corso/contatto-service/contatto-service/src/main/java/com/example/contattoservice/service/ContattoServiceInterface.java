package com.example.contattoservice.service;

import com.example.contattoservice.model.Contatto;

import java.util.List;
import java.util.Optional;

public interface ContattoServiceInterface {

    public void save(Contatto contatto);

    List<Contatto> findAll();

    Optional<Contatto> findById(Long id);
}
