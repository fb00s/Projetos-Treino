import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scannerInput = new Scanner(System.in);
        Random aleatorio = new Random();
        char[][] tabuleiro = {{' ',' ',' '}, {' ',' ',' '}, {' ',' ',' '}};

        boolean deuVelha = false;
        boolean alguemVenceu = false;

        do {

        } while (!deuVelha && !alguemVenceu);



        scannerInput.close();

    }

    private static char verificarVencedor(char[][] tabuleiro){
        char jogada = tabuleiro[1][1];

        if (jogada != ' ') {
            if (tabuleiro[0][1] == jogada && tabuleiro[2][1] == jogada){
                return jogada; // Verifica a primeira coluna
            }

            if (tabuleiro[0][2] == jogada && tabuleiro[2][0] == jogada){
                return jogada; // Verifica a diagonal /
            }

            if (tabuleiro[1][2] == jogada && tabuleiro[1][0] == jogada){
                return jogada; // Verifica a linha do meio
            }

            if (tabuleiro[0][0] == jogada && tabuleiro[2][2] == jogada){
                return jogada; // Verifica a diagonal \
            }
        }

        jogada = tabuleiro[0][0];

        if (jogada != ' ') {
            if (tabuleiro[0][1] == jogada && tabuleiro[0][2] == jogada){
                return jogada; // Verifica a primeira linha
            }

            if (tabuleiro[1][0] == jogada && tabuleiro[2][0] == jogada){
                return jogada; // Verifica a primeira coluna;
            }

        }

        jogada = tabuleiro[2][2];

        if (jogada != ' ') {
            if (tabuleiro[1][2] == jogada && tabuleiro[0][2] == jogada){
                return jogada; // Verifica a última coluna;
            }
            if (tabuleiro[2][1] == jogada && tabuleiro[2][0] == jogada){
                return jogada; // Verifica a última linha
            }
        }


        return ' ';
    }

    private static boolean casaJaJogada(char[][] tabuleiro, int jogada){
        int linha = 0;

        if (jogada > 6){
            linha = 2;

        } else if (jogada > 3){
            linha = 1;
        } else {
            linha = 0;
        }

        int coluna = jogada - (linha * 3) - 1;


        if (tabuleiro[linha][coluna] != ' ') {
            return true;
        }

        return false;
    }

    private static boolean deuVelha(char[][] tabuleiro){
        for (char[] linha : tabuleiro){
            for (char casa : linha){
                if (casa == ' ') return false;

            }
        }
        System.out.println("Deu velha!");
        return true;
    }

    private static void vezDoUsuario(char[][] tabuleiro, Scanner scannerInput){
        boolean jaJogada = true;
        int jogadaUsuario = 0;

        do {
            System.out.println("Onde você quer jogar? (1-9)");
            jogadaUsuario = scannerInput.nextInt();

            jaJogada = casaJaJogada(tabuleiro, jogadaUsuario);
            if (jaJogada) System.out.println("Essa casa já foi jogada");
        } while (jaJogada);

        fazerJogada(tabuleiro, jogadaUsuario, 'X');
    }

    private static void vezDoComputador(char[][] tabuleiro, Random aleatorio){
        boolean jaJogada = true;
        int jogadaComputador = 0;

        do {
            jogadaComputador = aleatorio.nextInt(9) + 1;
            jaJogada = casaJaJogada(tabuleiro, jogadaComputador);
        } while (jaJogada);

        fazerJogada(tabuleiro, jogadaComputador, 'O');
    }


    private static void fazerJogada(char[][] tabuleiro, int jogada, char caractere) {

        switch (jogada){
            case 1:
                tabuleiro[0][0] = caractere;
                break;
            case 2:
                tabuleiro[0][1] = caractere;
                break;
            case 3:
                tabuleiro[0][2] = caractere;
                break;
            case 4:
                tabuleiro[1][0] = caractere;
                break;
            case 5:
                tabuleiro[1][1] = caractere;
                break;
            case 6:
                tabuleiro[1][2] = caractere;
                break;
            case 7:
                tabuleiro[2][0] = caractere;
                break;
            case 8:
                tabuleiro[2][1] = caractere;
                break;
            case 9:
                tabuleiro[2][2] = caractere;
                break;
            default:
                System.out.println("Erro: Casa inválida");
        }
    }

    private static void desenhaTabuleiro(char[][] tabuleiro){
        System.out.println(tabuleiro[0][0] + "|" + tabuleiro[0][1] + "|" + tabuleiro[0][2]);
        System.out.println("-+-+-");
        System.out.println(tabuleiro[1][0] + "|" + tabuleiro[1][1] + "|" + tabuleiro[1][2]);
        System.out.println("-+-+-");
        System.out.println(tabuleiro[2][0] + "|" + tabuleiro[2][1] + "|" + tabuleiro[2][2]);
    }
}