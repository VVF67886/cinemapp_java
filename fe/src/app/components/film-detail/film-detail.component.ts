import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NavComponent } from '../nav/nav.component';
import { FilmsService } from '../../services/data/film/films.service';
import { Film } from '../../services/interfaces/film';

@Component({
  selector: 'app-film-detail',
  standalone: true,
  imports: [NavComponent],
  templateUrl: './film-detail.component.html',
})
export class FilmDetailComponent implements OnInit {
  route: ActivatedRoute = inject(ActivatedRoute);
  filmId = -1;
  filmById: Film | undefined;

  constructor(private filmService: FilmsService) {
    this.filmId = Number(this.route.snapshot.params['id']);
  }

  ngOnInit() {
    this.filmService.getFilmById(this.filmId).then((filmById) => {
      this.filmById = filmById;
    });
  }
}
