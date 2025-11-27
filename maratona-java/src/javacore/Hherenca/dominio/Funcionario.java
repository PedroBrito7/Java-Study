package javacore.Hherenca.dominio;

public class Funcionario extends Pessoa {
// o funcionario se estende de pessoa
    private double salario;
    static{
        System.out.println("inside block static");
    }
    {
        System.out.println("inside  block de inicializacao de Funcionario 1" );
    }
    {
        System.out.println("dentro do bloco inicializacao de FUncinario 2 ");
    }

public Funcionario(String nome){
    super(nome);
    System.out.println(" dentro do construtor de funcionario");
    }
    public void imprime(){
        super.imprime();
        System.out.println(this.salario);
    }
    public void relatorioPagamento(){
        System.out.println(" Eu " + this.getNome() + " recebi o salario de" + this.salario);
    }
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
