import { Component, OnInit } from '@angular/core';
import { PatientService } from '../../../service/patient.service';
import { MatDialog } from '@angular/material/dialog';
import { VisualizarDadosPacienteComponent } from '../visualizar-dados-paciente/visualizar-dados-paciente.component';

@Component({
  selector: 'app-dados-paciente',
  templateUrl: './dados-paciente.component.html',
  styleUrls: ['./dados-paciente.component.css'],
})
export class DadosPacienteComponent implements OnInit {
  person: any[] = [];
  selectedPatientId!: number;

  constructor(
    private patientService: PatientService,
    private dialog: MatDialog
    ) {}

    toogle(patientId: number) {
      this.selectedPatientId = patientId;
      this.dialog.open(VisualizarDadosPacienteComponent, {
        data: {patientId: this.selectedPatientId}
      });
    }

  ngOnInit(): void {
    this.patientService.getAllPatients().subscribe((data) => {
      this.person = data.content;
    })
  }
}

