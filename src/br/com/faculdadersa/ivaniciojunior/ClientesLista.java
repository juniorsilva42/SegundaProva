package br.com.faculdadersa.ivaniciojunior;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class ClientesLista {

    private static LinkedList<ClientesEstrutura> lista = new LinkedList<ClientesEstrutura>();

    public void adicionaCliente (String nome, String cpf){

        ClientesEstrutura clientes = new ClientesEstrutura();
        Date data = new Date();
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtual = dataFormat.format(data);

        clientes.setNome(nome);
        clientes.setCpf(cpf);
        clientes.setData(dataAtual);
    }


}
