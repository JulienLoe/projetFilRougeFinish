import { Component, Output, EventEmitter } from '@angular/core';
import { ModalService } from 'src/app/services/modal.service';
import { MovieService } from 'src/app/services/movie.service';
import { SerieService } from 'src/app/services/serie.service';

@Component({
  selector: 'app-serie',
  templateUrl: './serie.component.html',
  styleUrls: ['./serie.component.scss']
})
export class SerieComponent {

  series: any[] = [];

  cast$: any[] = [];



  constructor(
    private serieService: SerieService,
    private modalService: ModalService,
    private movieService: MovieService
    ) {
    this.serieService.getSeries().subscribe(series =>{ this.series = series;
    console.log(series)})
    this.serieService.series$.subscribe(movies =>{ this.series = movies;
      console.log(movies)})

  }


  @Output()
  clickModal = new EventEmitter<string>()

  onClickHandler(id: number) {
    this.modalService.modal$.next('form')
    const result = this.series.filter((movie: any) => movie.idDb == id
     );
    this.modalService.idBySerieForModal$.next(result)
    
    console.log(result)

    this.serieService.getCasting(id).subscribe(data =>{ 
      this.cast$= data
      this.movieService.cast$.next(data)
    })
    console.log("result" + this.cast$)
}
}
