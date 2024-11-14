import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-film-detail',
  standalone: true,
  imports: [],
  templateUrl: './film-detail.component.html',
  styleUrl: './film-detail.component.css'
})
export class FilmDetailComponent {

  route: ActivatedRoute = inject(ActivatedRoute);
  filmId = -1;

  constructor(){
    this.filmId = Number(this.route.snapshot.params['id']);
  }
}
