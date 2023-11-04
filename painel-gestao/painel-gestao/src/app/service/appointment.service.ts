import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  private url: string = 'http://localhost:8080/appointment';

  constructor(
    private http: HttpClient
  ) {}

  getAllAppointments(): Observable<any>{
    return this.http.get(this.url);
  }
}
