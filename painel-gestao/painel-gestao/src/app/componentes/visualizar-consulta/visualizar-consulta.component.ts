import { Component } from '@angular/core';

@Component({
  selector: 'app-visualizar-consulta',
  templateUrl: './visualizar-consulta.component.html',
  styleUrls: ['./visualizar-consulta.component.css']
})
export class VisualizarConsultaComponent {
  consultas: any[] = [];

  constructor() { }

  ngOnInit() {
    this.consultas = [
      {
        "data": "25/08/2023",
        "horario": "09:30",
        "medico": "Ricardo Vilela"
      },
      {
        "data": "25/08/2023",
        "horario": "10:00",
        "medico": "Ricardo Vilela"
      }
    ];
  }

  // visualizarConsulta(consulta) {
  //     //backend
  // }
}
