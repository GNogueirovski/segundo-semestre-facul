package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.CarroDTO;
import br.com.fiap.dto.ClienteDTO;

import java.sql.Connection;
import java.util.ArrayList;

public class TesteClienteCRUD {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();

        ClienteDTO cliente1 = new ClienteDTO();
        cliente1.setIdCliente(1);
        cliente1.setPlaca("GUI1985");
        cliente1.setNomeCliente("Guilherme Kam");

        ClienteDTO cliente2 = new ClienteDTO();
        cliente2.setIdCliente(2);
        cliente2.setPlaca("AIO5995");
        cliente2.setNomeCliente("Maria Eduarda");

        ClienteDTO cliente3 = new ClienteDTO();
        cliente3.setIdCliente(3);
        cliente3.setPlaca("EEE1295");
        cliente3.setNomeCliente("Gil das Neves");

        ClienteDTO cliente4 = new ClienteDTO();
        cliente4.setIdCliente(4);
        cliente4.setPlaca("LYJ8990");
        cliente4.setNomeCliente("Astrogildo Silva");

        ClienteDTO cliente5 = new ClienteDTO();
        cliente5.setIdCliente(5);
        cliente5.setPlaca("GAL1396");
        cliente5.setNomeCliente("Gabriel Peixoto");

        ClienteDAO clienteDAO = new ClienteDAO(con);

        // Alteração cliente 5
        cliente5.setNomeCliente("Gabriel Nogueira");
        cliente5.setPlaca("GAL1396");
        System.out.println(clienteDAO.alterar(cliente5));


        // Deletando cliente 5
        cliente5.setIdCliente(5);
        System.out.println(clienteDAO.excluir(cliente5));

        // Listando todos os clientes no banco
        ArrayList<ClienteDTO> resultado = clienteDAO.listar();

        if (resultado != null) {
            for (ClienteDTO cliente : resultado) {
                System.out.printf("ID: %d\nNome Cliente: %s\nPlaca do Carro: %s\n\n", cliente.getIdCliente(), cliente.getNomeCliente(), cliente.getPlaca());
            }
        }

        ConnectionFactory.fecharConexao(con);
    }
}
