import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ModalService {

  public modal$ = new BehaviorSubject<any>("");

  public idByMovieForModal$ = new BehaviorSubject<any |null>(null);

  public idBySerieForModal$ = new BehaviorSubject<any |null>(null);

  constructor() { }

 

}
