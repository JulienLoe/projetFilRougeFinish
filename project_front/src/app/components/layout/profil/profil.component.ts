import { Component,Output,EventEmitter } from '@angular/core';
import { MovieService } from 'src/app/services/movie.service';
import { CommonModule } from '@angular/common'
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { ModalComponent } from '../modal/modal.component';
import { ModalService } from 'src/app/services/modal.service';
import { ViewChild } from '@angular/core';
import { ElementRef } from '@angular/core';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss']
})
export class ProfilComponent {

  movies$: any[] = [];
////
  moviesPop$: any[] = [];
  seriesPop$: any[] = [];
  moviesFav$: any[] = [];
////


  constructor(
    private movieService: MovieService,
    private modalService: ModalService,
    ) {
    this.movieService.getMovies().subscribe(movies =>{ this.movies$ = movies;
    console.log(movies)})
    this.movieService.movies$.subscribe(movies =>{ this.movies$ = movies;
      console.log(movies)})
//////
    this.movieService.getMoviesPop().subscribe(moviesPop =>{ this.moviesPop$ = moviesPop;
      console.log(moviesPop)})
      this.movieService.moviesPop$.subscribe(moviesPop =>{ this.moviesPop$ = moviesPop;
      console.log(moviesPop)})

      this.movieService.getSeriesPop().subscribe(seriesPop =>{ this.seriesPop$ = seriesPop;
        console.log(seriesPop)})
        this.movieService.seriesPop$.subscribe(seriesPop =>{ this.seriesPop$ = seriesPop;
        console.log(seriesPop)})

    // this.movieService.getMoviesFav().subscribe(moviesFav =>{ this.moviesFav$ = moviesFav;
    //   console.log(moviesFav)})
    //   this.movieService.moviesFav$.subscribe(moviesFav =>{ this.moviesFav$ = moviesFav;
    //   console.log(moviesFav)})
///////
  }



  modalRef: MdbModalRef<ModalComponent> | null = null;

  @Output()
  clickModal = new EventEmitter<string>()

  onClickHandler(id: number) {
    this.modalService.modal$.next('form')
    const result = this.movies$.filter((movie: any) => movie.idDb == id
    );
    this.modalService.idByMovieForModal$.next(result)

    console.log(result)
}


// New code

@ViewChild('widgetsContent') widgetsContent!: ElementRef;

scrollLeft(){
  this.widgetsContent.nativeElement.scrollLeft -= 250;
}

scrollRight(){
  this.widgetsContent.nativeElement.scrollLeft += 250;
}

@ViewChild('widgetsContent2') widgetsContent2!: ElementRef;

scrollLeft2(){
  this.widgetsContent2.nativeElement.scrollLeft -= 250;
}

scrollRight2(){
  this.widgetsContent2.nativeElement.scrollLeft += 250;
}


@ViewChild('widgetsContent3') widgetsContent3!: ElementRef;

scrollLeft3(){
  this.widgetsContent3.nativeElement.scrollLeft -= 250;
}

scrollRight3(){
  this.widgetsContent3.nativeElement.scrollLeft += 250;
}
}
