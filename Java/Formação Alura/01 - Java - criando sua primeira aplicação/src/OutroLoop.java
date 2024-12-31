import java.util.Scanner;

public class OutroLoop {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        double mediaAvaliacao = 0;
        double nota = 0;
        int qtdNotas = 0;

        while (nota != -1){
            System.out.println("Diga sua avaliação para o filme ou -1 para encerrar");
            nota = teclado.nextDouble();

            if (nota != -1){
                mediaAvaliacao+= nota;
                qtdNotas++;
            }
        }

        System.out.println("Média de avaliações: " + mediaAvaliacao / qtdNotas);
    }
}
