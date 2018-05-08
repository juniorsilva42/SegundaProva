package br.com.faculdadersa.ivaniciojunior;

public class ClientesListaTeste {

    public static void main(String[] args) {
        ClientesLista clientes = new ClientesLista();

        // Adiciona alguns clientes na lista
        clientes.adicionaCliente("Ivanicio Jr", "07380242369");
        clientes.adicionaCliente("Lara Rodrigues", "123123123123");
        clientes.adicionaCliente("Fulano de Tal", "321321321321");
        clientes.adicionaCliente("Fulano de Tal 2", "7851531448646");
        clientes.adicionaCliente("Fulano de Tal 3", "1524999334886");

        System.out.println("Lista de clientes no Sistema de proteção ao crédito:");
        System.out.println("---------------------------------------------------------------\n");

        // Exibe
        System.out.println(clientes.toString());

        // Remove um pelo CPF
        if (clientes.removerCliente("123123123123"))
            System.out.println("Removendo cliente...");
            System.out.println("Cliente removido com sucesso!");

        // Adiciona o que foi removido novamente
        clientes.adicionaCliente("Lara Rodrigues", "123123123123");

        // Testa se o sistema vai emitir a mensagem de cancelamento do CPF
        clientes.verificaReincidentes("123123123123");

        // Pesquisando cliente
        clientes.pesquisarCliente("07380242369");
    }

}
