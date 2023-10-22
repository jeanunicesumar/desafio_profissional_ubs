import { Router } from '@angular/router';
import { MedicoGuard } from './../../guards/medico.guard';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { AdministradorGuard } from 'src/app/guards/administrador.guard';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private readonly API = 'http://localhost:8080';

  constructor(
    private http: HttpClient,
    private medico: MedicoGuard,
    private admin: AdministradorGuard,
    private router: Router
  ) {}

  auth(form: FormGroup): void {
    this.http.post(`${this.API}/person/auth`, form).subscribe((result: any) => {
      this.redirect(result.isDoctor, result.isAdmin);
    });
  }

  private redirect(isDoctor: boolean, isAdmin: boolean): void {
    this.medico.canActivate(isDoctor);
    this.admin.canActivate(isAdmin);

    if (isDoctor) {
      this.router.navigate(['/medico']);
    }

    if (isAdmin) {
      this.router.navigate(['/administrador']);
    }
  }
}
