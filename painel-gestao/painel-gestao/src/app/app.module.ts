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
  ],
  imports: [BrowserModule, AppRoutingModule, MatDialogModule],
  providers: [MedicoGuard, AdministradorGuard],
  bootstrap: [AppComponent],
})
export class AppModule {}
