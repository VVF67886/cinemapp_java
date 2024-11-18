import { Component } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';
import { AuthService } from '../../auth.service';

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [NgbModule, RouterModule],
  templateUrl: './nav.component.html'
})
export class NavComponent {
 
  constructor(private authService: AuthService) {}

  logout() {
    this.authService.logout();
    console.log('logout');
  }
}
