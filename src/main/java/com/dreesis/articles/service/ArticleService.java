package com.dreesis.articles.service;


import com.dreesis.articles.domaine.Article;
import com.dreesis.articles.domaine.Categorie;
import com.dreesis.articles.domaine.Source;
import com.dreesis.articles.repository.ArticleRepository;
import com.dreesis.articles.repository.CategorieRepository;
import com.dreesis.articles.repository.SourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ArticleService {

    private final ArticleRepository repository;
    private final SourceRepository sourceRepository;
    private final CategorieRepository categorieRepository;
    public ArticleService(ArticleRepository repository, SourceRepository sourceRepository, CategorieRepository categorieRepository){
        this.repository = repository;
        this.sourceRepository = sourceRepository;
        this.categorieRepository = categorieRepository;
    }

    @Transactional
    public List<Article> saveAllArticle(List<Article> articles){
        List<Article> articleList = new ArrayList<>();
        for(int i = 0 ; i < articles.size(); i++) {
            Source source = this.sourceRepository.findByNom(articles.get(i).getSource().getNom());
            if(source != null){
                articles.get(i).getSource().setId(source.getId());
            }
            Categorie categorie1 = null;
            if(articles.get(i).getSource() != null){
                Source source1 = sourceRepository.save(articles.get(i).getSource());
                articles.get(i).setSource(source1);
            }
            if (articles.get(i).getCategorie() != null){
                Categorie categorie = this.categorieRepository.findByNom(articles.get(i).getCategorie().getNom());
                if(categorie != null){
                    categorie1 = categorie;
                    articles.get(i).getCategorie().setId(categorie.getId());
                }else {
                    String categorieMin = articles.get(i).getCategorie().getNom().toUpperCase().trim();
                    articles.get(i).getCategorie().setNom(categorieMin);
                    Optional<Categorie> optCategorie = categorieRepository.findByNomExists(articles.get(i).getCategorie().getNom());
                    if(optCategorie.isPresent()){
                        categorie1 = optCategorie.get();
                        articles.get(i).setCategorie(categorie1);
                    }else{
                        categorie1 = categorieRepository.save(articles.get(i).getCategorie());
                        articles.get(i).setCategorie(categorie1);
                    }
                }
            }else {
                Optional<Categorie> categorie = categorieRepository.findById(3L);
                categorie1 = categorie.get();
                articles.get(i).setCategorie(categorie.get());
            }
            //System.err.println(articles.get(i));
            Article article2 = repository.findByTitre(articles.get(i).getTitre());
            articles.get(i).setCategorie(new Categorie(categorie1.getId()));
            if (article2 == null){
                Article article1 = this.repository.saveAndFlush(articles.get(i));
                articleList.add(article1);
            }

        }

        System.err.println(articleList);

      //  List<Article> articleList = this.repository.saveAll(articles);
        return articleList;
    }

    public List<Article> findByCategorie(String categorie){
        return repository.findByCategorie(categorie).subList(0, 15);
    }

    public  List<Article> findSourceByName(String sourceName){
        return repository.findSourceByName(sourceName);
    }

    public  List<Article> findSourceByPays(String sourcePays){
        return repository.findSourceByPays(sourcePays).subList(0, 10);
    }

    public List<Article> findByMonTitre(String titre){
        return repository.findByMonTitre(titre);
    }


   public Collection<List<Article>> getArticleDuJour(){
        List<List<Article>> articleHashMap = new ArrayList<>();
        List<Article> articleAfrimag = findSourceByName("Afrimag").subList(0, 2);
        List<Article> articleKoaci = findSourceByName("Koaci").subList(0, 2);
        List<Article> articleSenego = findSourceByName("Senego").subList(0, 2);
        List<Article> articleJeuneAfrique = findSourceByName("Jeune Afrique").subList(0, 2);
        List<Article> articleGabonReview = findSourceByName("Gabon Review").subList(0, 2);
        List<Article> articleDakarActu = findSourceByName("DakarActu").subList(0, 2);
        List<Article> articleLesEchos = findSourceByName("LesEchos-CongoBrazzaville").subList(0, 2);
        List<Article> articleCamerounInfo = findSourceByName("Cameroon-Info").subList(0, 2);
        List<Article> articleLinfodrome = findSourceByName("Linfodrome").subList(0, 2);
        List<Article> articleAps = findSourceByName("Aps").subList(0, 2);
        List<Article> articleJournalDeBrazza = findSourceByName("JournalDeBrazza").subList(0, 2);
        List<Article> articleAdiac = findSourceByName("Adiac-Congo").subList(0, 2);

        articleHashMap.add(articleAfrimag);
        articleHashMap.add(articleKoaci);
        articleHashMap.add(articleSenego);
        articleHashMap.add(articleJeuneAfrique);
        articleHashMap.add(articleGabonReview);
        articleHashMap.add(articleDakarActu);
        articleHashMap.add(articleLesEchos);
        articleHashMap.add(articleCamerounInfo);
        articleHashMap.add(articleLinfodrome);
       articleHashMap.add(articleAps);
       articleHashMap.add(articleJournalDeBrazza);
       articleHashMap.add(articleAdiac);
       return articleHashMap;
   }
}
