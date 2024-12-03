import { Component, OnInit } from '@angular/core';
import { ArticleService } from './article.service';
import { Article } from './article';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  articles: Article[] = [];
  articlesPerPage = 9;
  currentPage = 1;
  totalPages = 0;
  subscription: Subscription = new Subscription();

  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
    this.subscription = this.articleService.getArticles().subscribe({
      next: articles => {
        this.articles = articles.map(article => ({
          title: article.title,
          date: new Date().toISOString(),
          body: article.body,
          imageUrl:article.imageUrl
        }));
        this.totalPages = Math.ceil(this.articles.length / this.articlesPerPage);
      },
      error: error => console.error('Erreur :', error)
    });
  }

  onPageChange(pageNumber: number): void {
    this.currentPage = pageNumber;
  }

  get paginatedArticles(): Article[] {
    const startIndex = (this.currentPage - 1) * this.articlesPerPage;
    const endIndex = startIndex + this.articlesPerPage;
    return this.articles.slice(startIndex, endIndex);
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  getRange(count: number): number[] {
    return Array.from({ length: count }, (_, i) => i);
  }
}