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

        lista.add(clientes);
    }

    public boolean removerCliente (String cpf){

        ClientesEstrutura clientes = new ClientesEstrutura();
        boolean retorno = false;

        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).getCpf().equalsIgnoreCase(cpf)){
                lista.remove(i);
                retorno = true;
                break;
            }
        }
        return retorno;
    }

    public String toString (){

        StringBuilder s = new StringBuilder();

        int i = 0;

        while (i < lista.size()){
            s.append("Nome: "+lista.get(i).getNome());
            s.append("\n");

            s.append("CPF: "+lista.get(i).getCpf());
            s.append("\n");

            s.append("Data de inclusão "+lista.get(i).getData());
            s.append("\n\n");
            i++;
        }

        return s.toString();
    }
}
