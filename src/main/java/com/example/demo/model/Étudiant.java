package com.example.demo.model;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("Étudiant")
public class Étudiant extends User{
	
	private int niveauEtude;
	private boolean isReussi;

	@ManyToMany
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Cours> cours;
	
	@OneToMany(mappedBy = "etudiant")
	private Set<Notification> notifications=new HashSet<Notification>();
	
	@ManyToOne
    private Admin admin;
	
	@ManyToOne
    private Filière filiere;
	
	
}
