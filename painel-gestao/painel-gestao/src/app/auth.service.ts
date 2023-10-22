import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  // autenticacaoMedico(cpf: string, password: string): Observable<boolean> {
  //   return this.http.post<boolean>(`${this.baseUrl}/medico`, { cpf, password });
  // }
  autenticacaoMedico(){
    return false;
  }
  autenticacaoAdmnistrador(): boolean {
    return true;
  }
}
