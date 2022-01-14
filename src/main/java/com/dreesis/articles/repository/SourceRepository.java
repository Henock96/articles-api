package com.dreesis.articles.repository;

import com.dreesis.articles.domaine.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {

    Source findByNom(String nom);

}