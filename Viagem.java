import java.util.ArrayList;

public class Viagem {

    private String destino;
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private double precoDaPassagem;

    public void setDestino(String destino){
        this.destino = destino;
    }

    public void setPrecoDaPassagem(double precoDaPassagem){
        this.precoDaPassagem = precoDaPassagem;
    }

    public String getDestino(){
        return this.destino;
    }

    public double getPrecoDaPassagem(){
        return this.precoDaPassagem;
    }

    public void adicionarCliente(Cliente cliente){
        listaClientes.add(cliente);    
    }

    public boolean removerCliente(String nome){
        boolean clienteRemovido = false;

        for(Cliente cliente: listaClientes){

            if(nome.equalsIgnoreCase(cliente.getNome())){
                clienteRemovido = listaClientes.remove(cliente);
            }
        }
        return clienteRemovido;
    }

    public void listarClientes(){
        
        for(Cliente cliente: listaClientes){
            System.out.println(cliente);
        }
    }

    public static boolean cadastrarCliente(ArrayList<Viagem> listaDeViagens, Cliente cliente, String destino){
        boolean cadastrado = false;
        for(Viagem viagem: listaDeViagens){

            if(viagem.getDestino().equalsIgnoreCase(destino)){
                viagem.adicionarCliente(cliente);
                cadastrado = true;
            }
        }
        return cadastrado;
    }

    public static boolean removerCliente(ArrayList<Viagem> listaDeViagens, String nome, String destino){
        boolean clienteRemovido = false;
        for(Viagem viagem: listaDeViagens){

            if(viagem.getDestino().equalsIgnoreCase(destino)){

                for(Cliente cliente: viagem.listaClientes){

                    if(cliente.getNome().equalsIgnoreCase(nome)){
                        clienteRemovido = viagem.listaClientes.remove(cliente);
                    }
                }
            }
        }
        return clienteRemovido;
    }

}
