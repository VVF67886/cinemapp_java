import { Component } from '@angular/core';
import { NavComponent } from '../../components/nav/nav.component';
import { News } from '../../services/interfaces/news';
import { NewsService } from '../../services/data/news/news.service';
import { CommonModule } from '@angular/common';
import { NewsListItemComponent } from "../news-list-item/news-list-item.component";

@Component({
  selector: 'app-news',
  standalone: true,
  imports: [NavComponent, CommonModule, NewsListItemComponent],
  templateUrl: './news.component.html',
  styleUrl: './news.component.css'
})
export class NewsComponent {
  
  newsList: News[] = [];
  
  constructor(private newsService: NewsService) {}

  ngOnInit() {
    this.newsService.getAllNews().then((newsList: News[]) => {
      this.newsList = newsList;
    });
  }
}
