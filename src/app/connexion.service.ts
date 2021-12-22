import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConnexionService {
  create(value: any) {
    throw new Error('Method not implemented.');
  }
  logIn(userEmail: any, userPassword: any) {
    throw new Error('Method not implemented.');
  }
  apiUrl = "http://localhost:8080/api";

  constructor(private httpClient: HttpClient) { }

  addApprenant(apprenant:any)
  {
    this.httpClient.post(this.apiUrl+"/apprenant/addApprenant", apprenant);
  }
}
