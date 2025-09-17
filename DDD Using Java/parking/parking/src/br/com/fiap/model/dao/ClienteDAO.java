package br.com.fiap.model.dao;

import br.com.fiap.model.dto.ClienteDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO implements IDAO {
    private Connection con;
    private ClienteDTO cliente;

    public ClienteDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object) {
        cliente = (ClienteDTO) object;

        String sql = "INSERT INTO ddd_cliente (nome_cliente, placa) VALUES (?, ?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, cliente.getNomeCliente());
            ps.setString(2, cliente.getPlaca());

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
        cliente = (ClienteDTO) object;

        String sql = "UPDATE ddd_cliente SET nome_cliente=?, placa=? WHERE id_cliente=?";

        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setString(1, cliente.getNomeCliente());
            ps.setString(2, cliente.getPlaca());
            ps.setInt(3, cliente.getIdCliente());
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
        cliente = (ClienteDTO) object;
        String sql = "DELETE FROM ddd_cliente WHERE id_cliente=?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setInt(1, cliente.getIdCliente());
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
        cliente = (ClienteDTO) object;

        String sql = "SELECT * FROM ddd_cliente where id_cliente=?";

        try(PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, cliente.getIdCliente());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return "Id: " + rs.getInt("id_cliente") + "\nNome: " + rs.getString("nome_cliente") + "\nPlaca: " + rs.getString("placa");
            } else {
                return "Registro não encontrado";
            }
        } catch (SQLException e) {
            return "Erro no comando SQL " + e.getMessage();
        }
    }
}
