import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeCategoryListComponent } from '../category-list/home-category-list.component';
import { NavComponent } from '../../components/nav/nav.component';

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
