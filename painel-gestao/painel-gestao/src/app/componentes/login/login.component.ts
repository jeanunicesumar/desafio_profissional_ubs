import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { ModalComponent } from '../modal/modal.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {

  ngOnInit(): void {};

  mostrarModal = false;

  constructor(private router: Router) {}

  openModal() {
    this.mostrarModal = true;
  }

  submit() {
    this.router.navigate(['/header']);
  }
}

