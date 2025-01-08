package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excessao.ErrorConversaoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> lista = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()  // vem formatado em json certinho
                .create();

        while (!busca.equalsIgnoreCase("sair")){

            System.out.println("Digite o filme que deseja buscar? ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }

        String url = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=58e18a8c";
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            System.out.println(json);



            TituloOmdb titulo = gson.fromJson(json, TituloOmdb.class);
            System.out.println(titulo);


            Titulo meutitulo =  new Titulo(titulo);
            meutitulo.exibeFichaTecnica();

            lista.add(meutitulo);
        } catch (NumberFormatException e) {
            System.out.println("Ocorreu um erro");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Algum erro no endereço de busca");
        } catch (Exception e){
            System.out.println("Não sei o que é");
        } catch (ErrorConversaoException e) {
            System.out.println(e.getMessage());
        }
        }

        System.out.println("Lista => " + lista);


        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(lista));
        escrita.close();

        System.out.println("Lista JSON => " + lista);


    }
}
