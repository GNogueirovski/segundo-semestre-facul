package br.com.fiap.dao;

import br.com.fiap.dto.CarroDTO;
import br.com.fiap.dto.ClienteDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
    private Connection con;

    public ClienteDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(ClienteDTO cliente) {
        String sql = "INSERT INTO ddd_cliente (id_cliente, nome_cliente, placa) VALUES (?, ?, ?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNomeCliente());
            ps.setString(3, cliente.getPlaca());

            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir";
            }


        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }

    }

    public String alterar(ClienteDTO cliente) {
        String sql = "UPDATE ddd_cliente SET nome_cliente=? WHERE id_cliente=?";

        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setString(1, cliente.getNomeCliente());
            ps.setInt(2, cliente.getIdCliente());
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
    public String excluir(ClienteDTO cliente) {
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

    public ArrayList<ClienteDTO> listar() {
        String sql = "SELECT * FROM ddd_cliente order by id_cliente";

        ArrayList<ClienteDTO> clientes = new ArrayList<>();
        try(PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();) {
            if (rs != null) {
                while (rs.next()){
                    ClienteDTO cliente = new ClienteDTO();
                    cliente.setIdCliente(rs.getInt(1));
                    cliente.setNomeCliente(rs.getString(2));
                    cliente.setPlaca(rs.getString(3));
                    clientes.add(cliente);
                }
                return clientes;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL " + e.getMessage());
            return null;
        }
    }

    public static void manipularCliente(){


    }


}
