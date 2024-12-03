package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.transaction.Status;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Departement {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nom;
    private int nbrMembre;
    @OneToMany(mappedBy = "departement")
    private Set<Filière> filières=new HashSet<Filière>();
}
