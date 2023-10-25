import { ConsultaCepService } from './../../../service/consulta-cep.service';
import { NgForm } from '@angular/forms';
import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent {
  constructor(
    private router: Router,
    private consultaCepService: ConsultaCepService,
    private route: ActivatedRoute
  ){}

  consultaCep(ev: any, f: NgForm){
    const cep = ev.target.value;
    if(cep !== ''){
      this.consultaCepService.getConsultaCep(cep)
       .subscribe(resultado => {
        console.log(resultado)
        this.populandoEndereco(resultado, f);
      });
    }
  }

  populandoEndereco(dados: any, f: NgForm){
    f.form.patchValue({
      endereco: dados.logradouro,
      complemento: dados.complemento,
      bairro: dados.bairro,
      cidade: dados.localidade,
      estado: dados.uf
    })
  }

  cadastrar(form: NgForm){
        if(form.valid){
          this.router.navigate(['/sucesso']);
        } else {
          alert('Formulário inválido');
        }
        console.log(form.controls);
      }

  isPatient(){
    const currentRoute = this.route.snapshot?.routeConfig?.path;

    if (currentRoute === 'cadastrarPaciente') {
      return true;
    } else if (currentRoute === 'cadastrarMedico') {
      return false;
    } else {
      console.log("Não tem retorno");
      return false;
    }
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
