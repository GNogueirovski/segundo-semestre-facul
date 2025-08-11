package br.com.fiap.bean;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class SuperHeroi {
    String nome;
    String idSecreta;
    ArrayList<String> poderes;
    ArrayList<String> fraquezas;

    public SuperHeroi() {
    }

    public SuperHeroi(String nome, String idSecreta, ArrayList<String> poderes, ArrayList<String> fraquezas) {
        this.nome = nome;
        this.idSecreta = idSecreta;
        this.poderes = poderes;
        this.fraquezas = fraquezas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdSecreta() {
        return idSecreta;
    }

    public void setIdSecreta(String idSecreta) {
        this.idSecreta = idSecreta;
    }

    public ArrayList<String> getPoderes() {
        return poderes;
    }

    public void setPoderes(ArrayList<String> poderes) {
        this.poderes = poderes;
    }

    public ArrayList<String> getFraquezas() {
        return fraquezas;
    }

    public void setFraquezas(ArrayList<String> fraquezas) {
        this.fraquezas = fraquezas;
    }

    public void listarHeroi(){
        String exibe = String.format("Nome do Herói: %s \n", nome);
        exibe += String.format("Identidade Secreta: %s \n", idSecreta);
        int cont = 1;
        Collections.sort(poderes);
        for (String i : poderes) {
            exibe += String.format("Poder %d: %s \n", cont, i);
            cont++;
        }

        cont = 1;
        Collections.sort(fraquezas);
        for(String i : fraquezas) {
            exibe += String.format("Fraqueza %d: %s \n", cont, i);
            cont++;
        }
        JOptionPane.showMessageDialog(null, exibe, "Listagem da Equipe", JOptionPane.INFORMATION_MESSAGE);
    }


}
