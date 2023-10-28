import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UnidosLayoutRoutingModule } from './unidos-layout-routing.module';
import { UtilService } from 'src/app/shared/services/util.service';

@NgModule({
    declarations: [
    ],
    imports: [
        CommonModule,
        FormsModule,
        UnidosLayoutRoutingModule
    ],
    providers: [UtilService]
})
export class UnidosLayoutModule { }
