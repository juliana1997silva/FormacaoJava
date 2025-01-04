public class Condicional {
    public static void main(String[] args) {
        int anoLancamento = 1990;
        boolean incluidoNoPlano = false;
        double notaDoFilme = 9.8;
        String tipoPlano = "plus";

        if(anoLancamento >= 2022){
            System.out.println("Lançamento que os cliente estão curtindo !");
        }else {
            System.out.println("Filme retrô que vale a pena assistir !");
        }

        // Para string não se usa == para verificar o valor da variavel, se usa equals(valorQueDesejo)
        if(incluidoNoPlano || tipoPlano .equals("plus")){
            System.out.println("Filme liberado !");
        }else {
            System.out.println("Deve pagar a locação");
        }

        int dia = 5;
        String nomeDia;

        switch (dia) {
            case 1:
                nomeDia = "domingo";
                break;
            case 2:
                nomeDia = "segunda-feira";
                break;
            case 3:
                nomeDia = "terça-feira";
                break;
            case 4:
                nomeDia = "quarta-feira";
                break;
            case 5:
                nomeDia = "quinta-feira";
                break;
            case 6:
                nomeDia = "sexta-feira";
                break;
            case 7:
                nomeDia = "sábado";
                break;
            default:
                nomeDia = "Dia inválido";
                break;
        }

        System.out.println("O dia " + dia + " é " + nomeDia);
    }
}
