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

  getPatientData(id: number): Observable<any>{
    console.log(id);
    const url = `${this.url}/${id}`;
    console.log(url);
    return this.http.get(url);
  }

  getAllPatients(): Observable<any> {
    return this.http.get(this.url);
  }
}
