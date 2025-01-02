package br.com.alura.screenmatch.principal;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args){
        Filme filme1 = new Filme("O poderoso chefão", 1972);
        Filme filme2 = new Filme("Avatar", 2023);
        var filme3 = new Filme("Dogville", 2003);
        Serie serie1 = new Serie("Lost", 2000);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme1);
        lista.add(filme2);
        lista.add(filme3);

        lista.add(serie1);

        for (Titulo item : lista){
            System.out.println(item);

            if (item instanceof Filme filme){
                System.out.println("Classficação: " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Felipe");
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");

        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenacao: " + buscaPorArtista);

        Collections.sort(lista);
        System.out.println("Lista de títulos ordenados: ");
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);

    }
}
