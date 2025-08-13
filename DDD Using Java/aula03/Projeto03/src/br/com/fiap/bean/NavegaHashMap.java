package br.com.fiap.bean;

import java.util.HashMap;
import java.util.Map;

public class NavegaHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> pessoas = new HashMap<>();
        pessoas.put("Pedro", 1);
        pessoas.put("Maria", 2);
        pessoas.put("Joao", 3);
        pessoas.put("Martins", 4);
        pessoas.put("Astrogildo", 5);

        //Utilização do forEach com o .entrySet percorre toda linha e guarda na variavel i
        for(Map.Entry<String, Integer> i : pessoas.entrySet()) {
            System.out.println(i.getKey() + " " + i.getValue());
        }


    }
}
