package br.com.fiap.model.dao;

import br.com.fiap.model.dto.CarroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CarroDAO implements IDAO {
    private Connection con;
    private CarroDTO carro;

    public CarroDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object) {
       carro = (CarroDTO) object;

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

    public String alterar(Object object) {
        carro = (CarroDTO) object;

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
    public String excluir(Object object) {
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

    public String listarUm(Object object) {
        String sql = "SELECT * FROM ddd_carro where placa = ?";

        try(PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();) {
            if (rs.next()) {
                return String.format("Placa: %s \nCor: %s \nDescricao: %s", rs.getString("placa"), rs.getString("cor"), rs.getString("descricao"));
            } else {
                return "Registro não encontrado";
            }
        } catch (SQLException e) {
            return "Erro no comando SQL " + e.getMessage();
        }

    }
}
