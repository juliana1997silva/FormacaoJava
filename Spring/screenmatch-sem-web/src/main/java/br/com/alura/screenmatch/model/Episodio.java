package br.com.alura.screenmatch.model;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Episodio {
    private Integer temporada;
    private String titulo;
    private Integer numero;
    private Double avaliacao;
    private LocalDate dataLancamento;

    public Episodio(Integer numeroTemporada, DadosEpisodio episodio) {
        this.temporada = numeroTemporada;
        this.titulo = episodio.titulo();

        try{
            this.avaliacao = Double.valueOf(episodio.avaliacao());
            this.dataLancamento = LocalDate.parse(episodio.dataLancamento());
        } catch (NumberFormatException ex ) {
            this.avaliacao = 0.0;
        } catch (DateTimeException dateTimeException){
            this.dataLancamento = null;
        }

        this.numero = episodio.numero();
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return
                "temporada= " + temporada +
                ", titulo= '" + titulo + '\'' +
                ", numero= " + numero +
                ", avaliacao= " + avaliacao +
                ", dataLancamento= " + dataLancamento;
    }
}
