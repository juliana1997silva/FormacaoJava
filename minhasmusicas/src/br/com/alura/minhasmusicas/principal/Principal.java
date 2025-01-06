package br.com.alura.minhasmusicas.principal;

import br.com.alura.minhasmusicas.modelos.MinhasPreferidas;
import br.com.alura.minhasmusicas.modelos.Musica;
import br.com.alura.minhasmusicas.modelos.Podcast;

public class Principal {
    public static void main(String[] args) {
        Musica musica1 = new Musica();
        musica1.setTitulo("Bondade de Deus");
        musica1.setCantor("Isaias Saad");

        for (int i = 0; i < 1000; i++) {
            musica1.reproduzir();
        }

        for (int i = 0; i < 50; i++) {
            musica1.curtir();
        }

        Podcast podcast1 = new Podcast();
        podcast1.setTitulo("BolhaDev");
        podcast1.setApresentador("Marcus Mendes");

        for (int i = 0; i < 2000; i++) {
            podcast1.reproduzir();
        }

        for (int i = 0; i < 1000; i++) {
            podcast1.curtir();
        }
        MinhasPreferidas preferidas = new MinhasPreferidas();
        preferidas.inclui(musica1);
        preferidas.inclui(podcast1);
    }
}