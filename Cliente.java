public class Cliente {

    private String nome;
    private String cpf;
    private int idade;

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public int getIdade(){
        return idade;
    }

    public String toString(){
        return String.format("NOME: %s\nCPF: %s\nIDADE: %d", this.nome, this.cpf, this.idade);
    }
   
}
