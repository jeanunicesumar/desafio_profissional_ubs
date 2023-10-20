import { NgForm } from '@angular/forms';
import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent {
  constructor(
    private router: Router,
  ){}

  cadastrar(form: NgForm){
        if(form.valid){
          this.router.navigate(['/sucesso']);
        } else {
          alert('Formulário inválido');
        }
        console.log(form.controls);
      }

}


// import { SucessoCadastroComponent } from '../sucesso-cadastro/sucesso-cadastro.component';
// import { ConsultaCepService } from '../service/consulta-cep.service';

// export class CadastroComponent implements OnInit {

//   constructor(private router: Router,
//     private consultaCepService: ConsultaCepService) { }

//   ngOnInit(): void {
//   }

//   consultaCep(ev: any, f: NgForm){
//     const cep = ev.target.value;
//     if(cep !== ''){
//       this.consultaCepService.getConsultaCep(cep)
//        .subscribe(resultado => {
//         console.log(resultado)
//         this.populandoEndereco(resultado, f);
//       });
//     }
//   }

//   populandoEndereco(dados: any, f: NgForm){
//     f.form.patchValue({
//       endereco: dados.logradouro,
//       complemento: dados.complemento,
//       bairro: dados.bairro,
//       cidade: dados.localidade,
//       estado: dados.uf
//     })
//   }

//   cadastrar(form: NgForm){
//     if(form.valid){
//       this.router.navigate(['/sucesso']);
//     } else {
//       alert('Formulário inválido');
//     }
//     console.log(form.controls);
//   }
// }
