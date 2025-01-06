package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalComLista {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Quarto de Guerra", 2015);
        Filme outroFilme = new Filme("Avatar",2023);
        Filme filmeJuliana = new Filme("Os Corajosos", 2011);
        Serie lost = new Serie("Lost", 2010);

        //avaliacao
        meuFilme.avalia(8.3);
        outroFilme.avalia(7.5);
        filmeJuliana.avalia(10);

        ArrayList<Titulo> lista = new ArrayList<>(); //cria um array do tipo Filme
        lista.add(filmeJuliana);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for (Titulo item : lista){
            System.out.println(item.getNome());
            //pergunta para o item se ele é do tipo Filme , a palavra instanceof verifica o tipo da variavel
            if(item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificacao: " + filme.getClassificacao());
            }

        }
    }
}
