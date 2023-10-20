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
    if (this.authService.autenticacaoMedico()) {
      this.router.navigate(['/medico']);
      return;
    } else if (this.authService.autenticacaoAdmnistrador()){
      this.router.navigate(['/administrador']);
    } else {
      console.log("Usuário não existe");
    }
  }
}
