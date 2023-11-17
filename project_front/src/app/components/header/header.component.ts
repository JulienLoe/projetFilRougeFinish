import { MovieService } from 'src/app/services/movie.service';
import { Component, OnInit } from '@angular/core';
import {  ActivatedRoute, Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {

  searchInput: string = ""

  movies: any[] = [];

  clickSearch(){
    console.log(this.searchInput)
  }

  constructor(private router: Router,
    private movieService: MovieService,
    private route: ActivatedRoute,
    private authService: AuthService) {}

  onClickSearch(){
    console.log(this.searchInput)
    
    this.movieService.postSearch(this.searchInput).subscribe(data => {
      this.movies = data; console.log(this.searchInput)
      this.movieService.movies$.next(data)
      console.log(data)
    })
  }

  isLoggedIn = false;

  ngOnInit() {
    this.isLoggedIn = this.authService.logIn();
    console.log('menu ->' + this.isLoggedIn);
  }

  // handleLogout() {
  //   this.authentificationService.logout();
  // }

  signOut() {
    this.authService.logOut()
  }
}
