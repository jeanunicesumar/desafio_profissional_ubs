import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TesteComponent } from './teste/teste.component';
<<<<<<< HEAD
import { Teste2Component } from './teste2/teste2.component';
import { Teste3Component } from './teste3/teste3.component';
import { Teste4Component } from './teste4/teste4.component';
=======
>>>>>>> fa3b61d2f1230accb0829c7b01245bc665f00e17

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< HEAD
    TesteComponent,
    Teste2Component,
    Teste3Component,
    Teste4Component,
=======
    TesteComponent
>>>>>>> fa3b61d2f1230accb0829c7b01245bc665f00e17
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
