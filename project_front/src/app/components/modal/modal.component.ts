import { Component, Output, EventEmitter, ViewChild, ElementRef } from '@angular/core';
import { ModalService } from 'src/app/services/modal.service';
import { MovieService } from 'src/app/services/movie.service';

type Album =  {
  id: number;
  title: string ;
  duration: number;
  years: number
}

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent  {

  movies: any[] = [];

  cast: any | null = null

  idMovie: any | null = null

  idCast: any | null = null

  toto: any = 0
  
  title = 'exoKAngular';

  @Output() close = new EventEmitter()

  onClose(event: Event | undefined = undefined) {
    if (event) {
      if (event.currentTarget === event.target) {
        this.close.emit()
      }
    } else this.close.emit()
  }

  constructor(
    private movieService : MovieService,
    private modalService: ModalService
  ){
    this.movieService.movies$.subscribe(data => this.movies = data)
    this.modalService.idByMovieForModal$.subscribe(data => this.idMovie = data)
    this.movieService.cast$.subscribe(data => this.cast = data)
    this.modalService.idBySerieForModal$.subscribe(data => this.idCast = data)
   
}


}