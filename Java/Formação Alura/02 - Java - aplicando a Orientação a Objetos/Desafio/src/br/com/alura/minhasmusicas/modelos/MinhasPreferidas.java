package br.com.alura.minhasmusicas.modelos;

public class MinhasPreferidas {

    public void inclui(Audio audio){
        if (audio.getClassificacao() >= 8){
            System.out.println(audio.getTitulo() + " é preferido");
        } else {
            System.out.println(audio.getTitulo() + " também é um que estão curtindo");
        }
    }
}
