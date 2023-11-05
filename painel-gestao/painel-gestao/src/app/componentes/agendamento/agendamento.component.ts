import { Component, OnInit } from '@angular/core';
import { AgendamentoService } from './agendamento.service';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-agendamento',
  templateUrl: './agendamento.component.html',
  styleUrls: ['./agendamento.component.css'],
})
export class AgendamentoComponent implements OnInit {
  public result: any;
  susCode: string = '';

  constructor(
    private service: AgendamentoService,
    private searchService: SearchService
    ) {}

  ngOnInit(): void {
    this.service.findAll().subscribe((item) => {
      this.result = item.content;
    });
  }

  searchBySusCode(){
    const susCode = parseInt(this.susCode);
    console.log(susCode);
    if (!isNaN(susCode)) {

      this.searchService.searchPatientsBySusCode(susCode)
        .subscribe((results: any) => {
          this.result = results;

          console.log(results);
        });
  }
}
}
//Falta arrumar o search (está trazendo mais de um resultado)
//Fazer tela para agendar nova consulta
