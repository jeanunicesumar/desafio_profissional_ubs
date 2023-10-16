import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { ModalComponent } from '../modal/modal.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  ngOnInit(): void {}

  isDoctor: boolean = false;

  constructor(private router: Router, private dialog: MatDialog) {}

  toogle() {
    console.log('teste');

    this.dialog.open(ModalComponent);
  }

  submit() {
    if (this.isDoctor) {
      this.router.navigate(['/medico']);
      return;
    }
    this.router.navigate(['/administrador']);
  }
}
