import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private url = 'http://localhost:8080/patient';
  private url2 = 'http://localhost:8080/doctor';

  constructor(
    private http: HttpClient
  ) { }

  searchPatientsBySusCode(susCode: number): Observable<any> {
    const params = new HttpParams().set('susCode', susCode);

    return this.http.get(this.url, {params: params});
  }

}
