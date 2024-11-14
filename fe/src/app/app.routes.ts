import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './auth.guard';
import { CalendarioComponent } from './calendario/calendario.component';
import { NewsComponent } from './news/news.component';
import { HomeComponent } from './home/home.component';
import { FilmDetailComponent } from './film-detail/film-detail.component';
import { RegisterComponent } from './register/register.component';

export const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'calendario', component: CalendarioComponent, canActivate: [AuthGuard] },
    { path: 'news', component: NewsComponent, canActivate: [AuthGuard] },
    { path: 'film/:id', component: FilmDetailComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent }
];
