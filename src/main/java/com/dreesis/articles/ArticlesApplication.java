package com.dreesis.articles;

import com.dreesis.articles.domaine.Article;
import com.dreesis.articles.service.ArticleService;
import com.dreesis.articles.utils.ExtractionSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class ArticlesApplication implements CommandLineRunner {

    final ArticleService articleService;

    public ArticlesApplication(ArticleService articleService) {
        this.articleService = articleService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ArticlesApplication.class, args);
    }

    @Override
    public void run(String... args) {
    }

    @Scheduled(cron = "0 */180 * * * ?")
    public void perform(){
        List<Article> articles5 = ExtractionSource.getAdiacCongo();
        List<Article> articles6 = ExtractionSource.getGabonReview();
        List<Article> articles7 = ExtractionSource.getCamerounInfo();
        List<Article> articles8 = ExtractionSource.getLinfodrome();
        List<Article> articles9 = ExtractionSource.getAps();
        List<Article> articles10 = ExtractionSource.getDakarActu();
        List<Article> articles11 = ExtractionSource.getAfrimag();
        articleService.saveAllArticle(articles6);
        articleService.saveAllArticle(articles7);
        articleService.saveAllArticle(articles8);
        articleService.saveAllArticle(articles9);
        articleService.saveAllArticle(articles10);
        articleService.saveAllArticle(articles11);
        articleService.saveAllArticle(articles5);
        System.err.println("Enregistrement des articles toutes les 180 minutes donc 3 heures");
    }

    @Scheduled(cron = "0 */240 * * * ?")
    public void perform2(){
        List<Article> articles = ExtractionSource.getKoaciExtract();
        List<Article> articles1 = ExtractionSource.getJournalDeBrazza();
        List<Article> articles2 = ExtractionSource.getJeuneAfrique();
        List<Article> articles3 = ExtractionSource.getSenego();
        List<Article> articles4 = ExtractionSource.getLesEchosExtraction();
        articleService.saveAllArticle(articles);
        articleService.saveAllArticle(articles1);
        articleService.saveAllArticle(articles2);
        articleService.saveAllArticle(articles3);
        articleService.saveAllArticle(articles4);
        System.err.println("Enregistrement des articles toutes 240 minutes donc 4 heures");
    }


}
