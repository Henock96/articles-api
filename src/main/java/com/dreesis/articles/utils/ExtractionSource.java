package com.dreesis.articles.utils;

import com.dreesis.articles.domaine.Article;
import com.dreesis.articles.domaine.Categorie;
import com.dreesis.articles.domaine.Source;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExtractionSource {
    public static List<Article> getAfrikfoot(){
        //Afrik-foot 21/01/2022
        String url = "https://www.afrik-foot.com/";
        List<Article> liste = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            //System.out.println(title);
            Elements docs = doc.select("div.td-main-content-wrap");
            Elements main = docs.select("div.td-container");
            Elements content = main.select("div.td-ss-main-content");
            for(Element tdmain : content){
                //System.out.println(tdmain);
                Elements arts = tdmain.select("div.td_module_10");

                for(Element art : arts){
                    Article article1 = new Article();
                    Source source = new Source();
                    source.setNom("Afrik-Foot");
                    source.setPays("Afrique");
                    source.setUrl_source(url);
                    article1.setSource(source);
                    Categorie categorie = new Categorie();
                    categorie.setNom("SPORT");
                    article1.setCategorie(categorie);
                    Elements thumb = art.select("div.td-module-thumb");
                    for(Element lien : thumb){

                        String liens = lien.select("a").attr("href");
                        article1.setUrl_article(liens);
                        Elements img = lien.select("a");
                        for(Element imglien : img){
                            String urlA = imglien.select("img").attr("data-img-url");
                            //System.out.println(urlA);
                            article1.setUrl_image(urlA);

                        }

                    }
                    Elements details = art.select("div.item-details");
                    for(Element detail : details){
                        String titre = detail.select("h3.entry-title").text();
                        article1.setTitre(titre);
                        //System.out.println(titre);
                    }
                    Elements dtime = details.select("div.td-module-meta-info").select("span.td-post-date");
                    for(Element datetime :dtime){
                        String temp = datetime.select("time").text();
                        //System.out.println(temp);
                        article1.setDate_publication(temp);
                    }
                    Elements desc = details.select("div.td-excerpt");
                    for(Element descpt : desc){
                        String description = descpt.text();
                        //System.out.println(description);
                        article1.setDescription(description);

                    }
                    liste.add(article1);
                }

            }
            //System.out.println(liste);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return liste;
    }
    public static List<Article> getAfriquelatribuneEconomie(){
        String url = "https://afrique.latribune.fr/economie";
        List<Article> liste = new ArrayList<>();
        try{
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            //System.out.println(title);
            Elements content = doc.select("div.row-custom");
            Elements docs = content.select("div.col-centrale");
            Elements main = docs.select("div.river");
            for(Element centre : main){
                Elements river = centre.select("article.article-wrapper");
                for(Element wrapper : river){
                    Elements wrap = wrapper.select("section.chapo");
                    Article article = new Article();
                    Source source = new Source();
                    source.setNom("Latribune");
                    source.setPays("Afrique");
                    source.setUrl_source(url);
                    article.setSource(source);
                    Categorie categorie = new Categorie();
                    categorie.setNom("ÉCONOMIE");
                    article.setCategorie(categorie);
                    for(Element chapo : wrap){
                        Elements titres = chapo.select("h2");
                        for(Element titre : titres){
                            String urlA = titre.select("a").attr("href");
                            //System.out.println(urlA);
                            article.setUrl_article(urlA);
                            String tit = titre.select("a").text();
                            //System.out.println(tit);
                            article.setTitre(tit);
                        }
                        Elements desc = chapo.select("p");
                        for(Element descs : desc){
                            String description = descs.text();
                            //System.out.println(description);
                            article.setDescription(description);
                        }
                    }
                    Elements wraps = wrapper.select("div.image-wrapper").select("a");
                    for(Element img : wraps){
                        String imageUrl = img.select("img").attr("src");
                        //System.out.println(imageUrl);
                        article.setUrl_image(imageUrl);
                        liste.add(article);
                    }
                }
            }
            //System.out.println(liste);
        }catch (Exception e){
            e.printStackTrace();
        }
        return liste;
    }
    public static List<Article> getAfriquelatribunePolitique(){
        String url = "https://afrique.latribune.fr/politique";
        List<Article> liste = new ArrayList<>();
        try{
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            //System.out.println(title);
            Elements content = doc.select("div.row-custom");
            Elements docs = content.select("div.col-centrale");
            Elements main = docs.select("div.river");
            for(Element centre : main){
                Elements river = centre.select("article.article-wrapper");
                for(Element wrapper : river){
                    Elements wrap = wrapper.select("section.chapo");
                    Article article = new Article();
                    Source source = new Source();
                    source.setNom("Latribune");
                    source.setPays("Afrique");
                    source.setUrl_source(url);
                    article.setSource(source);
                    Categorie categorie = new Categorie();
                    categorie.setNom("POLITIQUE");
                    article.setCategorie(categorie);
                    for(Element chapo : wrap){
                        Elements titres = chapo.select("h2");
                        for(Element titre : titres){
                            String urlA = titre.select("a").attr("href");
                            //System.out.println(urlA);
                            article.setUrl_article(urlA);
                            String tit = titre.select("a").text();
                            //System.out.println(tit);
                            article.setTitre(tit);
                        }
                        Elements desc = chapo.select("p");
                        for(Element descs : desc){
                            String description = descs.text();
                            //System.out.println(description);
                            article.setDescription(description);
                        }
                    }
                    Elements wraps = wrapper.select("div.image-wrapper").select("a");
                    for(Element img : wraps){
                        String imageUrl = img.select("img").attr("src");
                        //System.out.println(imageUrl);
                        article.setUrl_image(imageUrl);
                        liste.add(article);
                    }
                }
            }
            //System.out.println(liste);
        }catch (Exception e){
            e.printStackTrace();
        }
        return liste;
    }
    public static List<Article> getAfriquelatribuneTech(){
        String url = "https://afrique.latribune.fr/africa-tech";
        List<Article> liste = new ArrayList<>();
        try{
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            //System.out.println(title);
            Elements content = doc.select("div.row-custom");
            Elements docs = content.select("div.col-centrale");
            Elements main = docs.select("div.river");
            for(Element centre : main){
                Elements river = centre.select("article.article-wrapper");
                for(Element wrapper : river){
                    Elements wrap = wrapper.select("section.chapo");
                    Article article = new Article();
                    Source source = new Source();
                    source.setNom("Latribune");
                    source.setPays("Afrique");
                    source.setUrl_source(url);
                    article.setSource(source);
                    Categorie categorie = new Categorie();
                    categorie.setNom("TECHNOLOGIE");
                    article.setCategorie(categorie);
                    for(Element chapo : wrap){
                        Elements titres = chapo.select("h2");
                        for(Element titre : titres){
                            String urlA = titre.select("a").attr("href");
                            //System.out.println(urlA);
                            article.setUrl_article(urlA);
                            String tit = titre.select("a").text();
                            //System.out.println(tit);
                            article.setTitre(tit);
                        }
                        Elements desc = chapo.select("p");
                        for(Element descs : desc){
                            String description = descs.text();
                            //System.out.println(description);
                            article.setDescription(description);
                        }
                    }
                    Elements wraps = wrapper.select("div.image-wrapper").select("a");
                    for(Element img : wraps){
                        String imageUrl = img.select("img").attr("src");
                        //System.out.println(imageUrl);
                        article.setUrl_image(imageUrl);
                        liste.add(article);
                    }
                }
            }
            //System.out.println(liste);
        }catch (Exception e){
            e.printStackTrace();
        }
        return liste;
    }
    public static List<Article> getAfriquelatribuneTechTelecoms(){
        String url2 = "https://afrique.latribune.fr/africa-tech/telecoms";
        List<Article> liste = new ArrayList<>();
        try{
            Document doc = Jsoup.connect(url2).get();
            String title = doc.title();
            //System.out.println(title);
            Elements content = doc.select("div.row-custom");
            Elements docs = content.select("div.col-centrale");
            Elements main = docs.select("div.river");
            for(Element centre : main){
                Elements river = centre.select("article.article-wrapper");
                for(Element wrapper : river){
                    Elements wrap = wrapper.select("section.chapo");
                    Article article = new Article();
                    Source source = new Source();
                    source.setNom("Latribune");
                    source.setPays("Afrique");
                    source.setUrl_source(url2);
                    article.setSource(source);
                    Categorie categorie = new Categorie();
                    categorie.setNom("TECHNOLOGIE");
                    article.setCategorie(categorie);
                    for(Element chapo : wrap){
                        Elements titres = chapo.select("h2");
                        for(Element titre : titres){
                            String urlA = titre.select("a").attr("href");
                            //System.out.println(urlA);
                            article.setUrl_article(urlA);
                            String tit = titre.select("a").text();
                            //System.out.println(tit);
                            article.setTitre(tit);
                        }
                        Elements desc = chapo.select("p");
                        for(Element descs : desc){
                            String description = descs.text();
                            //System.out.println(description);
                            article.setDescription(description);
                        }
                    }
                    Elements wraps = wrapper.select("div.image-wrapper").select("a");
                    for(Element img : wraps){
                        String imageUrl = img.select("img").attr("src");
                        //System.out.println(imageUrl);
                        article.setUrl_image(imageUrl);
                        liste.add(article);
                    }
                }
            }
            //System.out.println(liste);
        }catch (Exception e){
            e.printStackTrace();
        }
        return liste;
    }
    public static List<Article> getAfriqueitnews(){
        String url = "https://afriqueitnews.com/";
        List<Article> liste = new ArrayList<>();
        try{
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            //System.out.println(title);
            Elements docs = doc.select("div.elementor-widget-jnews_block_5_elementor");
            Elements main = docs.select("div.elementor-widget-container");
            Elements jeg = main.select("div.jeg_posts");
            for(Element posts : jeg){
                Elements post = posts.select("article.jeg_post");

                for(Element thumba : post){
                    Article article = new Article();
                    Source source = new Source();
                    source.setNom("AfriqueITNews");
                    source.setPays("Afrique");
                    source.setUrl_source(url);
                    article.setSource(source);
                    Categorie categorie = new Categorie();
                    categorie.setNom("TECHNOLOGIE");
                    article.setCategorie(categorie);
                    Elements thumbs = thumba.select("div.jeg_thumb");
                    for(Element thumb : thumbs){
                        String urlA = thumb.select("a").attr("href");
                        //System.out.println(urlA);
                        article.setUrl_article(urlA);
                        Elements img = thumb.select("a").select("div.thumbnail-container");
                        for(Element imgurl : img){
                            String imageUrl = imgurl.select("img").attr("data-src");
                            //System.out.println(imageUrl);
                            article.setUrl_image(imageUrl);
                        }
                    }
                    Elements content = thumba.select("div.jeg_postblock_content");
                    for(Element contents : content){
                        Elements titres = contents.select("h3.jeg_post_title");
                        for(Element tit : titres){
                            String tits = tit.select("a").text();
                            //System.out.println(tits);
                            article.setTitre(tits);
                        }
                        Elements meta = contents.select("div.jeg_meta_date").select("a");
                        for(Element dtime : meta){
                            String dtimes = dtime.text();
                            //System.out.println(dtimes);
                            article.setDate_publication(dtimes);
                        }
                        Elements desc = contents.select("div.jeg_post_excerpt").select("p");
                        for(Element descs : desc){
                            String description = descs.text();
                            //System.out.println(description);
                            article.setDescription(description);
                            liste.add(article);
                        }
                    }
                }
            }
            //liste.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }
        return liste;
    }
    public static List<Article> getAfrimag(){
        //Afrimag 11/01/2022
        String url = "https://afrimag.net/rubrique/economie-et-entreprise/";
        List<Article> liste = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            ///System.out.println(title);
            Elements docs = doc.select("div.main");
            Elements main = docs.select("div.row");
            Elements centre = main.select("div.main-content");
            for (Element head : centre) {
                Elements post = head.select("div.listing");
                for (Element list : post) {
                    Elements col = list.select("div.column");
                    Elements premier = col.select("article.highlights");
                    for (Element postes : premier) {
                        Article article = new Article();
                        Source source = new Source();
                        source.setNom("Afrimag");
                        source.setPays("Afrique");
                        source.setUrl_source(url);
                        article.setSource(source);
                        Categorie categorie = new Categorie();
                        categorie.setNom("Économie");
                        article.setCategorie(categorie);
                        String urlA = postes.select("a.image-link").attr("href");
                        //System.out.println(urlA);
                        article.setUrl_article(urlA);
                        Elements urlImg = postes.select("a.image-link");
                        for (Element urleImg : urlImg) {
                            String urlImage = urleImg.select("img.image").attr("data-src");
                            //System.out.println(urlImage);
                            article.setUrl_image(urlImage);
                        }
                        Elements dt = postes.select("div.cf");
                        for (Element dtime : dt) {
                            String dtimes = dtime.select("time").text();
                            //System.out.println(dtimes);
                            article.setDate_publication(dtimes);
                        }
                        Elements titre = postes.select("h2.post-title");
                        for (Element tit : titre) {
                            String titr = tit.select("a").text();
                            //System.out.println(titr);
                            article.setTitre(titr);
                        }
                        Elements desc = postes.select("div.excerpt");
                        for (Element descs : desc) {
                            String description = descs.select("p").text();
                            //System.out.println(description);
                            article.setDescription(description);
                            liste.add(article);
                        }
                    }

                }
            }
            //System.out.println(liste);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return liste;
    }
    public static List<Article> getDakarActu(){
        //DakarActu 11/01/2022
        String url = "https://www.dakaractu.com";
        List<Article> liste = new ArrayList<>();
        try{
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            Elements docs = doc.select("tbody");
            Elements main = docs.select("td.celcombo1");
            Elements centre = main.select("div.eau");
            for(Element div : centre){
                Elements cel = div.select("div.cel1");
                for(Element tit : cel){
                    Article article = new Article();
                    Source source = new Source();
                    source.setNom("DakarActu");
                    source.setPays("Sénégal");
                    source.setUrl_source(url);
                    article.setSource(source);
                    Elements titr = tit.select("h3.titre");
                    for(Element titres : titr){
                        String urlA = titres.select("a").attr("href");
                        article.setUrl_article(url+urlA);
                        //System.out.println(url+urlA);
                        String montitre = titres.select("a").text();
                        //System.out.println(montitre);
                        article.setTitre(montitre);
                    }
                    Elements detail = tit.select("div.shadow");
                    for(Element imgU : detail){
                        Elements urlImg = imgU.select("a");
                        for(Element urlImge : urlImg){
                            String urlImage = urlImge.select("img").attr("src");
                            //System.out.println(urlImage);
                            article.setUrl_image(urlImage);
                        }
                    }
                    Elements desc = tit.select("div.texte");
                    for(Element descs : desc){
                        String description = descs.select("a").text();
                        //System.out.println(description);
                        article.setDescription(description);
                        liste.add(article);
                    }
                }
            }
            //System.out.println(liste);
        }catch (Exception e){
            e.printStackTrace();
        }
        return liste;
    }
    public static List<Article> getAps() {
        //APS 11/01/2022
        String url = "http://aps.sn/";
        List<Article> liste = new ArrayList<>();
        try{
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            //System.out.println(title);
            Elements docs = doc.select("div.page-content");
            Elements main = docs.select("div.content-actu");
            Elements centre = main.select("div.grid_8");
            Elements clearfix = centre.select("div.clearfix");
            Elements blog = clearfix.select("ul.from-blog");
            for(Element grid : blog){

                Elements lists = grid.select("li.grid_4");
                for(Element listes : lists){
                    Article article = new Article();
                    Source source = new Source();
                    source.setNom("Aps");
                    source.setPays("Sénégal");
                    source.setUrl_source(url);
                    article.setSource(source);
                    String urlA = listes.select("a").attr("href");
                    //System.out.println(url+urlA);
                    article.setUrl_article(url+urlA);
                    Elements imgUrl = listes.select("a");
                    String imageUrl = imgUrl.select("img").attr("src");
                    //System.out.println(url+imageUrl);
                    article.setUrl_image(url+imageUrl);
                    Elements detail = listes.select("div.detailes");
                    for(Element details :detail){
                        Elements titre = details.select("h5");
                        for(Element tit : titre){
                            String titres = tit.select("a").text();
                            //System.out.println(titres);
                            article.setTitre(titres);
                        }
                        String desc = details.select("p").text();
                        //System.out.println(desc);
                        article.setDescription(desc);
                        liste.add(article);
                    }
                    ///Elements time = listes.select("div.from-meta").not(".icon-eye-open").not(".icon-heart");
                    ///System.out.println(time);
                }
            }
            //System.out.println(liste);
        }catch (Exception e){
            e.printStackTrace();
        }
        return liste;
    }
    public static List<Article> getAdiacCongo(){
        //Adiac-Congo 12/01/2022

        String url = "https://www.adiac-congo.com";
        List<Article> liste = new ArrayList<>();
        try{
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            //System.out.println(title);
            Elements docs = doc.select("div#main-content");
            Elements main = docs.select("div.content-style");
            Elements content = main.select("div#block-system-main");
            Elements view = content.select("div.view-content");

            for(Element bloc : view){
                Elements row = bloc.select("div.views-row");
                for(Element field : row){
                    Article article = new Article();
                    Source source = new Source();
                    source.setNom("Adiac-Congo");
                    source.setPays("Congo");
                    source.setUrl_source(url);
                    article.setSource(source);
                    Elements titres = field.select("div.views-field-title");
                    for(Element titre : titres){
                        String tit = titre.select("span.field-content").text();
                        //System.out.println(tit);
                        article.setTitre(tit);
                        String urlArt = titre.select("span.field-content").select("a").attr("href");
                        //System.out.println(url+urlArt);
                        article.setUrl_article(url+urlArt);
                    }
                    Elements rubriques = field.select("div.views-field-field-rubrique");
                    for(Element rubrique : rubriques)
                    {
                        Categorie categorie = new Categorie();
                        Elements cat = rubrique.select("div.field-content").select("span");
                        String cate = cat.text();
                        categorie.setNom(cate);
                        article.setCategorie(categorie);
                        //System.out.println(cate);
                    }

                    Elements nothings = field.select("div.views-field-nothing-1");
                    for(Element nothing : nothings){
                        String desc = nothing.select("span.field-content").select("p").select("strong").text();
                        //System.out.println(desc);
                        article.setDescription(desc);
                        String imageUrl = nothing.select("span.field-content").select("p").select("img").attr("src");
                        //System.out.println(url+imageUrl);
                        article.setUrl_image(url+imageUrl);
                        liste.add(article);
                    }

                }
            }
            //System.out.println(liste);
        }catch (Exception e){
            e.printStackTrace();
        }
        return liste;
    }
    public static List<Article> getJournalDeBrazza() {
        //JournalDeBrazza 12/01/2022
        String url = "https://www.journaldebrazza.com/";
        List<Article> liste = new ArrayList<>();
        try{
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            //System.out.println(title);
            Elements docs = doc.select("div.main");
            Elements main = docs.select("div.column-left");
            Elements content = main.select("ul.list-post");
            for(Element post: content){
                Elements medium = post.select("li");
                for(Element news : medium)
                {
                    Article article = new Article();
                    Source source = new Source();
                    source.setNom("JournalDeBrazza");
                    source.setPays("Congo");
                    source.setUrl_source(url);
                    article.setSource(source);
                    Elements posts = news.select("article.medium-post");
                    for(Element block :posts){
                        String urlA = block.select("a").attr("href");
                        //System.out.println(urlA);
                        article.setUrl_article(urlA);
                        Elements liens = block.select("a").select("figure.post-img");
                        for(Element lien : liens){
                            Categorie categorie = new Categorie();
                            String cat = lien.select("span.post-category").text();
                            //System.out.println(cat);
                            categorie.setNom(cat);
                            article.setCategorie(categorie);
                            String img = lien.select("img").attr("src");
                            //System.out.println(img);
                            article.setUrl_image(img);
                        }
                        String titre = block.select("a").select("h2.post-title").text();
                        //System.out.println(titre);
                        article.setTitre(titre);
                    }
                    Elements dtime = posts.select("span.post-date");
                    for(Element times : dtime){
                        String datime = times.text();
                        //System.out.println(datime);
                        article.setDate_publication(datime);
                    }
                    Elements desc = posts.select("p");
                    for(Element descs : desc){
                        String description = descs.text();
                        //System.out.println(description);
                        article.setDescription(description);
                        liste.add(article);
                    }
                }


            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return liste;
    }
    public static List<Article> getKoaciExtract() throws RuntimeException{
        //Koaci Afrique
        String url ="https://www.koaci.com/pays/afrique";
        List<Article> allArticle = new ArrayList<Article>();

        try {
            Document dc = Jsoup.connect(url).get();
            //String title = dc.title();
            Elements body = dc.select("div.KoaciPageWhite");
            //Premier bloc
            for(Element step : body){
                String etat = step.select("div.KTagFilterBar div.KTagFilterBarSt2").text();
                //System.out.println(pays);
                Elements bloc = step.select("div.KoaciPageSplitA1");

                //Deuxieme bloc
                for(Element st : bloc){
                    Elements lien = st.select("a[href$=.html]");
                    //System.out.println(lien);
                    //la liste des liens
                    for(Element l : lien){
                        //Recupere la liste des liens
                        String rel = l.attr("href");
                        //System.out.println(rel);
                        Article article = new Article();
                        Source source = new Source();
                        source.setNom("Koaci");
                        source.setPays("Côte d'ivoire");
                        source.setUrl_source(url);
                        article.setSource(source);
                        article.setUrl_article(rel);

                        //Bloc pour recuperer la liste des urls images
                        Elements tb = l.select("div#KoaciBlocNews6_ ");
                        for(Element blc : tb){
                            Elements url_image = blc.select("div.KoaciBlocNews6St1 img");
                            for(Element image : url_image){
                                String url_img = image.attr("src");
                                article.setUrl_image(url_img);
                                String titre = image.attr("alt");
                                article.setTitre(titre);
                                //System.out.println(url_img);
                            }
                            Elements titre = blc.select("div.KoaciBlocNews6St2");
                            for(Element title : titre){
                                Elements descript = titre.select("div.KoaciBlocNews6Text1");
                                for(Element description : descript){
                                    //System.out.println(description.text());
                                    article.setDescription(description.text());
                                    allArticle.add(article);
                                }
                                Elements categ = titre.select("div.KoaciBlocNews2Text2 ");
                                for(Element categorie : categ){
                                    String[] dates = categorie.before("span").text().split("il");
                                    Categorie categorie1 = new Categorie();
                                    categorie1.setNom(dates[0]);
                                    article.setCategorie(categorie1);
                                    //System.out.println(dates[0]);
                                }
                            }
                        }
                    }
                }
            }
            //allArticle.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return allArticle;
    }

    public static List<Article> getLesEchosExtraction() throws RuntimeException{
        //EXtraction du site lesechos-congobrazza
        String url = "https://lesechos-congobrazza.com";
        List<Article> articlesList = new ArrayList<Article>();
        try{
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            Elements main = doc.select("div.blog");
            Elements bloc = main.select("div#item-container");
            for(Element ite : bloc){
                Elements items = ite.select("div.item");
                for(Element item : items){
                    Elements row = item.select("article");
                    Article article = new Article();
                    Source source = new Source();
                    source.setUrl_source(url);
                    source.setNom("LesEchos");
                    source.setPays("Congo");
                    article.setSource(source);
                    for(Element post : row){
                        Elements posts = post.select("div.pull-none");
                        for(Element src : posts){
                            Elements art_url = src.select("a");
                            String a_url = art_url.attr("href");
                            //System.out.println(url+a_url);
                            article.setUrl_article(url+a_url);
                            for(Element srcI : art_url){
                                String article_img = srcI.select("img").attr("src");
                                //System.out.println(url+article_img);
                                article.setUrl_image(url+article_img);
                            }
                        }
                    }
                    for(Element detail: row){
                        Elements details = detail.select("div.item-content");
                        for(Element aside: details){
                            Elements side = aside.select("aside.article-aside");
                            for(Element genre : side){
                                Categorie categorie = new Categorie();
                                String url_categorie = genre.select("a").attr("href");
                                String catName = genre.select("span").text();
                                categorie.setNom(catName);
                                article.setCategorie(categorie);
                                //System.out.println(url+url_categorie);
                                Elements times = side.select("dd");
                                for(Element dtime : times){
                                    String date = dtime.select("time").text();
                                    article.setDate_publication(date);
                                    //System.out.println(date);
                                }
                            }
                            Elements title_article = aside.select("h2.article-title");
                            for(Element art_title : title_article){
                                String tis = art_title.text();
                                article.setTitre(tis);
                                //System.out.println(tis);
                            }
                            Elements desc_article = aside.select("section.article-intro");
                            for(Element desc : desc_article){
                                String descpt = desc.text();
                                article.setDescription(descpt);

                                //System.out.println(descpt);
                            }
                        }

                    }
                    articlesList.add(article);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return articlesList;
    }

    public static List<Article> getJeuneAfrique(){
        String url = "https://www.jeuneafrique.com/";
        List<Article> jList = new ArrayList<Article>();
        try{
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            Elements docs = doc.select("div.page__content");
            Elements main = docs.select("div.panel");
            for(Element bloc : main){
                Elements grid = bloc.select("div.grid__cell");
                for(Element art : grid){
                    Elements artis = art.select("article.thumbnail a");
                    Article article = new Article();
                    Source source = new Source();
                    source.setPays("Afrique");
                    source.setNom("Jeune Afrique");
                    source.setUrl_source(url);
                    article.setSource(source);
                    for(Element articl : artis){
                        String thumb = articl.attr("href");
                        //Url Article
                        //System.out.println(thumb);
                        article.setUrl_article(thumb);
                        Elements img = articl.select("div.thumbnail__header img.thumbnail__img");
                        for(Element imgA : img){
                            String image = imgA.attr("data-src");
                            //UrlImage Article
                            //System.out.println(image);
                            article.setUrl_image(image);
                        }
                        Elements infos = articl.select("div.thumbnail__body");
                        for(Element info : infos){
                            String tag = info.select("span.subtitle").text();
                            //Categorie Name
                            //System.out.println(tag);
                            String titleArt = info.select("h2").text();
                            article.setTitre(titleArt);
                            //Titre Article
                            //System.out.println(titleArt);
                            //Description Article
                            String descArt = info.select("p").text();
                            article.setDescription(descArt);
                            //System.out.println(descArt);
                            jList.add(article);
                        }
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return jList;
    }


    public static List<Article> getSenego(){
        //Extraction senego On a pu l'url_image_article le titre la description l'url_article l'auteur la date_article recuperer
        String url = "https://senego.com/";
        List<Article> list = new ArrayList<Article>();
        try {
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            Elements main = doc.select("div#main-content");
            //System.out.println(main);
            for(Element bod: main){
                Elements body = bod.select("div#column_content article");
                for(Element article : body){
                    Article article1 = new Article();
                    Source source = new Source();
                    source.setPays("Sénégal");
                    source.setNom("Senego");
                    source.setUrl_source(url);
                    article1.setSource(source);
                    Elements articleImg = article.select("div.posts-list-images");
                    for(Element articleImage :articleImg){
                        Elements asrc = articleImage.select("a[href$=.html]");
                        for(Element src : asrc){
                            String sourceUrlArticle = src.attr("href");
                            //Url Article
                            //System.out.println(sourceImage);
                            article1.setUrl_article(sourceUrlArticle);
                        }
                        Elements imgArticle = articleImage.select("a img");
                        for(Element imgart : imgArticle){
                            String sourceImgArticle = imgart.attr("src");
                            //Image Article
                            //System.out.println(sourceArticle);
                            article1.setUrl_image(sourceImgArticle);
                        }

                    }
                    Elements articleDetail = article.select("div.posts-list-detail");
                    for(Element articleDet : articleDetail){
                        Elements articleInfos = articleDet.select("div.posts-list-infos");
                        for(Element author : articleInfos){
                            Elements authors = author.select("div.posts-list-author");
                            //System.out.println(authors.text());
                            article1.setAuteur(authors.text());
                        }
                        for(Element time : articleInfos){
                            Elements times = time.select("div.posts-list-time");
                            //System.out.println(times.text())
                            article1.setDate_publication(times.text());
                        }
                    }
                    Elements articletitle = article.select("h2.entry-title");
                    for(Element titleAr : articletitle){
                        Elements titleSource = titleAr.select("a");
                        //System.out.println(titleSource.text());
                        article1.setTitre(titleSource.text());
                    }
                    //Description List
                    Elements articleDesc = article.select("p.posts-list-excerpt");
                    //System.out.println(articleDesc.textNodes());
                    article1.setDescription(articleDesc.text());
                    list.add(article1);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<Article> getGabonReview(){
        //Gabon Review Extraction categorieName categorieUrl titre url_article url_img description time
        String url = "https://www.gabonreview.com/";
        List<Article> allArticle = new ArrayList<Article>();
        try{
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            Elements body = doc.select("div#main");

            //System.out.println(body);
            for(Element content : body){
                Elements bloc = body.select("div.column-narrow-1");
                //System.out.println(bloc);
                for(Element categorie : bloc){
                    Elements categ= categorie.select("div.column-wrapper");
                    for(Element category : categ){
                        Elements lienCategory = category.select("h2.heading a");
                        Categorie categorie1 = new Categorie();
                        for(Element lienC : lienCategory ){
                            //Categorie name
                            String[] catelien = lienC.text().split("»");
                            //System.err.println(catelien[0]);
                            categorie1.setNom(catelien[0]);
                            //Categorie lien
                            //System.out.println(lienC.attr("href"));
                        }
                        Elements posts = category.select("div.post");
                        for(Element post : posts){
                            Article article = new Article();
                            Source source = new Source();
                            article.setCategorie(categorie1);
                            source.setNom("Gabon Review");
                            source.setPays("Gabon");
                            source.setUrl_source(url);
                            article.setSource(source);
                            Elements titres = post.select("h3 a");
                            for(Element titre: titres){
                                String nameTitre = titre.text();
                                String lienArticle = titre.attr("href");
                                //System.out.println(nameTitre + lienArticle);
                                article.setTitre(nameTitre);
                                article.setUrl_article(lienArticle);
                                allArticle.add(article);
                            }
                            Elements cover = post.select("div.cover a img");
                            for(Element img : cover){
                                String imageUrl = img.attr("src");
                                //System.out.println(imageUrl);
                                article.setUrl_image(imageUrl);

                            }
                            //Recuperation de la description
                            Element description = post.select("p").get(1);
                            //System.out.println(description.text());
                            Element time = post.select("p").get(3);
                            //System.out.println(time.text());
                            String[] dates = time.before("a").text().split("/");
                            article.setDescription(description.text());
                            article.setDate_publication(dates[0]);

                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allArticle;
    }

    public static List<Article> getCamerounInfo(){
        String url ="http://www.cameroon-info.net";
        List<Article> allArticle = new ArrayList<Article>();

        try {
            Document dc = Jsoup.connect(url).get();
            //String title = dc.title();
            Elements bod = dc.select("div.cp-news-grid-style-1");
            Elements body = bod.select("div.row");
            Elements row = body.select("div.col-md-12");
            //Premier bloc
            for(Element news : row){
                Elements last = news.select("div.col-md-6");
                for(Element bloc: last){
                    Elements lien = bloc.select("div.cp-news-post-excerpt");
                    Article article = new Article();
                    Source source = new Source();
                    source.setUrl_source(url);
                    source.setPays("Cameroun");
                    source.setNom("Cameroon-Info");
                    article.setSource(source);
                    for(Element lienA : lien){
                        Elements urlImage = lienA.select("div.cp-thumb");
                        String urlI = urlImage.select("img").attr("src");
                        //System.out.println(url+urlI);
                        article.setUrl_image(url+urlI);
                        for(Element cateNom : urlImage){
                            String cateName = cateNom.select("div.cin_bottomleft_blue").text();
                            //System.out.println(cateName);
                            Categorie categorie = new Categorie();
                            categorie.setNom(cateName);
                            article.setCategorie(categorie);
                        }
                        Elements post = lienA.select("div.cp-post-content");
                        for(Element content : post){
                            String titreA = content.select("div.imgdesc").text();
                            //System.out.println(titreA);
                            article.setTitre(titreA);
                            String urlA = content.select("a").attr("href");
                            //System.out.println(urlA);
                            article.setUrl_article(urlA);
                            Elements dateTime = content.select("ul.cp-post-tools");
                            for(Element date : dateTime){
                                String dates = date.select("li").get(0).text();
                                //System.out.println(dates);
                                article.setDate_publication(dates);
                            }
                            String desc = content.select("a").text();
                            //System.out.println(desc);
                            article.setDescription(desc);
                            allArticle.add(article);
                        }
                    }
                }
            }
            //allArticle.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return allArticle;
    }

    public static List<Article> getLinfodrome(){
        String url ="https://www.linfodrome.com";
        List<Article> allArticle = new ArrayList<Article>();

        try {
            Document dc = Jsoup.connect(url).get();
            Elements bod = dc.select("div.bottom-container");
            Elements body = bod.select("div.uk-grid-small");
            Elements row = body.select("div.content");
            for(Element content: row){
                Article article = new Article();
                Source source = new Source();
                source.setNom("Linfodrome");
                source.setUrl_source(url);
                source.setPays("Côte d'ivoire");
                article.setSource(source);
                String contents = content.select("h4.category").text();
                Categorie categorie = new Categorie();
                categorie.setNom(contents);
                article.setCategorie(categorie);
                Elements corps = content.select("div.uk-clearfix");
                for(Element title : corps){
                    String articleUrl = title.select("a").attr("href");
                    //Url Article
                    article.setUrl_article(url+articleUrl);
                    String imgUrl = title.select("img").attr("data-src");
                    //Url Image
                    article.setUrl_image(imgUrl);
                    //System.out.println(imgUrl);
                    String titre = title.select("h2.title").text();
                    article.setTitre(titre);
                    //Titre
                    //System.out.println(titre);
                }
                Elements meta = content.select("div.meta");
                for(Element auteur : meta){
                    String date = auteur.select("span.date").text();
                    //System.out.println(date);
                    article.setDate_publication(date);
                    String auteurLien = auteur.select("span.author").text();
                    //System.out.println(auteurLien);
                    article.setAuteur(auteurLien);
                    allArticle.add(article);
                }
            }

            //allArticle.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return allArticle;
    }
}
