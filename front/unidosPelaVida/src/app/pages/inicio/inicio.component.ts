import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { InicioService } from './inicio.service';
import { UtilService } from 'src/app/shared/services/util.service';

interface Racas {
  raca:String;
  img:String;
}

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.scss']
})
export class InicioComponent implements OnInit {

  constructor( private inicioService: InicioService,private router: Router, private util: UtilService) {}

  ngOnInit() {
    
  }

}
