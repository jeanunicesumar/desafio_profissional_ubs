import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
  autenticacaoMedico(): boolean {
    return true;
  }
  autenticacaoAdmnistrador(): boolean {
    return true;
  }
}
