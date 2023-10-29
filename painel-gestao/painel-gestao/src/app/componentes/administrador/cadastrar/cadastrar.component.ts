import { ConsultaCepService } from './../../../service/consulta-cep.service';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PatientService } from './patient.service';

@Component({
  selector: 'app-cadastrar',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css'],
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
    private patientService: PatientService,
    private route: ActivatedRoute
  ) {}

  createForm(): FormGroup {
    const form = this.formBuilder.group({
      id: [''],
      susCode: ['', [Validators.required]],
      person: this.formBuilder.group({
        active: true,
        password: 1234,
        // crm: ['', [Validators.required]],
        // specialty: ['', [Validators.required]],
        name: ['', [Validators.required, Validators.minLength(3)]],
        motherName: ['', Validators.required],
        fatherName: [''],
        birthDate: ['', Validators.required],
        birthUf: ['', Validators.required],
        birthCity: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
        gender: ['', Validators.required],
        ddd: [
          '',
          [
            Validators.required,
            Validators.minLength(2),
            Validators.maxLength(3),
          ],
        ],
        phone: ['', [Validators.required, Validators.pattern('d{5}-?d{4}')]],
        cpf: [
          '',
          [Validators.required, Validators.pattern('d{3}.?d{3}.?d{3}-?d{2}')],
        ],
        address: this.formBuilder.group({
          zipCode: [
            '',
            [Validators.required, Validators.pattern('^(d{5})(-?d{3})$')],
          ],
          streetAddress: ['', Validators.required],
          streetAddressII: ['', Validators.required],
          number: ['', Validators.required],
          district: ['', Validators.required],
          city: ['', Validators.required],
          uf: ['', Validators.required, Validators.length === 2],
        }),
        ubs: {
          id: 1,
          name: 'Teste',
          address: {
            zipCode: '87111-111',
            streetAddress: 'Teste',
            number: '12A',
            district: 'Bairro teste',
            city: 'Maringá',
            uf: 'PR',
          },
        },
      }),
    });

    return form;
  }

  consultaCep(ev: any, form: FormGroup) {
    const cep = ev.target.value;
    if (cep !== '') {
      this.consultaCepService.getConsultaCep(cep).subscribe((resultado) => {
        console.log(resultado);
        this.populandoEndereco(resultado, form);
      });
    }
  }

  populandoEndereco(dados: any, form: FormGroup) {
    form.get('person.address.zipCode')?.setValue(dados.cep);
    form.get('person.address.streetAddress')?.setValue(dados.logradouro);
    form.get('person.address.number')?.setValue(dados.complemento);
    form.get('person.address.district')?.setValue(dados.bairro);
    form.get('person.address.city')?.setValue(dados.localidade);
    form.get('person.address.uf')?.setValue(dados.uf);
  }

  cadastrar(form: NgForm) {
    if (form.valid) {
      this.router.navigate(['/sucesso']);
    } else {
      alert('Formulário inválido');
    }
    console.log(form.controls);
  }

  isPatient() {
    const currentRoute = this.route.snapshot?.routeConfig?.path;

    if (currentRoute === 'cadastrarPaciente') {
      return true;
    } else if (currentRoute === 'cadastrarMedico') {
      return false;
    } else {
      console.log('Não tem retorno');
      return false;
    }
  }

  save() {
    this.patientService.save(this.form.value).subscribe((response) => {
      console.log(response);
    });
  }
}
