public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println("Filme: Quarto de Guerra");

        int anoLancamento = 2022;
        System.out.println("Ano de Lancamento " + anoLancamento);

        boolean incluidoNoPlano = true;
        double notaDoFilme = 9.8;

        String sinopse;
        sinopse = """
                JESUS É O SENHOR
                DEUS ESTA NO CONTROLE DE TUDO
                TODA HONRA E GLORIA A DEUS
                """;

        System.out.println(sinopse);

        double media = (9.8 + 8.2 + 6.8) / 3;
        System.out.println(media);

        int classificacao = (int) (media /2);
        System.out.println(classificacao);
    }
}