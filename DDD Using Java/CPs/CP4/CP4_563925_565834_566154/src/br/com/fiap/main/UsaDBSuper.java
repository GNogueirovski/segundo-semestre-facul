// RM: 563925 - Gabriel Nogueira Peixoto ; RM:565834 - Mariana Inoue ; RM: 566154 - Giovanna Neri dos Santos
package br.com.fiap.main;

import br.com.fiap.bean.DragonBallSuper;

import javax.swing.*;
import java.io.IOException;


/**
 * Classe de teste com o metedo main, que através da interação com o usuário faz o cadastro de um personagem de DB Super,
 * e procura um personagem no sistema em uma determinada pasta, salvando um arquivo txt com seus atributos
 * @author Mariana Inoue
 * @author Gabriel Nogueira
 * @version 1.0
 */
public class UsaDBSuper {
    public static void main(String[] args) {
        String nome, path;
        int ki, tecnica, velocidade, transformacao;
        int opcao;
        DragonBallSuper personagem;

        do{
            JOptionPane.showMessageDialog(null, "Bem-vindo ao Programa de Dragon Ball Super");
            try{
                opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opções abaixo:\n1.Cadastrar um personagem de DB Super\n2.Procurar um personagem de DB Super"));
                personagem = new DragonBallSuper();
                switch (opcao){
                    case 1:
                        path = JOptionPane.showInputDialog("Digite o caminho da pasta que onde será salvo o arquivo com as informações do personagem");

                        nome = JOptionPane.showInputDialog("Digite o nome do personagem");

                        ki = Integer.parseInt(JOptionPane.showInputDialog("Digite quantos pontos de KI esse personagem possui"));

                        tecnica = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantos pontos de Técnica que esse personagem possui: "));
                        velocidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantos pontos de velocidade que esse personagem possui: "));

                        transformacao = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de transformações que esse personagem faz: "));

                        personagem.setNome(nome);
                        personagem.setKi(ki);
                        personagem.setTecnica(tecnica);
                        personagem.setVelocidade(velocidade);
                        personagem.setTransformacao(transformacao);

                        JOptionPane.showMessageDialog(null,personagem.gravar(path));
                        break;
                    case 2:
                        path = JOptionPane.showInputDialog("Digite o caminho da pasta onde foi salvo o arquivo do personagem");

                        nome = JOptionPane.showInputDialog("Digite o nome do personagem");
                        personagem.setNome(nome);

                        personagem = personagem.ler(path);
                        if (personagem == null) {
                            JOptionPane.showMessageDialog(null, "Caminho e/ou nome de arquivo inexistente");
                        }else{
                            JOptionPane.showMessageDialog(null, "Informações do Arquivo"
                                    + "\nCaminho: " + path
                                    + "\nArquivo: " +personagem.getNome().replaceAll(" ", "_").toLowerCase() + ".txt"
                                    + "\n\nInformações do Personagem"
                                    + "\nNome: " + personagem.getNome()
                                    + "\nPontos de KI: "+ personagem.getKi()
                                    + "\nPontos de Técnica: "+ personagem.getTecnica()
                                    + "\nVelocidade: "+ personagem.getVelocidade()
                                    + "\nTransformações: "+ personagem.getTransformacao());
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Escolha incorreta, selecione uma das opções disponíveis");
                }

            } catch (NumberFormatException e ) {
                JOptionPane.showMessageDialog(null, "Erro de conversão: " + e.getMessage());
            }catch (IOException e ) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar arquivo: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }


        } while (JOptionPane.showConfirmDialog(null,"Deseja continuar?","Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim de Programa","Adeus de Programa",JOptionPane.WARNING_MESSAGE);
    }


}
