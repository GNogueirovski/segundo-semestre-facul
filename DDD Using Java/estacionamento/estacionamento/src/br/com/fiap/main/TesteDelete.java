package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.CarroDTO;

import java.sql.Connection;

public class TesteDelete {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();

        CarroDTO carro = new CarroDTO();
        carro.setPlaca("EEE1295");

        CarroDAO carroDAO = new CarroDAO(con);
        System.out.println(carroDAO.excluir(carro));

        ConnectionFactory.fecharConexao(con);
    }
}
