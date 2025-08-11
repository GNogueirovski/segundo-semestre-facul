package br.com.fiap.main;

import br.com.fiap.bean.Equipe;
import br.com.fiap.bean.SuperHeroi;

import javax.swing.*;
import java.util.ArrayList;

public class MainSuperHeroi {
    public static void main(String[] args) {
        SuperHeroi heroi;
        String nome, idSecreta, auxiliar;
        do {
            try {
                nome = JOptionPane.showInputDialog("Digite o nome do super herói");
                idSecreta = JOptionPane.showInputDialog("Digite a identidade secreta do herói");

                ArrayList<String> fraquezas = new ArrayList<>();
                String fraqueza = "continuar";
                while (fraqueza.equalsIgnoreCase("continuar")){
                    auxiliar = JOptionPane.showInputDialog("Digite uma fraqueza do herói ou digite \"fim\" para adicionar os poderes do herói");
                    if(auxiliar.equalsIgnoreCase("fim")){
                        fraqueza = "fim";
                    }else{
                        fraquezas.add(auxiliar);
                        String mensagem = String.format("A fraqueza %s foi adicionada ao herói %s.", auxiliar, nome);
                        JOptionPane.showMessageDialog(null, mensagem);
                    }
                }
                ArrayList<String> poderes = new ArrayList<>();
                String poder = "continuar";
                while (poder.equalsIgnoreCase("continuar")){
                    auxiliar = JOptionPane.showInputDialog("Digite um poder do herói ou digite \"fim\" para ver todos os atributos do herói");
                    if(auxiliar.equalsIgnoreCase("fim")){
                        poder = "fim";
                    }else{
                        poderes.add(auxiliar);
                        String mensagem = String.format("O poder %s foi adicionada ao herói %s.", auxiliar, nome);
                        JOptionPane.showMessageDialog(null, mensagem);
                    }
                }
                heroi = new SuperHeroi(nome, idSecreta, poderes, fraquezas);
                heroi.listarHeroi();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while(JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de programa. Até breve!", "Adeus", JOptionPane.WARNING_MESSAGE);
    }
}
