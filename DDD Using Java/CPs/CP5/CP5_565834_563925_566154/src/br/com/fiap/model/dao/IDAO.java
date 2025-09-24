// RM: 563925 - Gabriel Nogueira Peixoto ; RM:565834 - Mariana Inoue ; RM: 566154 - Giovanna Neri dos Santos

package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Filme;

import java.util.ArrayList;

public interface IDAO {
    String inserir(Filme filme);
    String alterar(Filme filme);
    String excluir(Filme filme);
    ArrayList<Filme> listarTodos();
}
