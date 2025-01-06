package br.com.alura.screenmatch.calculo;

import br.com.alura.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    /*public void inclui(Filme f){
        tempoTotal += f.getDuracaoMinutos();
    }

    public void inclui(Serie s){
        tempoTotal += s.getDuracaoMinutos();
    }*/

    public void inclui(Titulo titulo){
        tempoTotal += titulo.getDuracaoMinutos();
    }
}
