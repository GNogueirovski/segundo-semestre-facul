// RM: 563925 - Gabriel Nogueira Peixoto ; RM:565834 - Mariana Inoue ; RM: 566154 - Giovanna Neri dos Santos

package br.com.fiap.view;

import br.com.fiap.controller.FilmeController;

import javax.swing.*;

public class FilmeView {
    public static void main(String[] args) {
        String titulo, genero,produtora;
        int codigo, opcao;
        String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};

        FilmeController filmeController = new FilmeController();

        do{
            try{
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções para manipular Filme", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
                switch (opcao){
                    case 0:
                        titulo = JOptionPane.showInputDialog("Digite o nome do filme:");
                        genero = JOptionPane.showInputDialog("Digite o gênero do filme:");
                        produtora = JOptionPane.showInputDialog("Digite de qual produtora é o filme");
                        System.out.println(filmeController.inserirFilme(titulo, genero, produtora));
                        break;
                    case 1:
                        codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do filme que deseja alterar:"));
                        titulo = JOptionPane.showInputDialog("Digite o novo nome do filme:");
                        genero = JOptionPane.showInputDialog("Digite o novo gênero do filme:");
                        produtora = JOptionPane.showInputDialog("Digite a nova produtora do filme:");
                        System.out.println(filmeController.alterarFilme(codigo, titulo, genero, produtora));
                        break;
                    case 2:
                        codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do filme que deseja excluir:"));
                        System.out.println(filmeController.excluirFilme(codigo));
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, filmeController.listarTodosFilmes());
                        break;
                    default:
                        System.out.println("Opcao inválida");
                }
            }catch (Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atencão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de programa");
    }
}
