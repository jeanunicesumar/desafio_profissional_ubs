import { MatDialogModule } from '@angular/material/dialog';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './componentes/header/header.component';
import { LoginComponent } from './componentes/login/login.component';
import { ModalComponent } from './componentes/login/modal/modal.component';
import { MenuLateralComponent } from './componentes/menu-lateral/menu-lateral.component';
import { MedicoGuard } from './guards/medico.guard';
import { AdministradorGuard } from './guards/administrador.guard';
import { MedicoComponent } from './componentes/medico/medico.component';
import { VisualizarConsultaComponent } from './componentes/visualizar-consulta/visualizar-consulta.component';
import { CadastroUsuarioComponent } from './componentes/administrador/cadastro-usuario/cadastro-usuario.component';
import { CadastrarComponent } from './componentes/administrador/cadastrar/cadastrar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MensagemComponent } from './componentes/mensagem/mensagem.component';
import { ValidandoCepDirective } from './directives/validando-cep.directive';
import { AgendamentoComponent } from './componentes/agendamento/agendamento.component';
import { AgendamentoItemComponent } from './componentes/agendamento/agendamento-item/agendamento-item.component';
import { PacienteComponent } from './componentes/paciente/paciente.component';
import { PacienteItemComponent } from './componentes/paciente/paciente-item/paciente-item.component';
import { DadosPacienteComponent } from './componentes/administrador/dados-paciente/dados-paciente.component';
import { VisualizarDadosPacienteComponent } from './componentes/administrador/visualizar-dados-paciente/visualizar-dados-paciente.component';
import { ConsultaComponent } from './componentes/medico/consulta/consulta.component';
import { FooterComponent } from './componentes/footer/footer.component';
import { TextareaAutoresizeDirective } from './directives/textarea-autoresize.directive';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    ModalComponent,
    MenuLateralComponent,
    MedicoComponent,
    VisualizarConsultaComponent,
    CadastroUsuarioComponent,
    CadastrarComponent,
    MensagemComponent,
    ValidandoCepDirective,
    AgendamentoComponent,
    AgendamentoItemComponent,
    PacienteComponent,
    PacienteItemComponent,
    DadosPacienteComponent,
    VisualizarDadosPacienteComponent,
    ConsultaComponent,
    FooterComponent,
    TextareaAutoresizeDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatDialogModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [MedicoGuard, AdministradorGuard],
  bootstrap: [AppComponent],
})
export class AppModule {}
