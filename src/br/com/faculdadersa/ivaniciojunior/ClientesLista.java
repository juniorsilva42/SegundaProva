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

        // Verifica a existência do cliente na lista com base no CPF.
        if (verificaExistenciaCliente(cpf))
            System.out.println("\nO cliente "+nome+" já existe na lista de proteção ao crédito.\n");
        else {
            clientes.setNome(nome);
            clientes.setCpf(cpf);
            clientes.setData(dataAtual);
            lista.add(clientes);
        }
    }

    public boolean removerCliente (String cpf){

        boolean retorno = false;

        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).getCpf().equals(cpf)){
                lista.remove(i);
                retorno = true;
                break;
            }
        }
        return retorno;
    }

    public void pesquisarCliente (String cpf){

        boolean encontrado = false;
        int indice = 0; // variável auxiliar que armazena o índice corrente do cliente encontrado

        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).getCpf().equalsIgnoreCase(cpf)){
                encontrado = true;
                indice = i;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Nome: " + lista.get(indice).getNome());
            System.out.println("CPF: " + lista.get(indice).getCpf());
            System.out.println("Data de inclusão: " + lista.get(indice).getData());
        } else
            System.out.println("Cliente inexistente!");
    }

    public boolean verificaExistenciaCliente (String cpf){

        boolean estado = false;

        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).getCpf().equalsIgnoreCase(cpf)){
                estado = true;
            }
        }
        return estado;
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
