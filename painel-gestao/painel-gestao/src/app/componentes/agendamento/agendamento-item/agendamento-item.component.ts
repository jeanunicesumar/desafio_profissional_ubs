import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-agendamento-item',
  templateUrl: './agendamento-item.component.html',
  styleUrls: ['./agendamento-item.component.css'],
})
export class AgendamentoItemComponent implements OnInit {
  @Input() appointment: any;

  ngOnInit() {}
}
