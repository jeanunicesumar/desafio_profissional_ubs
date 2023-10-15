import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})

export class ModalComponent {
  @Input()
  mostrar!: boolean;

   constructor() {}

  ngOnInit(): void {};

  fecharModal() {
    this.mostrar= false;
     window.location.reload();
  }
}
