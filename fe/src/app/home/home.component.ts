import { Component } from '@angular/core';
import { NavComponent } from '../nav/nav.component';
import { HomeCategoryListComponent } from '../home-category-list/home-category-list.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, NavComponent, HomeCategoryListComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})

export class HomeComponent {
  categories = ['Drammatico', 'Sentimentale'];
}
