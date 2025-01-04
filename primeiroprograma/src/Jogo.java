import java.util.Random;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        int numeroSorteado = new Random().nextInt(100);
        int tentativas = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite o numero sorteado: ");
            tentativas = leitura.nextInt();

            if(tentativas == numeroSorteado){
                System.out.println("Parabéns você acertou.");
                break;
            } else if(tentativas < numeroSorteado){
                System.out.println("Chute menor que o numero sorteado.");
            }else {
                System.out.println("Chute maior que o numero sorteado.");
            }

        }


    }
}
