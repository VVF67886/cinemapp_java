import { Component, Input } from '@angular/core';
import { Film } from '../../services/interfaces/film';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-home-category-list-item',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './home-category-list-item.component.html',
  styleUrl: './home-category-list-item.component.css'
})
export class HomeCategoryListItemComponent {
  @Input() film!:Film;
}
