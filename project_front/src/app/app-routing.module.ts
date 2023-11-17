import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { MovieDetailsComponent } from './components/movieDetails/movieDetails.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { LayoutComponent } from './components/layout/layout.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { SerieService } from './services/serie.service';
import { SerieComponent } from './components/serie/serie.component';
import { ProfilComponent } from './components/profil/profil.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'register', component: RegisterComponent},
  { path: '', component: LayoutComponent, children:[
    { path: '', redirectTo: '/home', pathMatch: 'full'},
    { path: 'landing', component: LandingPageComponent },
    { path: 'register', component: RegisterComponent},
    { path: 'home', component: HomePageComponent},
    { path: 'serie', component: SerieComponent},
    { path: 'mylist', component: ProfilComponent}
  ] }, 
  { path: '**', component: PageNotFoundComponent } // Gestion des routes non trouvées
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
 
  
 }
