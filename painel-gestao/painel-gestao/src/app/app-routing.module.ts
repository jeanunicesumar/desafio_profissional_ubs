import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './componentes/login/login.component';
import { AdministradorGuard } from './guards/administrador.guard';
import { MedicoGuard } from './guards/medico.guard';
import { MedicoComponent } from './componentes/medico/medico.component';
import { CadastroUsuarioComponent } from './componentes/administrador/cadastro-usuario/cadastro-usuario.component';
import { CadastrarComponent } from './componentes/administrador/cadastrar/cadastrar.component';
import { AgendamentoComponent } from './componentes/agendamento/agendamento.component';
import { PacienteComponent } from './componentes/paciente/paciente.component';
import { DadosPacienteComponent } from './componentes/administrador/dados-paciente/dados-paciente.component';
import { ConsultaComponent } from './componentes/medico/consulta/consulta.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'medico',
    component: MedicoComponent,
    canActivate: [MedicoGuard],
  },
  {
    path: 'administrador',
    component: CadastroUsuarioComponent,
    canActivate: [AdministradorGuard],
  },
  {
    path: 'cadastrarMedico',
    component: CadastrarComponent,
    canActivate: [AdministradorGuard],
  },
  {
    path: 'cadastrarPaciente',
    component: CadastrarComponent,
    canActivate: [AdministradorGuard],
  },

  {
    path: 'agendamento',
    component: AgendamentoComponent,
    canActivate: [AdministradorGuard],
  },

  {
    path: 'paciente',
    component: PacienteComponent,
    canActivate: [AdministradorGuard, MedicoGuard],
  },

  {
    path: 'visualizar-dados',
    component: DadosPacienteComponent,
    canActivate: [AdministradorGuard, MedicoGuard],
  },
  {
    path: 'medico/consulta/:patientId',
    component: ConsultaComponent,
    canActivate: [MedicoGuard],
  },
  {
    path: 'consulta',
    component: ConsultaComponent,
    canActivate: [MedicoGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
