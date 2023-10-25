import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class MedicoGuard {
  constructor(private router: Router) {}

  canActivate(isMedico: boolean): boolean {
    if (isMedico) {
      return true;
    }

    return false;
  }
}
