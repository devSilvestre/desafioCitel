import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Observable, map } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class InicioService {

  constructor(private router: Router, private http: HttpClient) { }

  buscarPorRegiao(regiao: string): Observable<any>{
    return this.http.get(`${environment.URL}grafico/regiao?regiao=${regiao}`);
  }

  buscarPorIMC(): Observable<any>{
    return this.http.get(`${environment.URL}grafico/imc`);
  }

  buscarPorObesidade(): Observable<any>{
    return this.http.get(`${environment.URL}grafico/obesidade`);
  }

  buscarPorMediaIdadeTipoSangue(): Observable<any>{
    return this.http.get(`${environment.URL}grafico/media-idade-tipo-sangue`);
  }

  buscarPorReceptorPorTipoSangue(): Observable<any>{
    return this.http.get(`${environment.URL}grafico/receptor-tipo-sangue`);
  }

  buscarDados(): Observable<any>{
    return this.http.get(`${environment.URL}grafico/por-cpf`);
  }
}