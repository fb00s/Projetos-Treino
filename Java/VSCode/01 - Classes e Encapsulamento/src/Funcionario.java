public final class Funcionario {
    private String nome;
    private double salario;
    private int idade;

    public Funcionario(){

    }

    public Funcionario(String nome, double salario, int idade){
        setNome(nome);
        setSalario(salario);
        setIdade(idade);
    }

    public void setNome(String nome){
        if (nome == null){
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setSalario(double salario){
        if (salario <= 0){
            throw new IllegalArgumentException("Salário inválido");
        }
        this.salario = salario;
    }

    public double getSalario(){
        return salario;
    }

    public void setIdade(int idade){
        if (idade <= 0){
            throw new IllegalArgumentException("Idade inválida");
        }
        this.idade = idade;
    }

    public int getIdade(){
        return idade;
    }
}
