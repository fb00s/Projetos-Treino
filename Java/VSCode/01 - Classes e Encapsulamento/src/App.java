/* O programa irá solicitar o nome, salário e idade de três funcionários e criar um objeto para cada, depois ele irá exibir
 * essas informações no console
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        Funcionario vetorFuncionarios[] = new Funcionario[3];

        for (int i = 0; i < vetorFuncionarios.length; i++){
            System.out.println("Digite o nome do funcionário: ");
            String nome = teclado.next();

            System.out.println("Digite o salário do funcionário " + nome + ": ");
            double salario = teclado.nextDouble();

            System.out.println("Digite a idade do funcionário " + nome + ": ");
            int idade = teclado.nextInt();

            Funcionario funcionario = new Funcionario(nome, salario, idade);

            System.out.println("----------------------------");

            vetorFuncionarios[i] = funcionario;
        }

        teclado.close();

        for (Funcionario funcionario : vetorFuncionarios){
            String nome = funcionario.getNome();
            double salario = funcionario.getSalario();
            int idade = funcionario.getIdade();
            System.out.println("Nome: " + nome + "\nSalário: " + salario + "\nIdade: " + idade);
            System.out.println("--------------------------------------------------");
        }
    }
}
