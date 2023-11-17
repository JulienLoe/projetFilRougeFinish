import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { tap, BehaviorSubject } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  readonly API_URL = "http://localhost:8080"

  readonly ENDPOINT_MOVIE = "/api/movie"

  readonly ENDPOINT_SEARCH = "/api/movies"

  readonly ENDPOINT_MOVIE_POPULAR = "/api/moviesFirst10ByScore"
  readonly ENDPOINT_SERIE_POPULAR = "/api/series/First10ByScore"
  readonly ENDPOINT_MOVIE_FAVORITE = "/api//moviesFirst10ByCategory/{categoryId}"

  constructor(private httpClient : HttpClient) {}

  public movies$ = new BehaviorSubject<any[]>([]);

  public cast$ = new BehaviorSubject<any[]>([]);

  public moviesPop$ = new BehaviorSubject<any>([]);
  public seriesPop$ = new BehaviorSubject<any>([]);
  public moviesFav$ = new BehaviorSubject<any>([]);


  config = {
    headers: {
      "Content-Type": "application/json",
      'Access-Control-Allow-Origin': 'http://localhost:8080',
      'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT',
      'title' : 'mi'
      }
    }
  
  getMovies(){
    return this.httpClient.get<any>(this.API_URL+this.ENDPOINT_MOVIE)
    .pipe(
      tap(data => console.log(data))
    );
  }

  getMoviesPop(){
    return this.httpClient.get<any>(this.API_URL+this.ENDPOINT_MOVIE_POPULAR)
    .pipe(
      tap(data => console.log(data))
    );
  }

  getSeriesPop(){
    return this.httpClient.get<any>(this.API_URL+this.ENDPOINT_SERIE_POPULAR)
    .pipe(
      tap(data => console.log(data))
    );
  }

  getMoviesFav(){
    return this.httpClient.get<any>(this.API_URL+this.ENDPOINT_MOVIE_FAVORITE)
    .pipe(
      tap(data => console.log(data))
    );
  }

  getCasting(filmId: number){
    return this.httpClient.get<any>(this.API_URL+`/api/castingById/${filmId}`)
    .pipe(
      tap(data => console.log(data) )
    );
  }

  postSearch(search: string){
    return this.httpClient.get<any>(this.API_URL+this.ENDPOINT_SEARCH, {headers: { 'title' : `${search}`}})
  }
}
