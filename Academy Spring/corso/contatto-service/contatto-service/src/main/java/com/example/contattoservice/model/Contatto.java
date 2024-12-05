package com.example.contattoservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Contatti")
@Getter
@Setter
public class Contatto
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // e' il db ad occuparsi della generazione dell'id
    private Long id;
    private String nome;
    private String numero_telefono;
}
