import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgbAlert } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, CommonModule, NgbAlert],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  nome: string = '';
  cognome: string = '';
  email: string = '';
  password: string = '';
  errorMessage: string = '';
  
  constructor(private router: Router) {}

  onSubmit(): void {
    this.router.navigate(['/login']);
    // TODO: logica di registrazione
  }

}
