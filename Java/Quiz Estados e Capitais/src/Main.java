import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        String continuarJogando = " ";

        do {
            try {
                loopJogo(teclado);
                System.out.println("Continuar jogando? Digite 's' para sim");
                continuarJogando = teclado.nextLine();

            } catch (FileNotFoundException e){
                System.out.println("O arquivo csv não foi encontrado");
            }
        } while (continuarJogando.equals("s"));

        System.out.println("Encerrando jogo");
    }

    public static void loopJogo(Scanner teclado) throws FileNotFoundException{
        ArrayList<String[]> perguntasERespostas = new ArrayList<>();
        File arquivoCsv = new File("C:/Users/Felipe Boos/Documents/Projetos/Java/Java Course Bro Code/src/estados_e_capitais.csv");
        Scanner leitorArq = new Scanner(arquivoCsv);
        Random aleatorio = new Random();

        while(leitorArq.hasNextLine()){
            String linha = leitorArq.nextLine();
            String[] itens = linha.split(",");

            perguntasERespostas.add(new String[]{itens[0], itens[1]});
            perguntasERespostas.add(new String[]{itens[1], itens[0]});
        }
        leitorArq.close();

        String respUsuario;
        int numAleatorio;
        int numAcertos = 0;

        while (!perguntasERespostas.isEmpty()){
            numAleatorio = aleatorio.nextInt(perguntasERespostas.size());
            String[] itemAleatorio = perguntasERespostas.get(numAleatorio);
            String pergunta = itemAleatorio[0];
            String respCorreta = itemAleatorio[1];

            System.out.println("Acertados: " + numAcertos + ", Restantes: " + perguntasERespostas.size() + "\n" + pergunta + ": ");
            respUsuario = teclado.nextLine();

            if (respUsuario.equals(respCorreta)){
                numAcertos++;
                perguntasERespostas.remove(itemAleatorio);
                if (!perguntasERespostas.isEmpty()) System.out.println("Você acertou");
            } else {
                System.out.println("Você errou");
            }
        }
        System.out.println("Você acertou todos!");
    }
}
