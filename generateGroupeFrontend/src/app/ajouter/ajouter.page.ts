import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { ConnexionService } from '../connexion.service';


@Component({
  selector: 'app-ajouter',
  templateUrl: './ajouter.page.html',
  styleUrls: ['./ajouter.page.scss'],
})
export class AjouterPage implements OnInit {
  apprenant: FormGroup;
  apprenantBody: any

  constructor(private formBuilder: FormBuilder, private _service: ConnexionService, private router: Router)
  {
    this.apprenant = this.formBuilder.group({
      nomComplet: ['', Validators.required],
      email: ['', Validators.required],
      phone: ['', Validators.required]
    });
  }

  ngOnInit() {}

  saveApprenant()
  {
    this.apprenantBody = {
      nomComplet: this.apprenant.value.nomComplet,
      email: this.apprenant.value.email,
      tel: this.apprenant.value.phone
    }
    
    this._service.addApprenant(this.apprenantBody).subscribe(
      res=>{
        console.log(res);
        this.router.navigate(['liste']);
      }
    )
    
  }

}
