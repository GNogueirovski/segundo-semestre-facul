package br.com.fiap.dao;

import br.com.fiap.dto.CarroDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    private Connection con;

    public CarroDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(CarroDTO carro) {
        String sql = "INSERT INTO ddd_carro (placa, cor, descricao) VALUES (?, ?, ?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getCor());
            ps.setString(3, carro.getDescricao());

            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir";
            }


        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }

    }

    public String alterar(CarroDTO carro) {
        String sql = "UPDATE ddd_carro SET cor=?, descricao=? WHERE placa=?";

        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setString(1, carro.getCor());
            ps.setString(2, carro.getDescricao());
            ps.setString(3, carro.getPlaca());
            if (ps.executeUpdate() > 0) {
                return "Valores alterados com sucesso";
            } else {
                return "Erro ao atualizar valores";
            }
        }
        catch (SQLException e) {
            return "Erro no comando SQL " + e.getMessage();
        }
    }
    public String excluir(CarroDTO carro) {
        String sql = "DELETE FROM ddd_carro WHERE placa=?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setString(1, carro.getPlaca());
            if (ps.executeUpdate() > 0) {
                return "Excluido com Sucesso";
            } else {
                return "Erro ao excluir";
            }
        }
        catch (SQLException e) {
            return "Erro no comando SQL " + e.getMessage();
        }
    }

    public ArrayList<CarroDTO> listar() {
        String sql = "SELECT * FROM ddd_carro order by placa";

        ArrayList<CarroDTO> carros = new ArrayList<>();
        try(PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();) {
            if (rs != null) {
                while (rs.next()){
                    CarroDTO carro = new CarroDTO();
                    carro.setPlaca(rs.getString(1));
                    carro.setCor(rs.getString(2));
                    carro.setDescricao(rs.getString(3));
                    carros.add(carro);
                }
                return carros;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL " + e.getMessage());
            return null;
        }

    }
}
