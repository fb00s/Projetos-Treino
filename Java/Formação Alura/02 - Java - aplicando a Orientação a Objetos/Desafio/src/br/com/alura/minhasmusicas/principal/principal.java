package br.com.alura.minhasmusicas.principal;
import br.com.alura.minhasmusicas.modelos.Musica;
import br.com.alura.minhasmusicas.modelos.Podcast;
import br.com.alura.minhasmusicas.modelos.MinhasPreferidas;

public class principal {
    public static void main(String[] args){
        Musica musica1 = new Musica();
        musica1.setTitulo("Forever");
        musica1.setCantor("Kiss");

        for (int i = 0; i < 1000; i++){
            musica1.reproduz();
        }

        for (int i = 0; i < 50; i++){
            musica1.curte();
        }

        Podcast podcast1 = new Podcast();
        podcast1.setTitulo("BolhaDev");
        podcast1.setApresentador("Marcus Mendes");

        for (int i = 0; i < 5000; i++){
            podcast1.reproduz();
        }

        for (int i = 0; i < 1000; i++){
            podcast1.curte();
        }

        MinhasPreferidas preferidas = new MinhasPreferidas();
        preferidas.inclui(podcast1);
        preferidas.inclui(musica1);
    }
}
