import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConnexionService {
  url='http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  //Get all apprenants
  getAllUapprenant(){
    return this.http.get(this.url+"/apprenant/listerApprenant");
  }

  //Save an apprenant
  addApprenant(data:any){
    return this.http.post(this.url+"/apprenant/addApprenant/", data, {responseType:"text"});
  }

  //Delete an apprenant
  deleteApprenant(idApp:any){
    return this.http.delete(this.url+"/apprenant/supprimerApprenant/"+idApp);
  }

  //Modifier un apprenant
  modifierApprenant(userData: any, userId: any){
    return this.http.put(this.url+"/apprenant/modifierApprenant/"+userId, userData);
  }

  //Apprenant par Id
  getApprenantById(id: any)
  {
    return this.http.get(this.url+"/apprenant/detailApprenant/"+id);
  }

}
