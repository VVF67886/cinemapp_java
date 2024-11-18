import { Component } from '@angular/core';
import { NavComponent } from '../../components/nav/nav.component';
import { FiltriComponent } from "../filtri/filtri.component";
import { UsciteListComponent } from "../uscite-list/uscite-list.component";

@Component({
  selector: 'app-calendario',
  standalone: true,
  imports: [NavComponent, FiltriComponent, UsciteListComponent],
  templateUrl: './calendario.component.html',
  styleUrl: './calendario.component.css'
})
export class CalendarioComponent {

}
