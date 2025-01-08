package br.com.alura.screenmatch.excessao;

public class ErrorConversaoException extends Throwable {
    private String mensagem;

    public ErrorConversaoException(String s) {
       this.mensagem = s;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
