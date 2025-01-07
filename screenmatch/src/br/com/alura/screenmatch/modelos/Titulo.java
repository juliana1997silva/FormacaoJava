package br.com.alura.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {

    @SerializedName("Title")
    private String nome;

    @SerializedName("Year")
    private int anoLancamento;

    //@SerializedName("Runtime")
    private int duracaoMinutos;

    private double somaAvaliacao;
    private int totalAvaliacao;
    private boolean incluidoPlano;

    //contrutor
    public Titulo(String nome, int anoLancamento) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
    }

    public Titulo(TituloOmdb titulo) {
    this.nome = titulo.title();
    this.anoLancamento = Integer.valueOf(titulo.year().substring(0,4));
    this.duracaoMinutos = Integer.valueOf(titulo.runtime().substring(0,2));
    }

    public int getTotalAvaliacao(){
        return totalAvaliacao;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public boolean isIncluidoPlano() {
        return incluidoPlano;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIncluidoPlano(boolean incluidoPlano) {
        this.incluidoPlano = incluidoPlano;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome: " + nome);
        System.out.println("Ano de Lançamento: " + anoLancamento);
        System.out.println("Duração Minutos: " + duracaoMinutos);
    }

    public void avalia(double nota){
        somaAvaliacao += nota;
        totalAvaliacao++;
    }

    public double obterMedia(){
        return somaAvaliacao / totalAvaliacao;
    }

    //ordenar a lista por um tipo de uma classe que nos mesmo criamos
    @Override
    public int compareTo(Titulo t) {
        return this.getNome().compareTo(t.getNome());
    }


    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", anoLancamento=" + anoLancamento;
    }
}
