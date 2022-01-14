package com.dreesis.articles.domaine;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "categorie_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nom;
    //@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    //private Set<Article> articles = new HashSet<>();

    public Categorie(Long id) {
        this.id = id;
    }
}