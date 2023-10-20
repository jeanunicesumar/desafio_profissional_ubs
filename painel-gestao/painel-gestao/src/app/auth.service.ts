import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
  autenticacaoMedico(): boolean {
    return false;
  }
  autenticacaoAdmnistrador(): boolean {
    return true;
  }
}
