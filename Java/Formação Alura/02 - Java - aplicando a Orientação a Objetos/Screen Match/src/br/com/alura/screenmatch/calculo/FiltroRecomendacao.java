package br.com.alura.screenmatch.calculo;

public class FiltroRecomendacao {
    private String recomendacao;

    public void filtra(Classificavel classificavel){
        if (classificavel.getClassificacao() >= 4){
            System.out.println("Está entre os preferidos");
        } else if (classificavel.getClassificacao() >= 2){
            System.out.println("Bem avaliado");
        } else {
            System.out.println("Assistir mais tarde");
        }
    }
}
