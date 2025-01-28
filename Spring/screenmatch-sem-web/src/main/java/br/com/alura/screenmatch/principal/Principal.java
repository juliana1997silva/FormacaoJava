package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

    private  ConsumoApi api = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=58e18a8c";

    public void exibeMenu() throws JsonProcessingException {
        System.out.println("Digite a série que deseja pesquisar ?");
        var nomeSerie = leitura.nextLine();
        var json = api.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        DadosSerie dados = conversor.obterDados(json, DadosSerie.class); // converte o json na classe que estou enviando
        System.out.println(dados);

        List<DadosTemporada> temporadaList = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = api.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadaList.add(dadosTemporada);
		}

		temporadaList.forEach(System.out::println);

        temporadaList.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        //EXEMPLO
//        Operação Intermediaria => Gera um novo fluxo de dados e que podemos fazer uma nova operação
//        Operação Final => São aquelas que finaliza aquela stream

//        List<String> nomes = Arrays.asList("Juliana", "Antonio", "Nathalia");
//        nomes.stream()
//                .sorted() //ordena com ordem alfabetica
//                .limit(3) //limita o resultado para os 3 primeiros
//                .filter(n -> n.startsWith("A")) // filtra o nome que comeca com a letra A
//                .map(n -> n.toUpperCase()) //aparece o nome tudo com letra maiuscula
//                .forEach(System.out::println);

        List<DadosEpisodio> dadosEpisodios = temporadaList.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList()); // consigo adicionar coisas novas nessa lista
                //.toList(); //não consigo adicionar nenhum item dentro dessa lista

        System.out.println("\n Top 10 Episodios:");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
               // .peek(e -> System.out.println("Primeiro Filtro " + e))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed()) //ordenar pela avaliação e do maior para o menor
                //.peek(e -> System.out.println("Ordenação " + e))
                .limit(10) // pegar somente os 5 primeiros
                //.peek(e -> System.out.println("Limite " + e))
                .map(e -> e.titulo().toUpperCase())
                //.peek(e -> System.out.println("Mapeamento " + e))
                .forEach(System.out::println);

        List<Episodio> episodios = temporadaList.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toUnmodifiableList());

        episodios.forEach(System.out::println);

//        System.out.println("A partir de que ano você deseja ver os episodios ?");
//        var ano = leitura.nextInt();
//        leitura.nextLine();
//
//        LocalDate dataBusca = LocalDate.of(ano, 1 , 1);
//        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        episodios.stream()
//                .filter(e -> e.getDataLancamento() != null &&  e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e -> System.out.println(
//                        "Temporada: " + e.getTemporada() + " " +
//                                "Episodio: " + e.getTitulo() + " " +
//                                "Data de Lançamento: " + e.getDataLancamento().format(formatador)
//                ));

//        System.out.println("\nDigite o trecho do titulo: ");
//        var trechoTitulo = leitura.nextLine();
//        Optional<Episodio> episodioEncontrado = episodios.stream()
//                .filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
//                .findFirst();
//
//        if(episodioEncontrado.isPresent()){
//            System.out.println("Episodio encontrado:");
//            System.out.println("Temporada: " + episodioEncontrado.get().getTemporada());
//        }else {
//            System.out.println("Episodio não encontrado");
//        }

        Map<Integer, Double> avaliacoes = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getAvaliacao)));

        System.out.println(avaliacoes);

//        DoubleSummaryStatistics::: já vem a soma de todas as avaliações, a menor e maior avaliação, a media e a quantidade de avaliações contadas

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));

        System.out.println("\nMedia: " + est.getAverage());
        System.out.println("\nNota Minima: " + est.getMin());
        System.out.println("\nNota Maxima: " + est.getMax());
        System.out.println("\nQuantidade: " + est.getCount());
    }
}
