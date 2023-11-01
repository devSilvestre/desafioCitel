import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { InicioService } from './inicio.service';
import { UtilService } from 'src/app/shared/services/util.service';
import { EChartsOption } from 'echarts';
import { GraficoBase } from 'src/app/shared/models/components/graficos.component';
import { Grafico } from 'src/app/shared/models/model/grafico.model';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.scss']
})
export class InicioComponent extends GraficoBase implements OnInit {
  
  constructor( private inicioService: InicioService,private router: Router, private util: UtilService) { super() }

  visualizar:boolean = false;
  qtdeCadastros: number = 0;

  //grafico
  regiao: string = 'todas regiões';
  graficoCandidatosRegiao: EChartsOption 
  graficoImcPorFaixaEtaria: EChartsOption 
  graficoPorObesidade: EChartsOption
  graficoPorMediaIdadeTipoSangue: EChartsOption
  graficoPorReceptorPorTipoSangue: EChartsOption

  ngOnInit() {
    this.inicioService.buscarDados().subscribe({
      next: (res) =>{

        if(res.data > 0){
          this.visualizar = !this.visualizar;
          this.qtdeCadastros = res.data;
          this.buscarPorRegiao();
          this.buscarPorIMC();
          this.buscarPorObesidade();
          this.buscarPorMediaIdadeTipoSangue();
          this.buscarPorReceptorPorTipoSangue();
        }else{
          this.visualizar = false;
        }

      }
    });
    
  }

  buscarPorRegiao(){
    this.inicioService.buscarPorRegiao(this.regiao).subscribe({
      next: (res) =>{
        this.graficoCandidatosRegiao = this.porColuna(res.data);
      }
    })
  }

  buscarPorIMC(){
    this.inicioService.buscarPorIMC().subscribe({
      next: (res) =>{
        this.graficoImcPorFaixaEtaria = this.porPizza(res.data);
      }
    })
  }

  buscarPorObesidade(){
    this.inicioService.buscarPorObesidade().subscribe({
      next: (res) =>{
        this.graficoPorObesidade = this.porPizza(res.data);
      }
    })
  }

  buscarPorMediaIdadeTipoSangue(){
    this.inicioService.buscarPorMediaIdadeTipoSangue().subscribe({
      next: (res) =>{
        this.graficoPorMediaIdadeTipoSangue = this.porPizza(res.data);
      }
    })
  }

  buscarPorReceptorPorTipoSangue(){
    this.inicioService.buscarPorReceptorPorTipoSangue().subscribe({
      next: (res) =>{
        this.graficoPorReceptorPorTipoSangue = this.porColuna(res.data);
      }
    })
  }
}
