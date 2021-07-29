import java.util.ArrayList;
import java.util.Scanner;

public class Cadastramento {
    public static void main(String[] args) {
        ArrayList<Viagem> listaDeViagens = new ArrayList<>();
        int opcao = 0, idade;
        String destino, nome, cpf;
        double precoDaPassagem;
        Scanner entrada = new Scanner(System.in);

        while(opcao != 6){

            System.out.print("\n(1)Cadastrar Viagem\n(2)Remover Viagem\n(3)Cadastrar Cliente");
            System.out.print("\n(4)Remover Cliente\n(5)Listar Clientes em uma viagem\n(6)Sair\n");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch(opcao){
                case 1:
                    Viagem viagem = new Viagem();

                    System.out.print("\nDigite o Destino: ");
                    destino = entrada.nextLine(); 

                    System.out.print("\nDigite o preco da passagem: ");
                    precoDaPassagem = entrada.nextDouble();
                    entrada.nextLine();

                    viagem.setDestino(destino);
                    viagem.setPrecoDaPassagem(precoDaPassagem);

                    listaDeViagens.add(viagem);
                    break;

                case 2:
                    boolean removido = false;
                    System.out.print("\nDigite o Destino: ");
                    destino = entrada.nextLine();
                    removido = removerViagem(listaDeViagens, destino);

                    if(removido){
                        System.out.println("Viagem Removida!");
                    }

                    else{
                        System.out.println("Viagem nao encontrada!");
                    }
                    break;

                case 3:
                    boolean estaCadastrado = false;
                    Cliente cliente = new Cliente();

                    System.out.print("\nDigite o nome do cliente: ");
                    nome = entrada.nextLine();

                    System.out.print("\nDigite o CPF: ");
                    cpf = entrada.nextLine();

                    System.out.print("\nDigite a idade: ");
                    idade = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("\nDigite o destino: ");
                    destino = entrada.nextLine();

                    cliente.setNome(nome);
                    cliente.setCpf(cpf);
                    cliente.setIdade(idade);

                    estaCadastrado = Viagem.cadastrarCliente(listaDeViagens, cliente, destino);

                    if(estaCadastrado){
                        System.out.println("Cliente cadastrado!");
                    }
                    else{
                        System.out.println("Viagem nao encontrada");
                    }
                    break;

                case 4:
                    boolean clienteRemovido;
                    System.out.print("\nDigite o nome: ");
                    nome = entrada.nextLine();

                    System.out.print("\nDigite o destino da viagem: ");
                    destino = entrada.nextLine();

                    clienteRemovido = Viagem.removerCliente(listaDeViagens, nome, destino);

                    if(clienteRemovido){
                        System.out.println("Cliente removido!");
                    }
                    else{
                        System.out.println("Cliente nao encontrado!");
                    }
                    break;
                case 5:
                    System.out.print("\nDigite o destino: ");
                    destino = entrada.nextLine();

                    for(Viagem viagemAtual: listaDeViagens){

                        if(viagemAtual.getDestino().equalsIgnoreCase(destino)){
                            viagemAtual.listarClientes();
                        }
                    }
                    break;
                case 6:
                    continue;
                default:
                    System.out.println("\nVoce digitou uma opcao invalida\nTente Novamente!");
            }

        }

        entrada.close();
    }

    //metodos auxiliares da classe principal
    static boolean removerViagem(ArrayList<Viagem> listaDeViagens, String destino){
        boolean viagemRemovida = false;

        for(Viagem viagem: listaDeViagens){

            if(viagem.getDestino().equalsIgnoreCase(destino)){
                viagemRemovida = listaDeViagens.remove(viagem);
            }
        }
        return viagemRemovida;
    }  
}
