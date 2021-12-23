import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { ConnexionService } from '../connexion.service';
import { DataService } from '../data.service';

@Component({
  selector: 'app-liste',
  templateUrl: './liste.page.html',
  styleUrls: ['./liste.page.scss'],
})
export class ListePage implements OnInit {
  listeApprenants: any

  constructor(private _service: ConnexionService, private data: DataService, private router: Router)
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

  deleteApprenant(idApp: any)
  {
    this._service.deleteApprenant(idApp).subscribe(
      result=>{
        console.log(result);
        this.allApprenants();
      }
    )
  }

  updateApprenant(idApp: any)
  {
    let navigationValue: NavigationExtras = {
      queryParams: {id: idApp}
    }

    this.router.navigate(['modifier'], navigationValue)
  }

  //Exporter la liste sous excel
  exportToExcel() {
    this.data.exportToExcel(this.listeApprenants, 'ListeApprenants');
    }

}
