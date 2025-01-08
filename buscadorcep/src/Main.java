import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String abertura;
        String cep = "";
        List<String> lista = new ArrayList<>();


        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()  // vem formatado em json certinho
                .create();

        abertura = """
                **********************************
                BUSCADOR DE CEP
                **********************************
                """;
        System.out.println(abertura);

        while (!cep.equalsIgnoreCase("sair")){
            System.out.println("Digite o cep desejado ou 'sair' para finalizar a busca");
            cep = leitura.nextLine();
            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            if(cep.equalsIgnoreCase("sair")){
                System.out.println("Sessão encerrada com sucesso.");
                break;
            }

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                lista.add(json);
                System.out.println("CEP consultado com sucesso.");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        //grava o arquivo
        FileWriter escrita = new FileWriter("resultadobusca.json");
        escrita.write(String.valueOf(lista));
        escrita.close();
    }
}