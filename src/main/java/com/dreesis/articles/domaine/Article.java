package com.dreesis.articles.domaine;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, columnDefinition = "TEXT")
    private String titre;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String url_image;
    @Column(columnDefinition = "TEXT")
    private String url_article;
    private String date_publication;
    private String auteur;
    @ManyToOne//(cascade = CascadeType.ALL)
   // @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "source_id")
    private Source source;

    private LocalDateTime created;

    //@PrePersist
    //public void init() {
     //   this.created = LocalDateTime.now();
   // }

}