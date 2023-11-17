import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { tap, BehaviorSubject } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class SerieService {

  readonly API_URL = "http://localhost:8080"

  readonly ENDPOINT_MOVIE = "/api/series"

  readonly ENDPOINT_SEARCH = "/api/movies"

  constructor(private httpClient : HttpClient) {}

  public series$ = new BehaviorSubject<any>([]);

  public cast$ = new BehaviorSubject<any[]>([]);
  
  getSeries(){
    return this.httpClient.get<any>(this.API_URL+this.ENDPOINT_MOVIE)
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

  getSaison(serieId: number){
    return this.httpClient.get<any>(this.API_URL+`/api/season/${serieId}`)
    .pipe(
      tap(data => console.log(data) )
    );
  }

  getEpisode(serieId: number, nbsaison: number){
    return this.httpClient.get<any>(this.API_URL+`/api/episodesSerieById/${serieId}/saison${nbsaison}`)
    .pipe(
      tap(data => console.log(data) )
    );
  }
}
