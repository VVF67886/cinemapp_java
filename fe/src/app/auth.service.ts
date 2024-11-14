import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private router: Router) {}

  // TODO: gestione temporanea autenticazione
  private readonly TOKEN_KEY = 'auth_token';
  private validUsername = 'user'; // Hardcoded username
  private validPassword = 'password'; // Hardcoded password

  login(username: string, password: string): boolean {    
    if (username === this.validUsername && password === this.validPassword) {
      localStorage.setItem(this.TOKEN_KEY, 'valid');
      this.router.navigate(['']);
      return true;
    }
    return false;
  }

  logout(): void {
    localStorage.removeItem(this.TOKEN_KEY);
    this.router.navigate(['/login']);
  }

  isLoggedIn(): boolean {
    return localStorage.getItem(this.TOKEN_KEY) !== null;
  }
}