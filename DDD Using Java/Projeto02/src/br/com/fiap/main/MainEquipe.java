package br.com.fiap.main;

import br.com.fiap.bean.Equipe;

import javax.swing.*;
import java.util.ArrayList;

public class MainEquipe {
    public static void main(String[] args) {
        Equipe grupo;
        String nome, auxiliar;
        do {
            try {
                nome = JOptionPane.showInputDialog("Digite o nome da equipe");
                ArrayList<String> integrantes = new ArrayList<>();
                String membros = "continuar";
                while (membros.equalsIgnoreCase("continuar")){
                    auxiliar = JOptionPane.showInputDialog("Digite o nome um integrante desta equipe ou digite \"fim\" para encerrar");
                    if(auxiliar.equalsIgnoreCase("fim")){
                        membros = "fim";
                    }else{
                        integrantes.add(auxiliar);
                        String mensagem = String.format("O integrante %s foi adicionado a equipe %s.", auxiliar, nome);
                        JOptionPane.showMessageDialog(null, mensagem);
                    }
                }
                grupo = new Equipe(nome, integrantes);
                grupo.listarEquipe();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while(JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de programa. Até breve!", "Adeus", JOptionPane.WARNING_MESSAGE);
    }
}