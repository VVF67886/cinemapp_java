import { Component, Input } from '@angular/core';
import { Film } from '../../services/interfaces/film';
import { HomeCategoryListItemComponent } from '../category-list-item/home-category-list-item.component';
import { CommonModule } from '@angular/common';
import { FilmsService } from '../../services/data/film/films.service';

@Component({
  selector: 'app-home-category-list',
  standalone: true,
  imports: [HomeCategoryListItemComponent, CommonModule],
  templateUrl: './home-category-list.component.html'
})
export class HomeCategoryListComponent {
  @Input() category: string = '';
  
  filmsInCategory: Film[] = [];
  
  constructor(private filmService: FilmsService) {}

  ngOnInit() {
    this.filmService.get3FilmsFromCategory(this.category).then((filmsInCategory: Film[]) => {
      this.filmsInCategory = filmsInCategory;
    });
  }
}
