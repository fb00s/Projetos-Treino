import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner teclado = new Scanner(System.in);
        File arqCsv = new File("src/usuario_e_senha.csv");
        String opcao;
        String nomeUsuario;
        String senhaUsuario;
        boolean usuarioJaCadastrado;

        if (!arqCsv.exists()){
            System.out.println("Arquivo não encontrado. Criando novo arquivo...");
            try{
                arqCsv.createNewFile();
            } catch(IOException e){
                System.out.println("Erro ao criar arquivo: " + e.getMessage());
                return;
            }
        }

        do {
            System.out.println("O que você deseja fazer? Digite 'c' para cadastrar um usuário,\n" +
                    "digite 'l' para fazer login, e digite 's' para sair: ");
            opcao = teclado.nextLine();
            switch (opcao){
                case "c":
                    do{
                        System.out.println("Crie um nome para o seu usuário: ");
                        nomeUsuario = teclado.nextLine();
                        usuarioJaCadastrado = nomeJaCadastrado(nomeUsuario, arqCsv);
                        if (usuarioJaCadastrado){
                            System.out.println("Esse nome de usuário já existe! Tente novamente\n");
                        }
                    } while(usuarioJaCadastrado);
                    System.out.println("Crie uma senha para o seu usuario: ");
                    senhaUsuario = teclado.nextLine();
                    registrarUsuario(nomeUsuario, senhaUsuario);
                    break;
                case "l":
                    boolean loginComSucesso = fazerLogin(arqCsv, teclado);

                    if (loginComSucesso) System.out.println("Login feito com sucesso!");
                    break;
                case "s":
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (!opcao.equals("s"));

        teclado.close();
    }

    public static boolean registrarUsuario(String nomeUsuario, String senhaUsuario){
        try (FileWriter escritor = new FileWriter("src/usuario_e_senha.csv", true)){
            escritor.append(nomeUsuario).append(",").append(senhaUsuario).append("\n");
            return true;
        } catch (IOException e){
            System.err.println("Erro ao cadastrar usuário");
            return false;
        }
    }

    public static boolean nomeJaCadastrado(String nomeUsuario, File arquivoCsv){
        try{
            Scanner leitorArq = new Scanner(arquivoCsv);
            String nomeCadastrado;
            while (leitorArq.hasNextLine()){
                nomeCadastrado = leitorArq.nextLine().split(",")[0];
                if (nomeUsuario.equals(nomeCadastrado)){
                    return true;
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        }
        return false;
    }

    public static boolean fazerLogin(File arquivoCsv, Scanner teclado){
        boolean usuarioEncontrado = false;
        try{
            Scanner leitorArqSenha = new Scanner(arquivoCsv);
            System.out.println("Fazendo login...");
            String[] usuarioCadastrado;
            String nomeCadastrado;
            String senhaCadastrada = "x";
            String senhaInput = "y";
            String nomeInput;
            do{
                Scanner leitorArqNome = new Scanner(arquivoCsv);
                System.out.println("Digite o seu nome de usuário: ");
                nomeInput = teclado.nextLine();
                while (leitorArqNome.hasNextLine()) {
                    usuarioCadastrado = leitorArqNome.nextLine().split(",");
                    nomeCadastrado = usuarioCadastrado[0];
                    senhaCadastrada = usuarioCadastrado[1];
                    if (nomeInput.equals(nomeCadastrado)){
                        usuarioEncontrado = true;
                        break;
                    }
                }
                if (!usuarioEncontrado) System.out.println("O nome de usuário inserido está incoreto");
            }while(!usuarioEncontrado);

            do{
                System.out.println("Digite a sua senha: ");
                senhaInput = teclado.nextLine();

                if(!senhaInput.equals(senhaCadastrada)) System.out.println("Senha incorreta! Tente novamente");
            }while(!senhaInput.equals(senhaCadastrada));
        } catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
            return false;
        }
        return true;
    }
}