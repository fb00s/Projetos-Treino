import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        /*
        Calcular IMC (Índice de Massa Corporal)
        IMC = peso (kg) / altura (m)²
         */

        Scanner teclado = new Scanner(System.in);
        DecimalFormat decFormat = new DecimalFormat("0.00");

        double peso = 0;
        boolean pesoValido = false;

        do {
            try {
                System.out.println("Digite o seu peso em quilos: ");
                peso = teclado.nextDouble();
                if (peso <= 0){
                    System.out.println("O peso deve ser maior que zero");
                } else {
                    pesoValido = true;
                }
            } catch (InputMismatchException e){
                System.out.println("Valor inválido para o peso");
            } finally {
                teclado.nextLine();
            }
        } while(!pesoValido);

        double altura = 0;
        boolean alturaValida = false;

        do {
            try {
                System.out.println("Digite a sua altura em metros: ");
                altura = teclado.nextDouble();

                if (altura <= 0){
                    System.out.println("A altura deve ser maior que zero");
                } else {
                    alturaValida = true;
                }
            } catch (InputMismatchException e){
                System.out.println("Valor inválido para a altura");
            } finally {
                teclado.nextLine();
            }
        } while (!alturaValida);

        teclado.close();

        double imc = peso / (altura * altura);

        System.out.println("IMC: " + decFormat.format(imc));

    }
}