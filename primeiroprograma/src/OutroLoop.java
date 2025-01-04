import java.util.Scanner;

public class OutroLoop {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        double media = 0;
        double nota = 0;
        int totalNotas = 0;

        while (nota != -1) {
            System.out.println("Diga sua avaliação para o filme ou -1 para encerrar ");
            nota = leitura.nextDouble();
            if(nota != -1) {
                media += nota ;
                totalNotas++;
            }
        }
        System.out.println("Media de avaliações " + media / totalNotas);
    }
}
