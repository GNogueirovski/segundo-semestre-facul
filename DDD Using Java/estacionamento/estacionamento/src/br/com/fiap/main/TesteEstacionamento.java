package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.CarroDTO;

import javax.swing.*;
import java.sql.Connection;

public class TesteEstacionamento {
    public static void main(String[] args) {
        int opcao;


        do{
            JOptionPane.showMessageDialog(null, "Bem-vindo ao Parking Lot", "Welcome", JOptionPane.INFORMATION_MESSAGE);
            try{
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma das opções abaixo:\n1.Manipular carro\n2.Manipular Cliente", "Menu de Seleção", JOptionPane.QUESTION_MESSAGE));
                switch (opcao){
                    case 1:
                        manipularCarro();


                        break;
                    case 2:

                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Escolha incorreta, selecione uma das opções disponíveis", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e ) {
                JOptionPane.showMessageDialog(null, "Erro de conversão: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }


        } while (JOptionPane.showConfirmDialog(null,"Deseja continuar?","Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim de Programa","Adeus de Programa",JOptionPane.WARNING_MESSAGE);
    }
    private static void manipularCliente() {
        int opcaoCliente;
        {
            try {
                opcaoCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma das opções abaixo:\n1.Manipular carro\n2.Manipular Cliente", "Menu de Seleção", JOptionPane.QUESTION_MESSAGE));
                switch (opcaoCliente) {
                    case 1:


                        break;
                    case 2:

                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Escolha incorreta, selecione uma das opções disponíveis", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro de conversão: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0)
            ;
    }
    private static void manipularCarro(){
        int opcaoCarro;
        {
            try{
                opcaoCarro = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma das opções abaixo:\n1.Inserir o carro\n2.Alterar algum carro existente\n3.Deletar carro existente", "Menu de Carros", JOptionPane.QUESTION_MESSAGE));
                switch (opcaoCarro){
                    case 1:
                        Connection con = ConnectionFactory.abrirConexao();
                        CarroDTO carro = new CarroDTO();
                        carro.setPlaca(JOptionPane.showInputDialog(null, "Digite a placa do carro que será cadastrado"));
                        carro.setCor(JOptionPane.showInputDialog(null, "Digite a cor do carro que será cadastrado"));
                        carro.setDescricao(JOptionPane.showInputDialog(null, "Digite o nome do modelo do carro que será cadastrado"));
                        CarroDAO carroDAO = new CarroDAO(con);
                        carroDAO.inserir(carro);
                        carroDAO.listar();
                        ConnectionFactory.fecharConexao(con);

                        break;
                    case 2:

                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Escolha incorreta, selecione uma das opções disponíveis", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e ) {
                JOptionPane.showMessageDialog(null, "Erro de conversão: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);}
        } while (JOptionPane.showConfirmDialog(null,"Deseja continuar?","Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

    }
}


