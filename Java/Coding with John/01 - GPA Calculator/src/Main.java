import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        /*
        Calcular GPA:
        1) Converter notas para escala 4.0:
            Nota | Gpa Equivalente
            ----------------------
            A (90-100%) | 4.0
            B (80-89%)  | 3.0
            C (70-79%)  | 2.0
            D (60-69%)  | 1.0
            F (<60%)    | 0.0

        2) Multiplicar pelo peso dos Créditos:
            Nos EUA, as disciplinas têm pesos diferentes, então devemos multiplicar cada nota
            pelo peso de sua respectiva disciplina, somando esses valores para uma disciplina
            nos dá o total para aquela disciplina, somando os totais de todas as
            disciplinas nos dá o Total Ponderado.

        3) Para calcular o GPA final, dividimos o total ponderado pelo total de créditos:
        GPA = Total Ponderado / Total de Créditos
         */
        Scanner scannerInput = new Scanner(System.in);
        DecimalFormat dFormat = new DecimalFormat("0.00");
        int totalPontos = 0;
        int totalCreditos = 0;

        boolean maisClasses = false;

        do {
            int creditos = 0;
            boolean numCreditosValido = false;
            do {
                System.out.println("Insira o número de créditos: ");
                String strCreditos = scannerInput.nextLine();
                try {
                    creditos = Integer.parseInt(strCreditos);
                    numCreditosValido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Insira um número válido para o número de créditos:");
                }

            } while (!numCreditosValido);

            String nota = "";
            boolean notaValida = true;
            int valorMedia = 0;

            do {
                System.out.println("Insira a nota: ");
                nota = scannerInput.nextLine().toUpperCase();
                notaValida = true;
                if (nota.equalsIgnoreCase("A")) {
                    valorMedia = 4;
                } else if (nota.equals("B")) {
                    valorMedia = 3;
                } else if (nota.equals("C")) {
                    valorMedia = 2;
                } else if (nota.equals("D")) {
                    valorMedia = 1;
                } else if (nota.equals("F")) {
                    valorMedia = 0;
                } else {
                    System.out.println("Valor inválido para nota");
                    notaValida = false;
                }
            } while (!notaValida);

            int pontos = valorMedia * creditos;
            totalPontos += pontos;
            totalCreditos += creditos;

            System.out.println("Você gostaria de adicionar mais uma classe? Digite 's' para sim");
            maisClasses = scannerInput.nextLine().equalsIgnoreCase("S");
        } while (maisClasses);

        double gpa = Double.valueOf(totalPontos) / Double.valueOf(totalCreditos);

        System.out.println("Créditos: " + totalCreditos);
        System.out.println("Pontos: " + totalPontos);
        System.out.println("GPA: " + dFormat.format(gpa));

        scannerInput.close();


    }
}