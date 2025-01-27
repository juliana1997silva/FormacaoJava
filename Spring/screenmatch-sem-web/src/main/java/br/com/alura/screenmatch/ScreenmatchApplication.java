package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodios;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var api = new ConsumoApi();
		var json = api.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=58e18a8c");
		System.out.println(json);

		ConverteDados conversor = new ConverteDados(); // criação do conversor
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class); // converte o json na classe que estou enviando
		json = api.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=1&apikey=58e18a8c");
		DadosEpisodios dadosEpisodios = conversor.obterDados(json, DadosEpisodios.class);
		System.out.println(dados);
		System.out.println(dadosEpisodios);



	}
}
