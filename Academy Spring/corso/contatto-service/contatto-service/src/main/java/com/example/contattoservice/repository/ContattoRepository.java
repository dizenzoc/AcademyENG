package com.example.contattoservice.repository;

import com.example.contattoservice.model.Contatto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Long> {

    List<Contatto> findAll();

    Optional<Contatto> findById(Long id);
}