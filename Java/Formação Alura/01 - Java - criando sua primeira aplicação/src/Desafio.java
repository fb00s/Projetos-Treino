import java.util.Scanner;

public class Desafio {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        String nomeCliente = "Felipe Boos";
        String tipoConta = "Corrente";
        double saldo = 2500.0;

        System.out.println("****************************");
        System.out.println("\nNome do cliente: " + nomeCliente);
        System.out.println("Tipo conta: " + tipoConta);
        System.out.println("Saldo atual: " + saldo);
        System.out.println("\n****************************");

        String menu = """
                ** Digite a sua opção **
                1 - Consultar saldo
                2 - Transferir valor
                3 - Receber valor
                4 - Sair
                
                """;

        int opcao = 0;

        while (opcao != 4){
            System.out.println(menu);
            opcao = teclado.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("O saldo atualizado é:  " + saldo);
                    break;
                case 2:
                    System.out.println("Qual o valor que deseja transferir? ");
                    double valor = teclado.nextDouble();
                    if (valor > saldo){
                        System.out.println("Não há saldo para fazer a transferência");
                    } else {
                        saldo -= valor;
                        System.out.println("Novo saldo: R$ " + saldo);
                    }
                    break;
                case 3:
                    System.out.println("Valor recebido: ");
                    double valorRecebido = teclado.nextDouble();
                    saldo += valorRecebido;
                    System.out.println("Novo saldo: R$ " + saldo);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }


    }


}
