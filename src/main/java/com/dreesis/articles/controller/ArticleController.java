package com.dreesis.articles.controller;

import com.dreesis.articles.domaine.Article;
import com.dreesis.articles.domaine.Source;
import com.dreesis.articles.service.ArticleService;
import com.dreesis.articles.service.SourceService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("v1/api")
public class ArticleController {
    final SourceService sourceService;
    final ArticleService articleService;

    private final Logger log = LoggerFactory.getLogger(ArticleController.class);

    public ArticleController(ArticleService articleService, SourceService sourceService) {
        this.articleService = articleService;
        this.sourceService = sourceService;
    }

    @GetMapping("/")
    public String getMessage() {
        String message = "Afronews Api application";
        log.info("Réponse depuis la méthode message");
        return message;
    }
    @ApiOperation("Tous les sources")
    @GetMapping("/sources/sources")
    public ResponseEntity<List<Source>> getAllSource() {
        List<Source> sources = sourceService.getSources();
        log.info("Réponse depuis la méthode getAllSource");
        return new ResponseEntity<>(sources, HttpStatus.OK);
    }
    @ApiOperation("Tous les articles du jour")
    @GetMapping("/articles/article-du-jour")
    public ResponseEntity<Collection<List<Article>>> getAllArticleDujour() {
        Collection<List<Article>> articles = articleService.getArticleDuJour();
        log.info("Réponse depuis la méthode getAllArticleDujour");
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @ApiOperation("Obtenir tous les articles par le nom de la categorie")
    @GetMapping("/categorie/{nom}")
    public ResponseEntity<List<Article>> getArticleByCategorie(@PathVariable("nom") String nom){
        List<Article> articles = articleService.findByCategorie(nom);
        log.info("Réponse depuis la méthode getArticleByCategorie");
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @ApiOperation("Obtenir tous les articles par le nom de la source")
    @GetMapping("/sources/{nom}")
    public ResponseEntity<List<Article>> getfindSourceByName(@PathVariable("nom") String nom){
        List<Article> articles = articleService.findSourceByName(nom);
        log.info("Réponse depuis la méthode getfindSourceByName");
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping("/source/{pays}")
    public ResponseEntity<List<Article>> getfindSourceByPays(@PathVariable("pays") String pays){
        List<Article> articles = articleService.findSourceByPays(pays);
        log.info("Réponse depuis la méthode getfindSourceByPays");
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @ApiOperation("Rechercher un article par son titre")
    @GetMapping("/article/{titre}")
    public ResponseEntity<List<Article>> getfindByTitre(@PathVariable("titre") String titre){
        List<Article> titres = articleService.findByMonTitre(titre);
        return new ResponseEntity<>(titres, HttpStatus.OK);
    }
}
