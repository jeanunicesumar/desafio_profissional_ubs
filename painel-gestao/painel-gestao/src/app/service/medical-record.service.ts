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
        id: id,
        description : description,
        data: data
      };
      return this.http.post<any>(this.url, medicalRecordData);
}
}
//não está salvando o prontuário - está dando erro 400 - verificar
