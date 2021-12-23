import { Component, OnInit } from '@angular/core';
import { ConnexionService } from '../connexion.service';

@Component({
  selector: 'app-liste',
  templateUrl: './liste.page.html',
  styleUrls: ['./liste.page.scss'],
})
export class ListePage implements OnInit {
  listeApprenants: any

  constructor(private _service: ConnexionService)
  {
    this.allApprenants();
  }

  allApprenants()
  {
    this._service.getAllUapprenant().subscribe(
      res=>{
        this.listeApprenants = res;
      }
    )
  }

  ngOnInit() {
  }

}
