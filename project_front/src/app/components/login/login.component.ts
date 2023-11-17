import { Component, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  showMyContainer: boolean = false;

  constructor(private authService: AuthService,
    private router: Router,
    private userService: UserService){}

  signIn() {
    this.authService.logIn()
    this.router.navigate(['/home'])
  }

  clickView(){
    this.authService.viewShow$.subscribe(data => this.showMyContainer = data)
    this.authService.viewShow$.next(!this.showMyContainer)
    console.log(this.showMyContainer)
  }

  @ViewChild('loginForm') loginForm!: NgForm;

  onSubmit() {
    console.log(this.loginForm.value);
    this.userService.postUserLogin(this.loginForm.value)
  }

  
}
