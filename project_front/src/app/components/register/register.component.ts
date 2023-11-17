import { Component, ViewChild } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  showMyContainer: boolean = false;

  constructor(private authService: AuthService,
    private userService: UserService){}

  clickView(){
    this.authService.viewShow$.subscribe(data => this.showMyContainer = data)
    this.authService.viewShow$.next(!this.showMyContainer)
    console.log(this.showMyContainer)
  }

  @ViewChild('loginForm') loginForm!: NgForm;

  onSubmit() {
    console.log(this.loginForm.value);
    this.userService.postUser(this.loginForm.value)
  }
}
