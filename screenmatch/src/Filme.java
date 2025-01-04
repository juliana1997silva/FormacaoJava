public class Filme {
    String nome;
    int anoLancamento;
    boolean incluidoPlano;
    double somaAvaliacao;
    int totalAvaliacao;
    int duracaoMinutos;

    void exibeFichaTecnica(){
        System.out.println("Nome " + nome);
        System.out.println("Ano de Lançamento " + anoLancamento);
    }

    void avalia(double nota){
        somaAvaliacao += nota;
        totalAvaliacao++;
    }

    double obterMedia(){
        return somaAvaliacao / totalAvaliacao;
    }
}
