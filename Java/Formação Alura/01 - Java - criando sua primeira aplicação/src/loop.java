import java.util.Scanner;

public class loop {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        double mediaAvaliacao = 0;
        double nota = 0;

        for(int i = 0; i < 3; i++){
            System.out.println("Diga a sua avaliação para o filme: ");
            nota = teclado.nextDouble();
            mediaAvaliacao+= nota;
        }

        System.out.println("Média de avaliações " + mediaAvaliacao / 3);


    }
}
