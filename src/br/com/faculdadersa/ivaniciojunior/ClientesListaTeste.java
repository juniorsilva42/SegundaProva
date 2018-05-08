package br.com.faculdadersa.ivaniciojunior;

public class ClientesListaTeste {

    public static void main(String[] args) {
        ClientesLista clientes = new ClientesLista();

        clientes.adicionaCliente("Ivanicio Jr", "07380242369");
        clientes.adicionaCliente("Lara Rodrigues", "123123123123");
        clientes.adicionaCliente("Fulano de Tal", "321321321321");

        System.out.println(clientes.toString());

        if (clientes.removerCliente("07380242369")){
            System.out.println("Cliente removido com sucesso");
        }

        System.out.println(clientes.toString());

    }
}
