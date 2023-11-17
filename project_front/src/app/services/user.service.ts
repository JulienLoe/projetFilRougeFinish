import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import User from '../components/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  readonly API_URL = "http://localhost:8080"

  readonly ENDPOINT_MOVIE = "/api/user"

  constructor(private httpClient : HttpClient) {}

  public movies$ = new BehaviorSubject<any>([]);

  config = {
    headers: {
      "Content-Type": "application/json",
      'Access-Control-Allow-Origin': 'http://localhost:8080',
      'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT',
      'title' : 'mi'
      }
    }

  postUser(user: User){
    return this.httpClient.post<any>(this.API_URL+ "/api/user", user)
  }

  postUserLogin(user: User){
    return this.httpClient.post<any>(this.API_URL+ "/api/user/login", user)
  }
}
