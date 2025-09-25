// RM: 563925 - Gabriel Nogueira Peixoto ; RM:565834 - Mariana Inoue ; RM: 566154 - Giovanna Neri dos Santos
package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDAO {
    private Connection con;

    public FilmeDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Filme filme) {

        String sql = "INSERT INTO ddd_filme (titulo, genero, produtora) VALUES (?, ?, ?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());

            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            } else {
                return "Erro ao inserir";
            }


        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }

    }

    public String alterar(Filme filme) {
        String sql = "UPDATE ddd_filme SET titulo=?, genero=?, produtora=? WHERE codigo=?";

        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());
            ps.setInt(4, filme.getCodigo());
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
    public String excluir(Filme filme) {
        String sql = "DELETE FROM ddd_filme WHERE codigo=?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setInt(1, filme.getCodigo());
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

    public ArrayList<Filme> listarTodos() {

        String sql = "SELECT * FROM ddd_filme order by codigo";

        ArrayList<Filme> filmes = new ArrayList<>();

        try(PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            if (rs != null) {
                while (rs.next()){
                    Filme filme = new Filme();
                    filme.setCodigo(rs.getInt("codigo"));
                    filme.setTitulo(rs.getString("titulo"));
                    filme.setGenero(rs.getString("genero"));
                    filme.setProdutora(rs.getString("produtora"));

                    filmes.add(filme);
                }
                return filmes;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro no comando SQL " + e.getMessage());
        }
        return null;
    }
}
