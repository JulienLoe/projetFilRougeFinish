import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartMovieService {

  public cardList: any =[];
  public movieList = new BehaviorSubject<any>([]);

  constructor() { }

  getMovie(){
    return this.movieList.asObservable();
  }

  addCart(shoes : any){
    this.cardList.push(shoes);
    this.movieList.next(this.cardList);
    this.getTotal();
  }

  getTotal(){
    let sumTotal = 0;
    this.cardList.map((el: any) =>{
      sumTotal += el.total
    } )
  }

  removeCart(product: any){
    this.cardList.map((el: any, index: any) =>{
      if(el.id == product.id){
        this.cardList.splice(index,1)
      }
    })
  }
}
