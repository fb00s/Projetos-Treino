import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limite = teclado.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0){
            System.out.println("Digite a descrição da compra: ");
            String descricao = teclado.next();

            System.out.println("Digite o valor da compra: ");
            double valor = teclado.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada){
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = teclado.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }

        System.out.println("******************************");
        System.out.println("Compras realizadas:\n");

        for (Compra c : cartao.getCompras()){
            System.out.println(c.getDescricao() + " - " + c.getValor());
        }

        System.out.println("\n**********************");

        System.out.println("\nSaldo do cartão: R$ " + cartao.getSaldo());

    }
}