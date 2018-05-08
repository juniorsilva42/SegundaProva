package br.com.faculdadersa.ivaniciojunior;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class ClientesLista {

    /*
    *
    * Instancia o objeto das listas de forma global
    *
    * lista: lista que armazena os nomes dos clientes no sistema de proteção ao crédito
    * listaReincidentes: lista que armazena os clientes reincidentes de proteção ao crédito
    *
    * */
    private static LinkedList<ClientesEstrutura> lista = new LinkedList<ClientesEstrutura>();
    private static LinkedList<ClientesEstrutura> listaReincidentes = new LinkedList<ClientesEstrutura>();

    /*
     *
     * Procedimento para adicionar um cliente na lista
     *
     * @arguments: String nome, String cpf
     * @return: void
     *
     * */
    public void adicionaCliente (String nome, String cpf){

        /*
         *
         * A cada invocação do procedimento adicionaCliente, instancia-se o nossa estrutura para cada cliente adicionado
         *
         * Obtem a data da inclusão (pegando a data atual do sistema)
         *
         * */
        ClientesEstrutura clientes = new ClientesEstrutura();
        Date data = new Date();
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataAtual = dataFormat.format(data);

        // Verifica a existência do cliente na lista com base no CPF.
        if (verificaExistenciaCliente(cpf))
            System.out.println("O cliente "+nome+" já existe na lista de proteção ao crédito.");
        else {
            clientes.setNome(nome);
            clientes.setCpf(cpf);
            clientes.setData(dataAtual);
            lista.add(clientes);
        }
    }

    /*
     *
     * Método que remove um cliente da lista
     *
     * @arguments: String cpf
     * @return: boolean
     *
     * */
    public boolean removerCliente (String cpf){

        // Variável auxiliar para controlar o retorno do método
        boolean retorno = false;

        /*
         *
         * Percorre toda a lista buscando uma igualdade entre o CPF que está na iteração com o cpf do argumento da função, caso encontre, adiciona o cliente corrente na lista de reincidentes e, em seguida, o remove... ulterior a isso, a função passa o retorno para true e breca o laço pois não há mais necessidade de procurar.
         *
         * @arguments: String nome, String cpf
         * @return: void
         *
         * */
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).getCpf().equals(cpf)){
                listaReincidentes.add(lista.get(i));
                lista.remove(i);
                retorno = true;
                break;
            }
        }
        return retorno;
    }

    /*
     *
     * Procedimento para pesquisar um cliente na lista
     *
     * @arguments: String cpf
     * @return: void
     *
     * */
    public void pesquisarCliente (String cpf){

        // Variável auxiliar para controlar o retorno do método
        boolean encontrado = false;
        int indice = 0; // variável auxiliar que armazena o índice corrente do cliente encontrado

        // percorre a lista
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).getCpf().equals(cpf)){
                encontrado = true;
                indice = i; // armazena, em índice, o valor do índice da lista onde foi encontrado o termo da busca
                break;
            }
        }

        // se encontrado...
        if (encontrado) {
            System.out.println("\nCliente encontrado:");
            System.out.println("---------------------------------------------");
            System.out.println("Nome: " + lista.get(indice).getNome());
            System.out.println("CPF: " + lista.get(indice).getCpf());
            System.out.println("Data de inclusão: " + lista.get(indice).getData());
        } else
            System.out.println("\nCliente inexistente!");
    }

    /*
     *
     * Método que verifica a existência de um cliente na lista
     *
     * @arguments: String cpf
     * @return: void
     *
     * */
    public boolean verificaExistenciaCliente (String cpf){

        // Variável auxiliar para controle de estado do laço
        boolean estado = false;

        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).getCpf().equals(cpf)){
                estado = true;
            }
        }
        return estado;
    }

    /*
     *
     * Procedimento que verifica se um cliente é reincidente na lista de proteção ao crédito
     *
     * @arguments: String cpf
     * @return: void
     *
     * */
    public void verificaReincidentes (String cpf){

        // Variáveis de controle de estado do laço
        boolean estado = false;
        int indice = 0;

        /*
         *
         * Percorre de reincidentes buscando uma igualdade entre o CPF de quem está nesta lista e o CPF passado no argumento da função
         *
         * */
        for (int i = 0; i < listaReincidentes.size(); i++){
            if (listaReincidentes.get(i).getCpf().equals(cpf)){
                estado = true;
                indice = i; // armazena, em índice, o valor do índice da lista onde foi encontrado o termo da busca
                break;
            }
        }

        if (estado){
            System.out.println("\nO cliente "+listaReincidentes.get(indice).getNome()+" já esteve anteriormente na lista de proteção ao crédito, portanto, o seu CPF de número "+listaReincidentes.get(indice).getCpf()+" será cancelado!");
        }
    }

    /*
     *
     * Método para exibir os clientes na lista de proteção ao crédito
     *
     * @arguments: null
     * @return: String
     *
     * */
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
