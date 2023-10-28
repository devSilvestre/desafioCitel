import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { NavbarUnidosComponent } from './navbar-unidos/navbar-unidos.component';
import { FooterComponent } from './footer/footer.component';
import { UnidosLayoutComponent } from '../layout/unidos-layout.component';


@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  declarations: [
    FooterComponent,
    NavbarUnidosComponent,
    UnidosLayoutComponent
  ],
  exports: [
    FooterComponent,
    NavbarUnidosComponent
  ],
  providers:[]
})
export class ComponentsModule { }
