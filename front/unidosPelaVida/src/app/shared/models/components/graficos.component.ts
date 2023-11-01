import { EChartsOption } from "echarts";
import { Grafico } from "../model/grafico.model";

export abstract class GraficoBase {

    porColuna(dados: Grafico):EChartsOption {
        return {
            title: {
            text: dados.titulo,
            subtext: dados.legenda,
            left: 'center'
            },
            tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
            },
            xAxis: {
            type: 'category',
            data: dados.texto
            },
            yAxis: {
            type: 'value'
            },
            series: [
            {
                name: 'Qtde',
                data: dados.valor,
                type: 'bar',
                label: {
                show: true,
                position: 'inside'
                },
                
            }
            ]
        };
    }

    porPizza(dados: Grafico): EChartsOption{
        return {
            title: {
            text: dados.titulo,
            left: 'center'
            },
            tooltip: {
            trigger: 'item'
            },
            series: [
            {
                name: dados.legenda,
                type: 'pie',
                radius: ['0%', '60%'],
                labelLine: {
                length: 30
                },
                label: {
                formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}\n  {per|{d}%}  ',
                backgroundColor: '#FFF',
                borderColor: '#cfcfcf',
                borderWidth: 1,
                borderRadius: 4,
                padding: [3, 4, 5, 3],
        
                rich: {
                    a: {
                    color: '#6E7079',
                    lineHeight: 22,
                    align: 'center'
                    },
                    hr: {
                    borderColor: '#8C8D8E',
                    width: '100%',
                    borderWidth: 1,
                    height: 0
                    },
                    b: {
                    color: '#4C5058',
                    fontSize: 14,
                    fontWeight: 'bold',
                    lineHeight: 33
                    },
                    per: {
                    color: '#fff',
                    backgroundColor: '#4C5058',
                    padding: [3, 4],
                    borderRadius: 4
                    }
                }
                },
                data: dados.resultadoAgrupado
            }
            ]
        };
        
    }
}