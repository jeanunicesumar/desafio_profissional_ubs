import { Component, OnInit } from '@angular/core';
import { PatientService } from '../cadastrar/patient.service';

@Component({
  selector: 'app-dados-paciente',
  templateUrl: './dados-paciente.component.html',
  styleUrls: ['./dados-paciente.component.css']
})
export class DadosPacienteComponent implements OnInit {

  patient: any = {};

  constructor(
    private patientService: PatientService
  ){}

  ngOnInit(): void {
    this.patientService.getAllPatients().subscribe(data => {
      this.patient = data;
    });


  // }
  }
}
