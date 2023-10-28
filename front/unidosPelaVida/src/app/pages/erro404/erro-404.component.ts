import { Component, OnInit, OnDestroy } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'app-erro-404',
  templateUrl: './erro-404.component.html',
  styleUrls: ['./erro-404.component.scss']
})
export class Erro404Component implements OnInit, OnDestroy {

  constructor(private location: Location) { }

  ngOnInit() {
  }

  ngOnDestroy() { }

  back(): void {
    this.location.back();
  }

}