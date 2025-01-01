package br.com.alura.screenmatch.modelos;

public class Serie extends Titulo{
    private int numTemporadas;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;

    public int getNumTemporadas(){
        return numTemporadas;
    }

    public void setNumTemporadas(int numTemporadas){
        this.numTemporadas = numTemporadas;
    }

    public boolean getAtiva(){
        return ativa;
    }

    public void setAtiva(boolean ativa){
        this.ativa = ativa;
    }

    public int getEpisodiosPorTemporada(){
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada){
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio(){
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio){
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override
    public int getDuracaoEmMinutos(){
        return numTemporadas * episodiosPorTemporada * minutosPorEpisodio;
    }
}
