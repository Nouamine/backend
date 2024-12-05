
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { Article } from './article';
import {catchError, map} from 'rxjs/operators';
import { tap } from 'rxjs/operators'; 


@Injectable({ providedIn: 'root' })
export class ArticleService {
  private apiUrl = 'http://localhost:8085/articles';
  private articles: Article[] = []; 

  constructor(private http: HttpClient) { }

 
    getArticles(): Observable<Article[]> {
      return this.http.get<Article[]>(this.apiUrl).pipe(
        tap((articles) => console.log('Articles fetched:', articles)), 
        catchError((error) => {
          console.error('Error fetching articles:', error);
          throw error; 
        })
      );
    }


      deleteArticle(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`).pipe(
          tap(article => {
            console.log('Deleted article:', article);  
          }),
          catchError(error => {
            
            console.error('Error deleting article:', error);
            
            return throwError(() => new Error('Failed to delete article'));
          })
        );
      }
      addArticle(article :Article): Observable<Article> {
        return this.http.post<Article>(this.apiUrl ,article).pipe(
          tap(article => {
            console.log('Adding article:', article);  
          }),
          catchError(error => {
            console.error('Error adding  article:', error);
            return throwError(() => new Error('Failed to add article'));
          })
        );
      }
      updateArticle(article: Article): Observable<Article> {
        return this.http.put<Article>(`${this.apiUrl}/${article.id}`, article).pipe(
          catchError(error => {
            console.error('Error updating article:', error);
            return throwError(() => new Error('Failed to update article'));
          })
        );
      }
      
}
