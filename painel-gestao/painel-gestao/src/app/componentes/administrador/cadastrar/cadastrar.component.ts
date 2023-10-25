import { ConsultaCepService } from './../../../service/consulta-cep.service';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent implements OnInit {

  form!: FormGroup;

  ngOnInit(): void {
    this.form = this.createForm();
  }

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private consultaCepService: ConsultaCepService,
    private route: ActivatedRoute
  ){}

  createForm(): FormGroup {
    const form = this.formBuilder.group({
      id: [''],
      susCode: ['', [Validators.required, Validators.pattern('\d{9}\-?\d{5}\-?\d{1}')]],
      person: {
        name: ['', Validators.required],
        motherName: ['', Validators.required],
        fatherName: [''],
        birthDate: ['', Validators.required],
        birthUf: ['', Validators.required],
        birthCity: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
        gender: ['', Validators.required],
        ddd: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(3)]],
        phone: ['', [Validators.required, Validators.pattern('\d{5}\-?\d{4}')]],
        cpf: ['', [Validators.required, Validators.pattern('\d{3}\.?\d{3}\.?\d{3}-?\d{2}')]],
      },
      address: {
        zipCode: ['', [Validators.required, Validators.pattern('^(\d{5})(-?\d{3})$')]], 
        streetAddress: ['', Validators.required],
        streetAddressII: ['', Validators.required],
        number: ['', Validators.required],
        district: ['', Validators.required],
        city: ['', Validators.required],
        uf: ['', Validators.required, Validators.length === 2],
      }
    });

    console.log(form);

    return form;
  }

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
