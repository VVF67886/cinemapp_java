import { Injectable } from '@angular/core';
import { News } from '../../interfaces/news';

@Injectable({
  providedIn: 'root'
})

export class NewsService {
  readonly baseUrl = 'http://localhost:3000';

  constructor() { }

  async getAllNews() : Promise<News[]> {
    const data = await fetch(`${this.baseUrl}/news`);
    return await data.json() ?? [];
  }

  async getNewsById(id: Number): Promise<News|undefined> {
    const data = await fetch(`${this.baseUrl}/news/${id}`);
    return await data.json() ?? {};
  }
}
