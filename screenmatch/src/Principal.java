import br.com.alura.screenmatch.modelos.Filme;

public class Principal {
    public static void main(String[] args) {

        Filme meuFilme = new Filme();
        meuFilme.setNome("Quarto de Guerra");
        meuFilme.setAnoLancamento(2015);

        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println("Total de Avaliações: " + meuFilme.getTotalAvaliacao());
        System.out.println(meuFilme.obterMedia());


    }
}
