import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        /*
        Calcular BMI (IMC / Índice de Massa Corporal)
        BMI = peso (lb) / altura (in)² x 703
         */

        Scanner scannerInput = new Scanner(System.in);
        DecimalFormat dFormat = new DecimalFormat("0.00");


        boolean pesoValido = false;
        double peso = 0;
        do {
            try {
                System.out.println("Digite o seu peso em libras: ");
                peso = scannerInput.nextDouble();
                pesoValido = true;
            } catch(InputMismatchException e){
                System.out.println("Digite um valor válido para o peso");
                scannerInput.nextLine();
            }
        } while (!pesoValido);

        boolean alturaValida = false;
        double altura = 0;
        do {
            try {
                System.out.println("Digite a sua altura em polegadas: ");
                altura = scannerInput.nextDouble();
                alturaValida = true;
            } catch(InputMismatchException e){
                System.out.println("Digite um valor válido para altura");
                scannerInput.nextLine();
            }
        } while (!alturaValida);

        scannerInput.close();

        double bmi = peso / (Math.pow(altura, 2)) * 703;

        System.out.println("BMI: " + dFormat.format(bmi));
    }
}