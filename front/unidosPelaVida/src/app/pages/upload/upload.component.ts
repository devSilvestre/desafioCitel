import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { UploadService } from './upload.service';
import { UtilService } from 'src/app/shared/services/util.service';
import { UploadForm } from 'src/app/shared/models/model/uploadForm.model';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent implements OnInit {
  
  selectedFile: File | null = null;
  jsonDados: Array<UploadForm> = new Array<UploadForm>();
  resultado: Array<string> = new Array<string>();
  
  constructor( private uploadService: UploadService,private router: Router, private util: UtilService) {}

  ngOnInit() {}

  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
  }

  enviar() {
    if (!this.selectedFile) {
      this.util.alertaAviso('Selecione um arquivo JSON válido.');
    } else {
      this.lerArquivoEEnviar();
    }
  }

  private lerArquivoEEnviar() {
    this.util.alertaInfo('Carregando...')
    const reader = new FileReader();
    reader.onload = (e) => {
      const content = e.target.result as string;
      this.jsonDados = JSON.parse(content) as Array<UploadForm>;
      this.jsonDados.sort((a, b) => new Date(a.data_nasc).getTime() - new Date(b.data_nasc).getTime());
      this.uploadService.upload(this.jsonDados).subscribe({
        next: (res) => {
          this.resultado = res.data;
          this.util.alertaSucesso('Upload concluido')
        },
        error: (e) => {
          this.util.alertaErro('', e, null, false);
        },
      });
    };
    reader.readAsText(this.selectedFile);
  }

}
