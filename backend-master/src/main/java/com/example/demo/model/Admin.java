package com.example.demo.model;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("Admin")
public class Admin extends User{
	
	@OneToMany(mappedBy = "admin")
	private Set<Publication> publications=new HashSet<Publication>();
	
	@OneToMany(mappedBy = "admin")
	private Set<Professeur> professeurs=new HashSet<Professeur>();
	
	@OneToMany(mappedBy = "admin")
	private Set<Étudiant> etudiants=new HashSet<Étudiant>();

}
