import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AffichagePageRoutingModule } from './affichage-routing.module';

import { AffichagePage } from './affichage.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AffichagePageRoutingModule
  ],
  declarations: [AffichagePage]
})
export class AffichagePageModule {}
