package com.rxlm.practice.java8.bean;

import java.util.List;

/**
 * @ClassName: Article
 * @Author: xz
 * @CreateDate: 2019/5/22 18:18
 * @Version: 1.0
 */
public class Article {
    private final String title;
    private final String author;
    private final List<String> tags;

    public Article(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getTags() {
        return tags;
    }
}
