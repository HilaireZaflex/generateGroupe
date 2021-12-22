import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { NavController } from '@ionic/angular';
import { ConnexionService } from '../connexion.service';


@Component({
  selector: 'app-ajouter',
  templateUrl: './ajouter.page.html',
  styleUrls: ['./ajouter.page.scss'],
})
export class AjouterPage implements OnInit {
  validations_form: FormGroup;
  errorMessage: string = '';
  successMessage: string = '';

  validation_messages = {

    'nomComplet': [
      { type: 'required', message: 'le nom est obligatoire.' },
      { type: 'pattern', message: 'Entrez un nom valide.' }
    ],
    'email': [
      { type: 'required', message: 'Email est obligatoire.' },
      { type: 'pattern', message: 'Entrez un email valide.' }
    ],
    'tel': [
      { type: 'required', message: 'Tel est obligatoire.' },
      { type: 'minlength', message: 'le telephone doit contenir au moins 5 caractères.' }
    ]
  };


  constructor(
    private navCtrl: NavController,
    private authService: ConnexionService,
    private formBuilder: FormBuilder,
    private router: Router
  ) { }

  ngOnInit() {
    this.validations_form = this.formBuilder.group({
      nomComplet: [''],
      email: [''],
      tel: ['']
    })
    
    this.validations_form = this.formBuilder.group({
      nomComplet: new FormControl('', Validators.compose([
        Validators.minLength(10),
        Validators.required
      ])),
      email: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')
      ])),
      tel: new FormControl('', Validators.compose([
        Validators.minLength(8),
        Validators.required
      ])),
    });
  }

}
