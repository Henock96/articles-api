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
        //**List<Article> articles5 = ExtractionSource.getAdiacCongo();


        //Group perfom 1
        //**List<Article> articles18 = ExtractionSource.getTelquel();
        //**List<Article> articles6 = ExtractionSource.getGabonReview();
        //**List<Article> articles7 = ExtractionSource.getCamerounInfo();
        //L'infodrome read timed out
        //***List<Article> articles8 = ExtractionSource.getLinfodrome();
        //***List<Article> articles9 = ExtractionSource.getAps();
        //***List<Article> articles11 = ExtractionSource.getAfrimag();
        //***List<Article> articles17 = ExtractionSource.getAfriqueitnews();

        // Group perform 2
        ///List<Article> articles20 = ExtractionSource.getScidev();
        ///List<Article> articles = ExtractionSource.getKoaciExtract();
        ///List<Article> articles1 = ExtractionSource.getJournalDeBrazza();
        ///List<Article> articles2 = ExtractionSource.getJeuneAfrique();
        ///List<Article> articles3 = ExtractionSource.getSenego();
        ///List<Article> articles16 = ExtractionSource.getAfriquelatribuneTechTelecoms();

        //Group perform 3
        ///List<Article> articles12 = ExtractionSource.getAfriquelatribuneTech();
        //List<Article> articles13 = ExtractionSource.getAfrikfoot();
        ///List<Article> articles14 = ExtractionSource.getAfriquelatribuneEconomie();
        ///List<Article> articles15 = ExtractionSource.getAfriquelatribunePolitique();
        ///List<Article> articles4 = ExtractionSource.getLesEchosExtraction();
        ///List<Article> articles22 = ExtractionSource.getVox();
        ///List<Article> articles10 = ExtractionSource.getDakarActu();
        //articles10.forEach(System.out::println);



    }

    @Scheduled(cron = "0 */180 * * * ?")
    public void perform(){
        //Split url format 18/02/2022
        List<Article> articles18 = ExtractionSource.getTelquel();
        List<Article> articles6 = ExtractionSource.getGabonReview();
        List<Article> articles8 = ExtractionSource.getLinfodrome();
        List<Article> articles9 = ExtractionSource.getAps();
        List<Article> articles11 = ExtractionSource.getAfrimag();
        List<Article> articles17 = ExtractionSource.getAfriqueitnews();

        articleService.saveAllArticle(articles18);
        articleService.saveAllArticle(articles6);
        articleService.saveAllArticle(articles8);
        articleService.saveAllArticle(articles9);
        articleService.saveAllArticle(articles17);
        articleService.saveAllArticle(articles11);
        //articleService.saveAllArticle(articles5);
        System.err.println("Enregistrement des articles toutes les 180 minutes donc 3 heures");
    }

    @Scheduled(cron = "0 */240 * * * ?")
    public void perform2(){
        List<Article> articles20 = ExtractionSource.getScidev();
        List<Article> articles = ExtractionSource.getKoaciExtract();
        List<Article> articles1 = ExtractionSource.getJournalDeBrazza();
        List<Article> articles2 = ExtractionSource.getJeuneAfrique();
        List<Article> articles3 = ExtractionSource.getSenego();
        List<Article> articles16 = ExtractionSource.getAfriquelatribuneTechTelecoms();
        List<Article> articlesAdiac = ExtractionSource.getAdiacCongo();
        articleService.saveAllArticle(articlesAdiac);
        articleService.saveAllArticle(articles20);
        articleService.saveAllArticle(articles);
        articleService.saveAllArticle(articles1);
        articleService.saveAllArticle(articles2);
        articleService.saveAllArticle(articles3);
        articleService.saveAllArticle(articles16);
        System.err.println("Enregistrement des articles toutes 240 minutes donc 4 heures");
    }
    @Scheduled(cron = "0 */240 * * * *")
    public void perform3(){
        //List<Article> articles21 = ExtractionSource.getMedia24();
        //Mise a jour 16/02/2022
        List<Article> articles12 = ExtractionSource.getAfriquelatribuneTech();
        List<Article> articles13 = ExtractionSource.getAfrikfoot();
        List<Article> articles14 = ExtractionSource.getAfriquelatribuneEconomie();
        List<Article> articles15 = ExtractionSource.getAfriquelatribunePolitique();
        List<Article> articles4 = ExtractionSource.getLesEchosExtraction();
        List<Article> articles22 = ExtractionSource.getVox();
        List<Article> articles10 = ExtractionSource.getDakarActu();

        //articleService.saveAllArticle(articles21);
        //
        articleService.saveAllArticle(articles22);
        articleService.saveAllArticle(articles12);
        articleService.saveAllArticle(articles13);
        articleService.saveAllArticle(articles14);
        articleService.saveAllArticle(articles15);
        articleService.saveAllArticle(articles4);
        articleService.saveAllArticle(articles10);
        System.err.println("Enregistrement des articles 2e groupe toutes 240 minutes donc 4 heures");
    }


}
