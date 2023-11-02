import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-visualizar-dados-paciente',
  templateUrl: './visualizar-dados-paciente.component.html',
  styleUrls: ['./visualizar-dados-paciente.component.css']
})
export class VisualizarDadosPacienteComponent {

  constructor(private dialogRef: MatDialogRef<VisualizarDadosPacienteComponent>){}

  close(){
    this.dialogRef.close();
  }

}
