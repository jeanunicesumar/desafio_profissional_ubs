import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Injectable({
  providedIn: 'root',
})
export class MedicoGuard {
  constructor(private authService: AuthService, private router: Router) {}

  // canActivate(): boolean {
  //   if (this.authService.autenticacaoMedico("46666723031", "81dc9bdb52d04dc20036dbd8313ed055")) {
  //     return true;
  //   } else {
  //     this.router.navigate(['/login']);
  //     return false;
  //   }
  // }
}
