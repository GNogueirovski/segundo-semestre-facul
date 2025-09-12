package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.CarroDTO;
import br.com.fiap.dto.ClienteDTO;

import javax.swing.*;
import java.sql.Connection;
import java.util.ArrayList;

public class TesteEstacionamento {
    public static void main(String[] args) {
        do {
            try {
                int escolha = Integer.parseInt(JOptionPane.showInputDialog("""
                        Escolha:
                        1. Carro
                        2. Cliente"""));
                switch (escolha) {
                    case 1:
                        manipularCarro();
                        break;
                    case 2:
                        manipularCliente();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Escolha incorreta!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro de Conversão!\n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de Programa!");
    }

    private static void manipularCarro() {
        Connection con = ConnectionFactory.abrirConexao();
        CarroDTO carro = new CarroDTO();
        CarroDAO carroDAO = new CarroDAO(con);
        try {
            int escolha = Integer.parseInt(JOptionPane.showInputDialog("""
                    Escolha:
                    1. Cadastrar carro
                    2. Alterar carro
                    3. Excluir carro"""));
            String placa = JOptionPane.showInputDialog("Informe a placa do carro");
            carro.setPlaca(placa);
            switch (escolha) {
                case 1:
                    String cor1 = JOptionPane.showInputDialog("Informe a cor do carro");
                    String descricao1 = JOptionPane.showInputDialog("Informe a descrição do carro");
                    carro.setCor(cor1);
                    carro.setDescricao(descricao1);
                    System.out.println(carroDAO.inserir(carro));
                    break;
                case 2:
                    String cor2 = JOptionPane.showInputDialog("Informe a nova cor do carro");
                    String descricao2 = JOptionPane.showInputDialog("Informe a nova descrição do carro");
                    carro.setCor(cor2);
                    carro.setDescricao(descricao2);
                    System.out.println(carroDAO.alterar(carro));
                    break;
                case 3:
                    System.out.println(carroDAO.excluir(carro));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Escolha incorreta!");
            }
            ArrayList<CarroDTO> resultado = carroDAO.listar();
            if (resultado != null) {
                for (CarroDTO carro1 : resultado) {
                    System.out.println("Placa: " + carro1.getPlaca());
                    System.out.println("Cor: " + carro1.getCor());
                    System.out.println("Descrição: " + carro1.getDescricao());
                    System.out.println();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro de Conversão!\n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        ConnectionFactory.fecharConexao(con);
    }

    private static void manipularCliente() {
        Connection con = ConnectionFactory.abrirConexao();
        ClienteDTO cliente = new ClienteDTO();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        try {
            int escolha = Integer.parseInt(JOptionPane.showInputDialog("""
                    Escolha:
                    1. Cadastrar cliente
                    2. Alterar cliente
                    3. Excluir cliente"""));
            int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do cliente"));
            cliente.setIdCliente(idCliente);
            switch (escolha) {
                case 1:
                    String nome1 = JOptionPane.showInputDialog("Informe o nome do cliente");
                    String placa1 = JOptionPane.showInputDialog("Informe a placa do carro do cliente");
                    cliente.setNomeCliente(nome1);
                    cliente.setPlaca(placa1);
                    System.out.println(clienteDAO.inserir(cliente));
                    break;
                case 2:
                    String nome2 = JOptionPane.showInputDialog("Informe o novo nome do cliente");
                    String placa2 = JOptionPane.showInputDialog("Informe a nova placa do carro do cliente");
                    cliente.setNomeCliente(nome2);
                    cliente.setPlaca(placa2);
                    System.out.println(clienteDAO.alterar(cliente));
                    break;
                case 3:
                    System.out.println(clienteDAO.excluir(cliente));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Escolha incorreta!");
            }
            ArrayList<ClienteDTO> resultado = clienteDAO.listar();
            if (resultado != null) {
                for (ClienteDTO cliente1 : resultado) {
                    System.out.println("ID: " + cliente1.getIdCliente());
                    System.out.println("Nome: " + cliente1.getNomeCliente());
                    System.out.println("Placa: " + cliente1.getPlaca());
                    System.out.println();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro de Conversão!\n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        ConnectionFactory.fecharConexao(con);
    }
}