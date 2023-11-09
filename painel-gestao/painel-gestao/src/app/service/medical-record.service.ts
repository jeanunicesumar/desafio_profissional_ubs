import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MedicalRecordService {
  private url = 'http://localhost:8080/medicalRecord';

  constructor(
    private http: HttpClient
  ) { }

  saveMedicalRecord(id: number, description: string, data: Date){
      const medicalRecordData = {
        description : description,
      };
      console.log("Prontuário salvo");
      return this.http.post<any>(this.url, medicalRecordData);
}
}
