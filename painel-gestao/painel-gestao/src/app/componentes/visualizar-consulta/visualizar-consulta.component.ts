import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppointmentService } from 'src/app/service/appointment.service';

@Component({
  selector: 'app-visualizar-consulta',
  templateUrl: './visualizar-consulta.component.html',
  styleUrls: ['./visualizar-consulta.component.css']
})
export class VisualizarConsultaComponent {
  consultas: any[] = [];
  medico!: string;

  constructor(
    private appointmentService: AppointmentService,
    private router: Router
    ) { }

    openConsulta(patientId: number){
      console.log(patientId);
      this.router.navigate(['/medico/consulta', patientId])

    }

  ngOnInit(): void {
    this.appointmentService.getAllAppointments().subscribe((data) => {
      this.consultas = data.content;
    })
}
}


