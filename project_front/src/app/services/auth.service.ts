import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Router } from '@angular/router';
import User from '../components/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user$ = new BehaviorSubject<User | null>(null)

  public viewShow$ = new BehaviorSubject<any |null>(null);

  constructor(
    private router: Router
  ) {
    const token = localStorage.getItem('jwt')
    if (token) {
      console.log('Auto Login...');
  
      // Requête 
      const requestWorks = true
  
      if (requestWorks) {
        this.user$.next({
          id: 1,
          lastname: 'Julien',
          firstname: 'Loeuilleux',
          email: 'juju@juju',
          password: '1111',
          image: '/mlmlml',
          preference1: 28
        })
      }
    }
    
  }

  logIn() {
    // Requête 
    const requestWorks = true
  
    if (requestWorks) {
      this.user$.next({
          id: 1,
          lastname: 'Julien',
          firstname: 'Loeuilleux',
          email: 'juju@juju',
          password: '1111',
          image: '/mlmlml',
          preference1: 28
      })
      localStorage.setItem('jwt', 'return true !(Sécurité internet; ISO/IEC27035)')
    }
    return true
  }

  getToken() {
    return localStorage.getItem('jwt')
  }

  logOut() {
    this.user$.next(null)
    localStorage.removeItem('jwt')
    this.router.navigate(['/'])
  }
}
