import { Component, Input } from '@angular/core';
import { Film } from '../film';
import { HomeCategoryListItemComponent } from '../home-category-list-item/home-category-list-item.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home-category-list',
  standalone: true,
  imports: [HomeCategoryListItemComponent, CommonModule],
  templateUrl: './home-category-list.component.html',
  styleUrl: './home-category-list.component.css'
})
export class HomeCategoryListComponent {
  @Input() category: string = '';

  filmsInCategory: Film[] = [
    {
      id: 1,
      name: 'Film1',
      image:
        'https://placehold.co/235x336/grey/white/?text=Placeholder\\nCopertina\\nFilm+1',
      url: 'https://placehold.co/235x336/grey/white/?text=Placeholder\\nCopertina\\nFilm+1',
      category: 'Cat1',
    },
    {
      id: 2,
      name: 'Film2',
      image:
        'https://placehold.co/235x336/grey/white/?text=Placeholder\\nCopertina\\nFilm+2',
      url: 'https://placehold.co/235x336/grey/white/?text=Placeholder\\nCopertina\\nFilm+2',
      category: 'Cat1',
    },
    {
      id: 3,
      name: 'Film3',
      image:
        'https://placehold.co/335x336/grey/white/?text=Placeholder\\nCopertina\\nFilm+3',
      url: 'https://placehold.co/235x336/grey/white/?text=Placeholder\\nCopertina\\nFilm+3',
      category: 'Cat1',
    },
  ];
}
