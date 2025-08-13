package br.com.fiap.bean;

import javax.swing.*;
import java.util.HashMap;

public class ExemploHashMap {
    public static void main(String[] args) {
        HashMap<String, String> mapa = new HashMap<>();

        do{
            try{
                String sigla, estado;
                // Cadastro de Siglas e Nomes de Estado
                do{
                    sigla = JOptionPane.showInputDialog("Digite uma UF de um estado ou digite FIM para encerrar o programa: ").toUpperCase();
                    if(!sigla.equals("FIM")) {
                        if(mapa.containsKey(sigla)) {
                            JOptionPane.showMessageDialog(null, "Estado já cadastrado!");
                        } else {
                            estado = JOptionPane.showInputDialog("Digite o nome completo do estado referente a UF: ");
                            mapa.put(sigla, estado);
                        }
                    }
                }while (!sigla.equals("FIM"));

                // Busca do nome do Estado pela sua Sigla
                String escolha = JOptionPane.showInputDialog("Digite uma UF a sua escolha").toUpperCase();
                if(mapa.containsKey(escolha)) {
                    JOptionPane.showMessageDialog(null, "Estado: " + mapa.get(escolha));
                } else {
                    JOptionPane.showMessageDialog(null, "Estado não cadastrado!");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } while (JOptionPane.showConfirmDialog(null,"Deseja continuar?","Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim de Programa","Adeus de Programa",JOptionPane.WARNING_MESSAGE);

    }
}
