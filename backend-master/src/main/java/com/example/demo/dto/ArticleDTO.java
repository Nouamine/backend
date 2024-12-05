package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ArticleDTO {
    private String title;
    private LocalDate date;
    private String body;
    private String imageUrl;
    private Long id;

}
