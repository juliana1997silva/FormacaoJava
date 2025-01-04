public class Principal {
    public static void main(String[] args) {

        Filme meuFilme = new Filme();
        meuFilme.nome = "Quarto de Guerra";
        meuFilme.anoLancamento = 2015;

        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println(meuFilme.somaAvaliacao);
        System.out.println(meuFilme.totalAvaliacao);

        System.out.println(meuFilme.obterMedia());


    }
}
