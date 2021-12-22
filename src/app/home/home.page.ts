import { Platform } from '@ionic/angular';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { NavController } from '@ionic/angular';
import { Router } from '@angular/router';



@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {
  pet: string = "accueil";
  isAndroid: boolean = false;

  

  constructor(
    platform: Platform,
    private navCtrl: NavController,
   private formBuilder: FormBuilder,
    private router: Router
    ) {
    this.isAndroid = platform.is('android');
  }
  ngOnInit() {}

}
