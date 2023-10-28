import { HttpClient } from "@angular/common/http";
import { Injectable, Type } from "@angular/core";
import { Router } from "@angular/router";
import Swal, { SweetAlertPosition } from "sweetalert2";

@Injectable()
export class UtilService {

    interval: any;
    
    constructor(private router: Router, private http: HttpClient) { }

    private toast = Swal.mixin({
        toast: true,
        showConfirmButton: false,
        timer: 3500,
    })

    //-----------------------------------------------------------------------------------------------------------------------------------------
    //SWAL e ALERTAS
    private exibirAlerta(tipo: 'error' | 'info' | 'question' | 'success' | 'warning', mensagem: string, titulo: string, central: boolean, posicao: SweetAlertPosition) {
        if (central) {
            Swal.fire({ icon: tipo, title: titulo ? titulo : '', html: mensagem });
        } else {
            this.toast.fire({ icon: tipo, title: titulo ? titulo : '', html: mensagem, position: posicao ? posicao : "top-end" });
        }
    }

    alertaDelay(segundos: number, mensagem: string) {
        this.interval = setTimeout(() => { clearInterval(this.interval); this.alertaSucesso(mensagem); }, segundos * 1000);
    }

    /**
     * 
     * @param mensagem - mensagem a ser exibida no campo de mensagem
     * @param erro - objeto de erro se houver, será concatenado com a mensagem (Opcional)
     * @param titulo - titulo do erro (Opcional)
     * @param central - Se a mensagem será exibida no centro da tela (Padrão: falso, exibindo topo-direito)
     */
    alertaErro(mensagem: string, erro?: any, titulo?: string, central?: boolean, posicao?: SweetAlertPosition) {
        if (erro) {
            mensagem += (erro.error.errors ? erro.error.errors.join('<br/>') : erro.error.message);
        }
        this.exibirAlerta('error', mensagem, titulo, central, posicao);
    }

    /**
     * 
     * @param mensagem - mensagem a ser exibida no campo de mensagem
     * @param titulo - titulo do alerta (Opcional)
     * @param central - Se a mensagem será exibida no centro da tela (Padrão: falso, exibindo topo-direito)
     */
    alertaInfo(mensagem: string, titulo?: string, central?: boolean, posicao?: SweetAlertPosition) {
        this.exibirAlerta('info', mensagem, titulo, central, posicao);
    }

    /**
     * 
     * @param mensagem - mensagem a ser exibida no campo de mensagem
     * @param titulo - titulo do alerta (Opcional)
     * @param central - Se a mensagem será exibida no centro da tela (Padrão: falso, exibindo topo-direito)
     */
    alertaQuestion(mensagem: string, titulo?: string, central?: boolean, posicao?: SweetAlertPosition) {
        this.exibirAlerta('question', mensagem, titulo, central, posicao);
    }

    /**
    * 
    * @param mensagem - mensagem a ser exibida no campo de mensagem
    * @param titulo - titulo do alerta (Opcional)
    * @param central - Se a mensagem será exibida no centro da tela (Padrão: falso, exibindo topo-direito)
    */
    alertaSucesso(mensagem: string, titulo?: string, central?: boolean, posicao?: SweetAlertPosition) {
        this.exibirAlerta('success', mensagem, titulo, central, posicao);
    }

    /**
    * 
    * @param mensagem - mensagem a ser exibida no campo de mensagem
    * @param titulo - titulo do alerta (Opcional)
    * @param central - Se a mensagem será exibida no centro da tela (Padrão: falso, exibindo topo-direito)
    */
    alertaAviso(mensagem: string, titulo?: string, central?: boolean, posicao?: SweetAlertPosition) {
        this.exibirAlerta('warning', mensagem, titulo, central, posicao);
    }

    dialogConfirmacao(titulo: string, labelSalvar?: string, labelRecusar?: string, text?: string): Promise<void> {
        let p = new Promise<void>((resolve, reject) => {
            Swal.fire({
                title: titulo,
                showDenyButton: true,
                focusConfirm: false,
                text: text ? text : '',
                showCancelButton: false,
                confirmButtonText: labelSalvar ? labelSalvar : 'Salvar',
                denyButtonText: labelRecusar ? labelRecusar : 'Cancelar',
            }).then((result) => {
                if (result.isConfirmed) {
                    resolve();
                } else if (result.isDenied) {
                    reject();
                }
            })
        });

        return p;
    }
}