import { MatDialogModule } from '@angular/material/dialog';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './componentes/header/header.component';
import { LoginComponent } from './componentes/login/login.component';
import { ModalComponent } from './componentes/modal/modal.component';
import { MenuLateralComponent } from './componentes/menu-lateral/menu-lateral.component';
import { MedicoGuard } from './guards/medico.guard';
import { AdministradorGuard } from './guards/administrador.guard';
import { MedicoComponent } from './componentes/medico/medico.component';
import { VisualizarConsultaComponent } from './componentes/visualizar-consulta/visualizar-consulta.component';
import { CadastroUsuarioComponent } from './componentes/administrador/cadastro-usuario/cadastro-usuario.component';
import { CadastrarComponent } from './componentes/administrador/cadastrar/cadastrar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AgendamentoComponent } from './componentes/agendamento/agendamento.component';

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
    AgendamentoComponent,
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