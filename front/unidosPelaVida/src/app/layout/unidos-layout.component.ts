import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-unidos-layout',
  templateUrl: './unidos-layout.component.html',
  styleUrls: ['./unidos-layout.component.scss']
})
export class UnidosLayoutComponent implements OnInit, OnDestroy {

  constructor(private router: Router) { }

  ngOnInit() {
    var html = document.getElementsByTagName("html")[0];
    html.classList.add("unidos-layout");
    var body = document.getElementsByTagName("body")[0];
    body.classList.add("bg-default");

  }
  ngOnDestroy() {
    var html = document.getElementsByTagName("html")[0];
    html.classList.remove("unidos-layout");
    var body = document.getElementsByTagName("body")[0];
    body.classList.remove("bg-default");
  }
}
