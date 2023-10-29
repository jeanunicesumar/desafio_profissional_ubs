import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PatientService {
  private url: string = 'http://localhost:8080/patient';

  constructor(private http: HttpClient) {}

  save(data: FormGroup): Observable<any> {
    return this.http.post(this.url, data);
  }
}
