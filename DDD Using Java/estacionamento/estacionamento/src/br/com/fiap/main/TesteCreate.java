package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.CarroDTO;

import java.sql.Connection;

public class TesteCreate {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();

        CarroDTO carro = new CarroDTO();
        carro.setCor("Prata");
        carro.setPlaca("EEE1295");
        carro.setDescricao("Ford Mustang 1969");

        CarroDAO carroDAO = new CarroDAO(con);
        System.out.println(carroDAO.inserir(carro));

        ConnectionFactory.fecharConexao(con);
    }
}
