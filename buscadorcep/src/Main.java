import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();
        GeradorArquivo geradorArquivo = new GeradorArquivo();

        try{
            System.out.println("Digite o cep desejado: ");
            var cep = leitura.nextLine();
            Endereco endereco = consultaCep.buscaEndereco(cep);
            geradorArquivo.gerarArquivo(endereco);
            System.out.println("CEP consultado com sucesso");

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Aplicação finalizada");
        }
    }
}