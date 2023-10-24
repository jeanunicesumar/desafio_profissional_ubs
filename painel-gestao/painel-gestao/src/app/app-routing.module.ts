import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './componentes/login/login.component';
import { AdministradorGuard } from './guards/administrador.guard';
import { MedicoGuard } from './guards/medico.guard';
import { MedicoComponent } from './componentes/medico/medico.component';
import { CadastroUsuarioComponent } from './componentes/administrador/cadastro-usuario/cadastro-usuario.component';
import { CadastrarComponent } from './componentes/administrador/cadastrar/cadastrar.component';
import { AgendamentoComponent } from './componentes/agendamento/agendamento.component';

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
    path: 'agendamento',
    component: AgendamentoComponent,
    canActivate: [AdministradorGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
