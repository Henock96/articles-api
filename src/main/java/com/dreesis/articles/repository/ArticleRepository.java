package com.dreesis.articles.repository;

import com.dreesis.articles.domaine.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findByTitre(String titre);

    @Query("Select a from Article a left join Categorie c on a.categorie.id = c.id  where c.nom = :categorie order by a.created desc")
    List<Article> findByCategorie(String categorie);

    @Query("Select a from Article a left join Source s on a.source.id = s.id  where s.nom = :sourceName order by a.created desc")
    List<Article> findSourceByName(String sourceName);

    @Query("Select a from Article a left join Source s on a.source.id = s.id  where s.pays IN :sourcePays order by a.created desc")
    List<Article> findSourceByPays(String sourcePays);

    @Query("select a from Article a where fts (:titre) = true")
    List<Article> findByMonTitre(@Param("titre")String titre);
}