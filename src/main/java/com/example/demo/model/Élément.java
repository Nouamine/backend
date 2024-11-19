package com.example.demo.model;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Élément {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idElement;
    private String nomElement;
	
    @OneToMany(mappedBy = "element")
    @OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Cours> cours=new HashSet<Cours>();
    
}
