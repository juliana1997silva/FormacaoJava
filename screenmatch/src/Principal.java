import br.com.alura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculo.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodios;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        Filme meuFilme = new Filme();
        meuFilme.setNome("Quarto de Guerra");
        meuFilme.setAnoLancamento(2015);
        meuFilme.setDuracaoMinutos(180);

        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println("Total de Avaliações: " + meuFilme.getTotalAvaliacao());
        System.out.println(meuFilme.obterMedia());

        System.out.println("Duração do filme: " + meuFilme.getDuracaoMinutos());

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoLancamento(2010);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(8);
        lost.setMinutosPorEpisodio(50);

        System.out.println("Duração da serie: " + lost.getDuracaoMinutos());

        Filme outraFilme = new Filme();
        outraFilme.setNome("Avatar");
        outraFilme.setAnoLancamento(2023);
        outraFilme.setDuracaoMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outraFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();

        filtro.filtrar(meuFilme);

        Episodios episodio = new Episodios();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacao(300);

        filtro.filtrar(episodio);

        Filme filmeJuliana = new Filme();
        filmeJuliana.setNome("Os Corajosos");
        filmeJuliana.setAnoLancamento(2011);
        filmeJuliana.setDuracaoMinutos(189);

        ArrayList<Filme> listaFilmes = new ArrayList<>(); //cria um array do tipo Filme
        listaFilmes.add(filmeJuliana);
        listaFilmes.add(meuFilme);
        listaFilmes.add(outraFilme);
        System.out.println("tamanho da lista: " + listaFilmes.size());
        System.out.println("1º filme da lista: " + listaFilmes.get(0).getNome());
        System.out.println("toString do filme " + listaFilmes.get(0).toString());
        //array devolve um tostring de cada elemente dentro dele
        System.out.println(listaFilmes);

    }
}
