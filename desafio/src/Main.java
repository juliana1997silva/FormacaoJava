import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        // Dados do cliente
        String nome = "Juliana Silva de Jesus";
        String tipoConta = "Corrente";
        double saldo = 1000; // Saldo inicial armazenado na variável
        int opcoes = 0;
        double valor = 0;

        // Exibição formatada
        System.out.println("*********************************************************");
        System.out.println("               Dados iniciais do cliente:");
        System.out.printf("               Nome:                %s%n", nome);
        System.out.printf("               Tipo de conta:       %s%n", tipoConta);
        System.out.printf("               Saldo inicial:       R$ %.2f%n", saldo);
        System.out.println("*********************************************************");

        String menu = """
                
                **** Digite sua opção *****
                
                1 - Consultar Saldo
                2 - Receber valor
                3 - Transferir valor
                4 - Sair
                ***************************
                """;

       while (opcoes != 4){
           System.out.println(menu);
           opcoes = leitura.nextInt();

           switch (opcoes){
               case 1:
                   System.out.println("Seu saldo atual é de " + saldo);
                   break;
               case 2:
                   System.out.println("Digite o valor a receber");
                   valor = leitura.nextDouble();
                   saldo += valor;
                   System.out.println("Seu saldo atual é de " + saldo);
                   break;
               case 3:
                   System.out.println("Digite o valor a ser transferido");
                   valor = leitura.nextDouble();
                   if(valor > saldo){
                       System.out.println("Seu saldo é de " + saldo);
                       System.out.println("Saldo insuficiente para essa transação");
                       break;
                   }else {
                       saldo -= valor;
                       System.out.println("Seu saldo atual é de " + saldo);
                       break;
                   }

               case 4:
                   System.out.println("Sessão encerrada");
                   break;
               default:
                   System.out.println("Opção inválida");
                   break;
           }
       }

    }
}