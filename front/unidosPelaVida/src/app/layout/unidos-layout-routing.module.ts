import { RouterModule, Routes } from '@angular/router';
import { Erro404Component } from 'src/app/pages/erro404/erro-404.component';
import { NgModule } from '@angular/core';
import { InicioModule } from 'src/app/pages/inicio/inicio.module';
import { UploadModule } from '../pages/upload/upload.module';

export const routes: Routes = [
    { path: 'inicio', loadChildren: () => InicioModule },
    { path: 'upload', loadChildren: () => UploadModule },
    { path: '**', component: Erro404Component }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class UnidosLayoutRoutingModule { }
