import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        //Para realizar a leitura dos dados que o usuario irá digitar
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o seu filme favorito");
        String filme = leitura.nextLine();

        System.out.println("Digite o ano de lançamento");
        int anoLancamento = leitura.nextInt();

        System.out.println("Diga sua avaliação para o filme ");
        double avaliacao = leitura.nextDouble();

        System.out.println(filme);
        System.out.println(anoLancamento);
        System.out.println(avaliacao);
    }
}
