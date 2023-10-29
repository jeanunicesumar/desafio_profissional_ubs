import { Component, OnInit } from '@angular/core';
import { AgendamentoService } from './agendamento.service';

@Component({
  selector: 'app-agendamento',
  templateUrl: './agendamento.component.html',
  styleUrls: ['./agendamento.component.css'],
})
export class AgendamentoComponent implements OnInit {
  public result: any;

  constructor(private service: AgendamentoService) {}

  ngOnInit(): void {
    this.service.findAll().subscribe((item) => {
      this.result = item.content;
    });
  }
}
