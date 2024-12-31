import java.util.Scanner;

public class Leitura {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite um filme: ");
        String filme = teclado.nextLine();
        System.out.println(filme);
        System.out.println("Qual o ano de lançamento? ");
        int anoDeLancamento = teclado.nextInt();
        System.out.println("Digite a sua avaliação para o filme?");
        double avaliacao = teclado.nextDouble();
    }
}
