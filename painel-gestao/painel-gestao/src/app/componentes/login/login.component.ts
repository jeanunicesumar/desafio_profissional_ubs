import { Component, OnInit } from '@angular/core';
import { ModalComponent } from '../modal/modal.component';
import { MatDialog } from '@angular/material/dialog';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  form!: FormGroup;

  ngOnInit(): void {
    this.form = this.builder.group({
      cpf: [
        '',
        Validators.compose([
          Validators.required,
          Validators.pattern('^\\d{3}.\\d{3}.\\d{3}-\\d{2}$'),
        ]),
      ],
      password: ['', Validators.required],
    });
  }

  constructor(
    private dialog: MatDialog,
    private service: LoginService,
    private builder: FormBuilder
  ) {}

  toogle() {
    this.dialog.open(ModalComponent);
  }

  formIsValid(): string {
    if (!this.form.valid) {
      return 'disabled';
    }

    return '';
  }

  submit() {
    this.service.auth(this.form.value);
  }
}
