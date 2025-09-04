package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.CarroDTO;

import java.sql.Connection;
import java.util.ArrayList;

public class TesteRead {
    public static void main(String[] args) {

        Connection con = ConnectionFactory.abrirConexao();
        CarroDAO carroDAO = new CarroDAO(con);

        ArrayList<CarroDTO> resultado = carroDAO.listar();

        if (resultado != null) {
            for (CarroDTO carro : resultado) {
                System.out.printf("Placa: %s\nCor: %s\nDescricao: %s\n", carro.getPlaca(), carro.getCor(), carro.getDescricao());
            }
        }

        ConnectionFactory.fecharConexao(con);


    }
}
