import { Routes } from '@angular/router';
import { AuthGuard } from './services/security/auth.guard';
import { CalendarioComponent } from './uscite/calendario/calendario.component';
import { HomeComponent } from './home/main/home.component';
import { FilmDetailComponent } from './components/film-detail/film-detail.component';
import { RegisterComponent } from './login/register/register.component';
import { LoginComponent } from './login/login/login.component';
import { NewsComponent } from './news/news/news.component';

export const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'calendario', component: CalendarioComponent, canActivate: [AuthGuard] },
    { path: 'news', component: NewsComponent, canActivate: [AuthGuard] },
    { path: 'film/:id', component: FilmDetailComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent }
];
