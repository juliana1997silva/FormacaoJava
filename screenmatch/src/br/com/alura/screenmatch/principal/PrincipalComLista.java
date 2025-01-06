package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComLista {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Quarto de Guerra", 2015);
        Filme outroFilme = new Filme("Avatar",2023);
        Filme filmeJuliana = new Filme("Os Corajosos", 2011);
        Serie lost = new Serie("Lost", 2010);
        Serie dogVille = new Serie("DogVille", 2003);

        //avaliacao
        meuFilme.avalia(8.3);
        outroFilme.avalia(7.5);
        filmeJuliana.avalia(10);

        List<Titulo> lista = new LinkedList<>(); //cria um array do tipo Filme
        lista.add(filmeJuliana);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);
        lista.add(dogVille);

        for (Titulo item : lista){
            System.out.println(item.getNome());
            //pergunta para o item se ele é do tipo Filme , a palavra instanceof verifica o tipo da variavel
           /* if(item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificacao: " + filme.getClassificacao());
            }*/

        }

        List<String> buscarArtista = new LinkedList<>();

        buscarArtista.add("Juliana");
        buscarArtista.add("Antonio");
        buscarArtista.add("Natalia");
        buscarArtista.add("Cezar");

        //ordenar a lista string
        Collections.sort(buscarArtista);
        System.out.println(buscarArtista);

        //ordenar a lista por um tipo de uma classe que nos mesmo criamos, modificação na classe
        Collections.sort(lista);
        System.out.println("Ordenação por ordem alfabetica");
        System.out.println(lista);

        //ordenar a lista pelo ano de lancamento
        lista.sort(Comparator.comparing(Titulo::getAnoLancamento));
        System.out.println("Ordenação por ano de lançamento");
        System.out.println(lista);

    }
}
