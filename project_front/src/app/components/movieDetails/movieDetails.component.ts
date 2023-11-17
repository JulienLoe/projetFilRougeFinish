import { DetailService } from '../../services/detailsService/detail.service';
import { Component , OnInit} from '@angular/core';

@Component({
  selector: 'app-movieDetails',
  templateUrl: './movieDetails.html',
  styleUrls: ['./movieDetails.component.scss']
})
export class MovieDetailsComponent implements OnInit{
  movies: any[] = [];

  constructor(private detailsService: DetailService) {
    
  }

  ngOnInit(): void {
    // console.log("on init")
    // this.detailsService.getMovies().subscribe((data: any) =>{
    //   this.movies = data;}
    //   )
  }
}
