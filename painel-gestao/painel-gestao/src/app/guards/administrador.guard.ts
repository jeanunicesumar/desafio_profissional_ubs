import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AdministradorGuard {
  constructor(private router: Router) {}

  canActivate(isAdmin: boolean): boolean {
    if (isAdmin) {
      return true;
    }

    return false;
  }
}
