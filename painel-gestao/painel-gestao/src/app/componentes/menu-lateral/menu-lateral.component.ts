import { Component } from '@angular/core';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-menu-lateral',
  templateUrl: './menu-lateral.component.html',
  styleUrls: ['./menu-lateral.component.css']
})
export class MenuLateralComponent {
 constructor(
  private authService: AuthService
 ){}

 isAdmin(): boolean {
  return this.authService.autenticacaoAdmnistrador();
 }
}
