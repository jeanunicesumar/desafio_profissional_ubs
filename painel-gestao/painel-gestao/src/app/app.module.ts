import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './componentes/header/header.component';
<<<<<<< HEAD
=======
import { LoginComponent } from './componentes/login/login.component';
>>>>>>> 3388b5e069a62b6159069adefff6dc3206402ed6

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
<<<<<<< HEAD
=======
    LoginComponent,
>>>>>>> 3388b5e069a62b6159069adefff6dc3206402ed6
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
