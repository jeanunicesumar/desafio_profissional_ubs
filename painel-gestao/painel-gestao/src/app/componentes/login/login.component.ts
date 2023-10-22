import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { ModalComponent } from '../modal/modal.component';
import { MatDialog } from '@angular/material/dialog';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
cpf: string = '';
password: string = '';

  ngOnInit(): void {}

  constructor(
    private router: Router,
    private dialog: MatDialog,
    private authService: AuthService) {}

  toogle() {
    console.log('teste');

    this.dialog.open(ModalComponent);
  }

  submit() {
    // const cpf = this.cpf;
    // const password = this.password;

    // this.authService.autenticacaoMedico(cpf, password).subscribe({
    //   next: (autenticado) => {
    //     if (autenticado) {
    //       this.router.navigate(['/medico']);
    //     } else {
    //       console.log("CPF ou senha inválidos");
    //     }
    //   },
    //   error: (error) => {
    //     console.log("Ocorreu um erro na autenticação");
    //   },
    // });
  }
}
