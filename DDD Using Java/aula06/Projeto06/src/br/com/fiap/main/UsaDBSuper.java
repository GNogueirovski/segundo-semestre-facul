package br.com.fiap.main;

import br.com.fiap.bean.DragonBallSuper;

import javax.swing.*;
import java.io.IOException;

public class UsaDBSuper {
    public static void main(String[] args) {
        String nome, path;
        int opcao;
        DragonBallSuper personagem;

        do{
            try{
                opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha\n1.Cadastrar um personagem\n2.Consultar um personagem"));
                path = JOptionPane.showInputDialog("Digite o caminho da pasta");
                personagem = new DragonBallSuper();
                switch (opcao){
                    case 1:
                        personagem.setNome(JOptionPane.showInputDialog("Digite o nome do personagem"));
                        personagem.setKi(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantos pontos de KI que esse personagem possui: ")));
                        personagem.setTecnica(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantos pontos de Técnica que esse personagem possui: ")));
                        personagem.setVelocidade(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantos pontos de velocidade que esse personagem possui: ")));
                        personagem.setTransformacao(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de transformações que esse personagem faz: ")));

                        JOptionPane.showMessageDialog(null,personagem.gravar(path));
                        break;
                    case 2:
                        personagem.setNome(JOptionPane.showInputDialog("Digite o nome do personagem"));
                        personagem = personagem.ler(path);
                        if (personagem == null) {
                            JOptionPane.showMessageDialog(null, "Caminho e/ou nome de arquivo inexistente");
                        }else{
                            JOptionPane.showMessageDialog(null, "Exibindo dados"
                                    + "\nCaminho: " + path
                                    + "\nArquivo: " +personagem.getNome() + ".txt"
                                    + "\nNome do Personagem: " + personagem.getNome()
                                    + "\nKI: "+ personagem.getKi()
                                    + "\nTecnica: "+ personagem.getTecnica()
                                    + "\nVelocidade: "+ personagem.getVelocidade()
                                    + "\nTransformações: "+ personagem.getTransformacao());
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Escolha incorreta");
                }

            } catch (NumberFormatException e ) {
                JOptionPane.showMessageDialog(null, "Erro de conversão" + e.getMessage());
            }catch (IOException e ) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar arquivo: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }


        } while (JOptionPane.showConfirmDialog(null,"Deseja continuar?","Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim de Programa","Adeus de Programa",JOptionPane.WARNING_MESSAGE);
    }


}
