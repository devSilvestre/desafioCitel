import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { UnidosLayoutComponent } from './layout/unidos-layout.component';
import { UnidosLayoutModule } from './layout/unidos-layout.module';

const routes: Routes = [
  { path: '', redirectTo: 'inicio', pathMatch: 'full', },
  {
    path: '', component: UnidosLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: () => UnidosLayoutModule
      }
    ]
  }
];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
