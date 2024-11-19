package com.example.demo.model;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Entity
@Data
public class Filière {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFilière;
	private String intituleFilière;
	
	@OneToMany(mappedBy = "filiere")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Étudiant> etudiants=new HashSet<Étudiant>();
	@ManyToOne
	private Departement departement;
}
