package br.com.fiap.bean;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PokemonHashMap {
    public static void main(String[] args) {
        HashMap<String, String> pokemon = new HashMap<>();

        do{
            try{
                String nome, tipo;
                // Cadastro de Siglas e Nomes de Estado
                do{
                    nome = JOptionPane.showInputDialog("Digite o nome do pokemon ou FIM para continuar: ").toUpperCase();

                    if(!nome.equalsIgnoreCase("FIM")) {
                        if(!pokemon.containsKey(nome)) {
                            tipo = JOptionPane.showInputDialog("Digite o tipo do pokemon: ");
                            pokemon.put(nome, tipo);
                        } else {
                            JOptionPane.showMessageDialog(null, "Pokemon já cadastrado!");
                        }
                    }
                }while (!nome.equals("FIM"));

                // Busca do tipo do pokemon
                String escolha = JOptionPane.showInputDialog("Digite um tipo de pokemon a ser procurado");
                    for(Map.Entry<String, String> i : pokemon.entrySet()) {
                        if(escolha.equals(i.getValue())) {
                            JOptionPane.showMessageDialog(null, i.getKey() + " " + i.getValue());
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Tipo de pokemon não cadastrado!");
                        }
                    }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } while (JOptionPane.showConfirmDialog(null,"Deseja continuar?","Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim de Programa","Adeus de Programa",JOptionPane.WARNING_MESSAGE);

    }
}
