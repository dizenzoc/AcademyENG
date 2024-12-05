package com.example.contattoservice.service;

import com.example.contattoservice.model.Contatto;
import com.example.contattoservice.repository.ContattoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContattoService implements ContattoServiceInterface{

    @Autowired
    private ContattoRepository contattoRepository;

    @Override
    public void save(Contatto contatto) {
        contattoRepository.save(contatto);
    }

    @Override
    public List<Contatto> findAll() {
        return contattoRepository.findAll();
    }

    @Override
    public Optional<Contatto> findById(Long id) {
        return contattoRepository.findById(id);
    }
}
