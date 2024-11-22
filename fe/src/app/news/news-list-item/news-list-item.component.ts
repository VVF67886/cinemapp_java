import { Component, Input } from '@angular/core';
import { News } from '../../services/interfaces/news';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-news-list-item',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './news-list-item.component.html',
  styles: ``
})
export class NewsListItemComponent {
  @Input() news!: News;

}
