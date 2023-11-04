import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { PatientService } from '../../../service/patient.service';

@Component({
  selector: 'app-visualizar-dados-paciente',
  templateUrl: './visualizar-dados-paciente.component.html',
  styleUrls: ['./visualizar-dados-paciente.component.css']
})
export class VisualizarDadosPacienteComponent {
  patientData: any;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    private dialogRef: MatDialogRef<VisualizarDadosPacienteComponent>,
    private patientService: PatientService){}

  ngOnInit()
  {
    if (this.data && this.data.patientId) {
     this.patientService.getPatientData(this.data.patientId)
        .subscribe(data => {
          this.patientData = data;
        });
  }
  }
  close() {
    this.dialogRef.close();
  }
}
