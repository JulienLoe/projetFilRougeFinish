import { Component } from '@angular/core';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { ModalComponent } from './components/login/modal/modal.component';
import { ModalService } from './services/modal.service';
import { MovieService } from './services/movie.service';
import User from './components/user.model';
import { Subscription } from 'rxjs';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'NETFLUX';

  modalVisibility = ""

  idMovie: any | null = null

  idSerie: any | null = null

  cast: any | null = null

  castSerie: any | null = null

  user: User | null = null
  userSub: Subscription | undefined

  showMyContainer: boolean = false;
  

  changeModalVisilibty(value: string) {
    this.modalVisibility = value
    console.log(this.idMovie)
    console.log(this.cast)
  }

  

  clickModal(){
    console.log('ok')
    
  }

  modalRef: MdbModalRef<ModalComponent> | null = null;

  constructor(private modalService: ModalService,
    private authService: AuthService,
    private movieService: MovieService
    ) {
      this.modalService.modal$.subscribe(data => this.modalVisibility = data)
      this.modalService.idByMovieForModal$.subscribe(data => this.idMovie = data)
      console.log(this.idMovie)
      this.userSub = this.authService.user$.subscribe(user => this.user = user)
      this.authService.viewShow$.subscribe(movies =>{ this.showMyContainer = movies;
        console.log(movies)})
        this.modalService.idBySerieForModal$.subscribe(data => this.idMovie = data)
      this.movieService.cast$.subscribe(data => this.cast = data)
      console.log(this.user)

    }

}
