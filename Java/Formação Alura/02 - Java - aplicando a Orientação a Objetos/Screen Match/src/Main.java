import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculo.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;

public class Main {
    public static void main(String[] args) {
        Filme filme = new Filme();
        filme.setNome("O Poderoso Chefão");
        filme.setAnoDeLancamento(1972);
        filme.setDuracaoEmMinutos(180);

        filme.exibeFichaTecnica();

        filme.avalia(8);
        filme.avalia(5);
        filme.avalia(10);

        System.out.println(filme.getSomaDasAvaliacoes());
        System.out.println(filme.getTotalDeAvaliacoes());
        System.out.println(filme.retornaMedia());

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
        lost.setNumTemporadas(10);
        lost.setEpisodiosPorTemporada(13);
        lost.setMinutosPorEpisodio(50);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        System.out.println(filme.getClassificacao());
        filtro.filtra(filme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);

    }
}