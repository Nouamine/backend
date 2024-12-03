package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ArticleDTO;
import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/articles")
@CrossOrigin(origins = "http://localhost:4200") // Allow only the frontend's origin
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<ArticleDTO> getAllArticles() {
        return articleService.getAllArticles().stream()
                .map(article -> {
                    ArticleDTO dto = new ArticleDTO();
                    dto.setTitle(article.getTitle());
                    dto.setDate(article.getDate());
                    dto.setBody(article.getBody());
                    dto.setImageUrl(article.getImageUrl());
                    return dto;
                }).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id)
                .map(article -> {
                    ArticleDTO dto = new ArticleDTO();
                    dto.setTitle(article.getTitle());
                    dto.setDate(article.getDate());
                    dto.setBody(article.getBody());
                    dto.setImageUrl(article.getImageUrl());
                    return ResponseEntity.ok(dto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody ArticleDTO articleDTO) {
        Article article = new Article();
        article.setTitle(articleDTO.getTitle());
        article.setDate(articleDTO.getDate());
        article.setBody(articleDTO.getBody());
        article.setImageUrl(articleDTO.getImageUrl());
        return new ResponseEntity<>(articleService.createArticle(article), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
        Article updatedArticle = new Article();
        updatedArticle.setTitle(articleDTO.getTitle());
        updatedArticle.setDate(articleDTO.getDate());
        updatedArticle.setBody(articleDTO.getBody());
        updatedArticle.setImageUrl(articleDTO.getImageUrl());
        return ResponseEntity.ok(articleService.updateArticle(id, updatedArticle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
