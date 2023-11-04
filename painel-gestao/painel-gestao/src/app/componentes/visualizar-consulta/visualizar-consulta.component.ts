import { Component } from '@angular/core';
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
    private appointmentService: AppointmentService) { }

  ngOnInit(): void {
    this.appointmentService.getAllAppointments().subscribe((data) => {
      this.consultas = data.content;
    })

}
}
