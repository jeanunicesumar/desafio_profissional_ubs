import { Component } from '@angular/core';

@Component({
  selector: 'app-menu-lateral',
  templateUrl: './menu-lateral.component.html',
  styleUrls: ['./menu-lateral.component.css'],
})
export class MenuLateralComponent {
  constructor() {}

  isAdmin(): boolean {
    return true;
  }
}
