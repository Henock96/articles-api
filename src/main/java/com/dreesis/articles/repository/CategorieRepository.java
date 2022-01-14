package com.dreesis.articles.repository;

import com.dreesis.articles.domaine.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    Categorie findByNom(String nom);

    @Query("select c from Categorie c where c.nom = :#{#categorie.nom}")
    Optional<Categorie> findIfExists(@Param("categorie") Categorie categorie);

    @Query("select c from Categorie c where c.nom = :nom")
    Optional<Categorie> findByNomExists(@Param("nom") String nom);
}