package br.com.fiap.view;

import br.com.fiap.controller.CarroController;

import javax.swing.*;

public class CarroView {
    public static void main(String[] args) {
        String placa, cor, descricao;
        int opcao;
        String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};

        CarroController carroController = new CarroController();

        do{
            try{
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções para manipular um Carro", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
                placa = JOptionPane.showInputDialog("Digite a placa do carro");

                switch (opcao){
                    case 0:
                        cor = JOptionPane.showInputDialog("Digite a cor do carro");
                        descricao = JOptionPane.showInputDialog("Digite o modelo do carro");
                        System.out.println(carroController.inserirCarro(placa, cor, descricao));
                        break;
                    case 1:
                        cor = JOptionPane.showInputDialog("Digite uma nova cor para o carro");
                        descricao = JOptionPane.showInputDialog("Digite um novo modelo para o carro");
                        System.out.println(carroController.alterarCarro(placa, cor, descricao));
                        break;
                    case 2:
                        System.out.println(carroController.excluirCarro(placa));
                        break;
                    case 3:
                        System.out.println(carroController.listarUmCarro(placa));
                        break;
                    default:
                        System.out.println("Opcao inválida");
                }
            }catch (Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atencão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showConfirmDialog(null, "Fim de programa");
    }
}
