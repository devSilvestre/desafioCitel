import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpErrorResponse } from '@angular/common/http';
import { catchError, finalize } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Injectable()
export class AuthInterceptorService implements HttpInterceptor {
    private toast = Swal.mixin({
        title: 'Carregando...',
        text: 'Por favor aguarde...',
        showConfirmButton: false,
        showCloseButton: false,
        allowOutsideClick: false
    })
    interval: any;
    emLoad: boolean = false;

    constructor(private rota: Router) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (this.interval) {
            clearInterval(this.interval);
        }
        if (!request.url.includes(environment.URL)) {
            return next.handle(request);
        }
        request = request.clone({
            setHeaders: {
                'Content-Type': 'application/json'
            }
        });

        this.interval = setTimeout(() => { this.toast.fire(); this.emLoad = true }, 2000);

        return next.handle(request).pipe(catchError((e: HttpErrorResponse) => {
            if (e.status == 401) {
                window.localStorage.clear();
                this.rota.navigate(['']);
                return throwError(e);
            } else if (e.status == 403) {
                window.localStorage.clear();
                this.rota.navigate(['']);
                Swal.fire({
                    text: 'Acesso não autenticado ou expirado, faça o login novamente'
                });
                return throwError(e);
            } else {
                return throwError(e);
            }
        }), finalize(() => {
            clearInterval(this.interval);
            if (this.emLoad) {
                this.interval = setTimeout(() => { Swal.close(); this.emLoad = false }, 5000);
            }
        }));
    }

}