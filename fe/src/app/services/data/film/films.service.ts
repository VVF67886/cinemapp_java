import { Injectable } from '@angular/core';
import { Film } from '../../interfaces/film';

@Injectable({
  providedIn: 'root'
})

export class FilmsService {
  readonly baseUrl = 'http://localhost:3000';

  constructor() { }

  async getAllFilms() : Promise<Film[]> {
    const data = await fetch(`${this.baseUrl}/films`);
    return await data.json() ?? [];
  }

  async getFilmById(id: Number): Promise<Film|undefined> {
    const data = await fetch(`${this.baseUrl}/films/${id}`);
    return await data.json() ?? {};
  }

  async get3FilmsFromCategory(category: String) : Promise<Film[]> {
    const data = await fetch(`${this.baseUrl}/films/?_limit=3&category=${category}`);
    return await data.json() ?? [];
  }

  async get2FilmsUscita(from: Date, to: Date) : Promise<Film[]> {
    const data = await fetch(`${this.baseUrl}/films/?releaseDate_gte=2023-01-01&releaseDate_lte=2023-01-31`);
    return await data.json() ?? [];
  }
}
