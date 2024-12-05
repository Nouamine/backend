package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public Article createArticle(Article article) {
        if (article.getDate() == null || article.getDate().equals(LocalDate.of(0, 1, 1))) {
            article.setDate(LocalDate.now());
        }
        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, Article updatedArticle) {
        return articleRepository.findById(id)
                .map(article -> {
                    // Check if the updated date is invalid and set it to the current date if so
                    if (updatedArticle.getDate() == null || updatedArticle.getDate().equals(LocalDate.of(0, 1, 1))) {
                        updatedArticle.setDate(LocalDate.now()); // Set the current date if invalid
                    }
                    article.setTitle(updatedArticle.getTitle());
                    article.setDate(updatedArticle.getDate());
                    article.setBody(updatedArticle.getBody());
                    article.setImageUrl(updatedArticle.getImageUrl());
                    return articleRepository.save(article);
                })
                .orElseThrow(() -> new RuntimeException("Article not found with ID: " + id));
    }

    public void deleteArticle(long id) {
        articleRepository.deleteById(id);
    }
}
