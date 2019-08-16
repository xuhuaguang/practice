package com.rxlm.practice.java8.Stream;

import com.rxlm.practice.java8.bean.Article;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: TestStream
 * @Description:
 * @Author: xz
 * @CreateDate: 2019/5/22 18:26
 * @Version: 1.0
 */
public class TestStream {

    //https://blog.csdn.net/qq_35393472/article/details/79698544
    public static void main(String[] args) {
        List<String> tags = new ArrayList<>();
        tags.add("Java");
        tags.add("js");
        Article art = new Article("怎么学习Java","zs",tags);
        List<Article> articles = new ArrayList<>();
        articles.add(art);

        List<String> t = new ArrayList<>();
        t.add("python");
        t.add("js");
        articles.add(new Article("python","ls",t));

        Optional<Article> article = getStreamFirstJavaArticle(articles);
        if (null != article)
        System.out.println(article.get().getAuthor());

        System.out.println("---------------------------------");
        List<Article> list = getAllJavaArticles(articles);
        list.stream().forEach(a-> System.out.println(a.getAuthor()));

        System.out.println("---------------------------------");
        Map<String, List<Article>> listMap = groupByAuthor(articles);
        for (Map.Entry<String, List<Article>> entry : listMap.entrySet()) {
            System.out.println("map key==>"+ entry.getKey());
            entry.getValue().stream().forEach(article1 -> System.out.println("map value ==>"+article1.getTitle()));
        }
        System.out.println("-----------------------------------");
        Map<String, List<Article>> stringListMap = groupByAuthorStream(articles);
        for (Map.Entry<String, List<Article>> entry : stringListMap.entrySet()) {
            System.out.println("map key==>"+ entry.getKey());
            entry.getValue().stream().forEach(article1 -> System.out.println("map value ==>"+article1.getTitle()));
        }
    }

    /*平常*/
    public static Article getFirstJavaArticle(List<Article> articles) {
        for (Article article : articles) {
            if (article.getTags().contains("js")) {
                return article;
            }
        }
        return null;
    }

    /*stream形式  仅获取第一个*/
    public static Optional<Article> getStreamFirstJavaArticle(List<Article> articles) {
        Optional<Article> java = articles.stream()
                .filter(article -> article.getTags().contains("js"))
                .findFirst();
        return java;
    }

    /*stream形式  获取全部*/
    public static List<Article> getAllJavaArticles(List<Article> articles) {
        List<Article> js = articles.stream().filter(article -> article.getTags().contains("js")).collect(Collectors.toList());
        return js;
    }

    /*平常*/
    public static Map<String, List<Article>> groupByAuthor(List<Article> articles) {

        Map<String, List<Article>> result = new HashMap<>();

        for (Article article : articles) {
            if (result.containsKey(article.getAuthor())) {
                result.get(article.getAuthor()).add(article);
            } else {
                ArrayList<Article> arts = new ArrayList<>();
                arts.add(article);
                result.put(article.getAuthor(), arts);
            }
        }
        return result;
    }

    /*stream*/
    public static Map<String, List<Article>> groupByAuthorStream(List<Article> articles) {
        Map<String, List<Article>> collect = articles.stream().collect(Collectors.groupingBy(Article::getAuthor));
        return collect;
    }
}
