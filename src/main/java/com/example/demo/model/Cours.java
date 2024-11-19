package com.example.demo.model;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Cours {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCours;  //autoincrement
	private String titre;
	@Lob
    private byte[] contenu;
    
	@ManyToOne
    private Professeur professeur;
	
	@ManyToOne
    private Élément element;
	
	@ManyToMany(mappedBy = "cours")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Étudiant> etudiants;

}
