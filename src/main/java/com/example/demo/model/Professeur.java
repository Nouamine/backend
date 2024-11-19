package com.example.demo.model;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
@DiscriminatorValue("Professeur")
public class Professeur extends User {

	@OneToMany(mappedBy = "professeur")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Cours> cours=new HashSet<Cours>();
	
	@ManyToOne
    private Admin admin;
}
