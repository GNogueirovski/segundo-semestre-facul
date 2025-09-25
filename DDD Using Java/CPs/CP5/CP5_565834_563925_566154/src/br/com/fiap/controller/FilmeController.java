// RM: 563925 - Gabriel Nogueira Peixoto ; RM:565834 - Mariana Inoue ; RM: 566154 - Giovanna Neri dos Santos

package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.FilmeDAO;
import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeController {

    public String inserirFilme(String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException {
        String resultado;


        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);

        Connection con = ConnectionFactory.abrirConexao();
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.inserir(filme);
        ConnectionFactory.fecharConexao(con);

        return resultado;
    }

    public String alterarFilme(int codigo,String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException{
        String resultado;

        Filme filme = new Filme();
        filme.setCodigo(codigo);
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);

        Connection con = ConnectionFactory.abrirConexao();
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.alterar(filme);
        ConnectionFactory.fecharConexao(con);

        return resultado;
    }

    public String excluirFilme(int codigo) throws ClassNotFoundException, SQLException{
        String resultado;



        Filme filme = new Filme();
        filme.setCodigo(codigo);

        Connection con = ConnectionFactory.abrirConexao();
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.excluir(filme);
        ConnectionFactory.fecharConexao(con);

        return resultado;
    }

    public String listarTodosFilmes() throws ClassNotFoundException, SQLException{
        String listaFilme = "";
        ArrayList<Filme> filmes;

        Connection con = ConnectionFactory.abrirConexao();
        FilmeDAO filmeDAO = new FilmeDAO(con);
        filmes = filmeDAO.listarTodos();
        ConnectionFactory.fecharConexao(con);

        if (filmes == null || filmes.isEmpty()){
            return "Não existe nenhum filme para ser listado";
        }

        for (Filme filme : filmes) {
            String filmeIndividual = String.format("Código: %s\nFilme: %s\nGenero: %s\nProdutora: %s\n", filme.getCodigo(), filme.getTitulo(), filme.getGenero(), filme.getProdutora());
            listaFilme += filmeIndividual + "\n";
        }
        return listaFilme;
    }
}
