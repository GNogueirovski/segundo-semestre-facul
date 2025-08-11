package br.com.fiap.main;

import br.com.fiap.bean.Equipe;

import javax.swing.*;

public class MainEquipe {
    public static void main(String[] args) {
        Equipe equipe;
        String nome;
        String[] integrantes;
        int quantidade;

        do{
            try{
                nome = JOptionPane.showInputDialog("Digite o nome da equipe: ");
                quantidade = Integer.parseInt(JOptionPane.showInputDialog(String.format("Número de integrantes da equipe %s", nome)));

                integrantes = new String[quantidade];

                for (int i = 0; i < integrantes.length; i++){
                    integrantes[i] = JOptionPane.showInputDialog(String.format("Digite o nome do integrante %d", i+1));
                }

                equipe = new Equipe(nome, integrantes);

                equipe.listaIntegrantes();


            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } while (JOptionPane.showConfirmDialog(null,"Deseja continuar?","Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim de Programa","Adeus de Programa",JOptionPane.WARNING_MESSAGE);
    }
}
