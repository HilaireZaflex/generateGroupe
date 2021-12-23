import { Component, OnInit } from '@angular/core';
import { ConnexionService } from '../connexion.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Validators, FormBuilder, FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-modifier',
  templateUrl: './modifier.page.html',
  styleUrls: ['./modifier.page.scss'],
})
export class ModifierPage implements OnInit {
  currentApprenant: any
  currentApprenantId: any
  apprenantAModifier: FormGroup;
  apprenantBody: any

  constructor(private formBuilder: FormBuilder, private _service: ConnexionService,
    private router: Router, private activedRoute: ActivatedRoute){
      
      this.activedRoute.queryParams.subscribe(
        data=>{
          this.currentApprenantId = data.id;
          this.currentApprenantDetails(this.currentApprenantId);
        }
      )
      
      this.apprenantAModifier = this.formBuilder.group({
        nomComplet: ['', Validators.required],
        email: ['', Validators.required],
        phone: ['', Validators.required]
      });
    }

  ngOnInit() {
  }

  currentApprenantDetails(id: any)
  {
    this._service.getApprenantById(id).subscribe(
      res=>{
        this.currentApprenant = res;
        console.log(this.currentApprenant);
      }
    )
  }

  updateApprenant()
  {
    this.apprenantBody = {
      nomComplet: this.apprenantAModifier.value.nomComplet,
      email: this.apprenantAModifier.value.email,
      tel: this.apprenantAModifier.value.phone
    }

    this._service.modifierApprenant(this.apprenantBody, this.currentApprenantId).subscribe(
      result=>{
        this.router.navigateByUrl("liste");
      }
    )

  }

}

