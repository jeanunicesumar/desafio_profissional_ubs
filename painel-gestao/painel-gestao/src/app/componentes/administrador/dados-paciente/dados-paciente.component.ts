import { Component, OnInit } from '@angular/core';
import { PatientService } from '../cadastrar/patient.service';
import { MatDialog } from '@angular/material/dialog';
import { VisualizarDadosPacienteComponent } from '../visualizar-dados-paciente/visualizar-dados-paciente.component';

@Component({
  selector: 'app-dados-paciente',
  templateUrl: './dados-paciente.component.html',
  styleUrls: ['./dados-paciente.component.css'],
})
export class DadosPacienteComponent implements OnInit {
  person: any[] = [];

  constructor(
    private patientService: PatientService,
    private dialog: MatDialog
    ) {}

    toogle() {
      this.dialog.open(VisualizarDadosPacienteComponent);
    }

  ngOnInit(): void {
    this.patientService.getAllPatients().subscribe((data) => {
      console.log(data);
      this.person = data.content;
    })
  }
}

