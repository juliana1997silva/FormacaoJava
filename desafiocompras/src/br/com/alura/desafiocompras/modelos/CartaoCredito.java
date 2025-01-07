package br.com.alura.desafiocompras.modelos;

import java.util.ArrayList;
import java.util.List;

public class CartaoCredito {
    private double limitCartao;
    private double saldo;
    private List<Compra> compras;

    public CartaoCredito(double limitCartao) {
        this.limitCartao = limitCartao;
        this.saldo = limitCartao;
        this.compras = new ArrayList<>();
    }

    public double getLimitCartao() {
        return limitCartao;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public boolean lancaCompra(Compra compra){
        if(this.saldo > compra.getValor()){
            this.saldo -= compra.getValor();
            this.compras.add(compra);
            return  true;
        }else {
            return false;
        }
    }
}
