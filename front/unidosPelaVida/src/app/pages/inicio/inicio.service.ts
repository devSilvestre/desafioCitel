import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Observable, map } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class InicioService {

  constructor(private router: Router, private http: HttpClient) { }

  buscarCanis(pagina: number, limite: number, nome: string, bairro: string, cidade: string, publicos: boolean): Observable<any> {
    return this.http.get(`${environment.URL}public/canis?pagina=${pagina}&limite=${limite}${nome ? '&nome=' + nome.toUpperCase() : ''}${bairro ? '&bairro=' + bairro.toUpperCase() : ''}${cidade ? '&cidade=' + cidade.toUpperCase() : ''}${publicos ? '&publicos=true' : ''}`);
  }

  buscarDados(): Observable<any>{
    return this.http.get(`${environment.URL}public/dados`);
  }

  buscarAnuncios():Observable<any>{
    return this.http.get(`${environment.URL}public/anuncios`);
  }
}