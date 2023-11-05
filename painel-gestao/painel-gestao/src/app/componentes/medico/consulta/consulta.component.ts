import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MedicalRecordService } from 'src/app/service/medical-record.service';
import { PatientService } from 'src/app/service/patient.service';

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styleUrls: ['./consulta.component.css']
})

export class ConsultaComponent {
  patientData: any = {};
  patientAge!: number;
  description: string = '';

  constructor(
    private route: ActivatedRoute,
    private patientService: PatientService,
    private medicalRecordService: MedicalRecordService
  ) {}

  ngOnInit(): void {
   this.route.params.subscribe(params => {
    const patientId = params['patientId'];
    this.patientService.getPatientData(patientId).subscribe(data => {
      this.patientData = data;
      if (this.patientData?.person?.birthDate) {
        this.patientAge = this.calculateAge(this.patientData.person.birthDate);
        console.log(this.patientAge);}
    });
   });
  }
  saveMedicalRecord() {
    const id = this.patientData.id;
    const description = this.description;
    const data = new Date();

    this.medicalRecordService.saveMedicalRecord(id, description, data)
      .subscribe(savedRecord => {
        console.log('Prontuário salvo:', savedRecord);
      });
  }

calculateAge(birthDate: string): number {
  const today = new Date();
  const birthDateObj = new Date(birthDate);
  const age = today.getFullYear() - birthDateObj.getFullYear();

  if (today.getMonth() < birthDateObj.getMonth() || (today.getMonth() === birthDateObj.getMonth() && today.getDate() < birthDateObj.getDate())) {
    return age - 1;
  }

  return age;
}
}
