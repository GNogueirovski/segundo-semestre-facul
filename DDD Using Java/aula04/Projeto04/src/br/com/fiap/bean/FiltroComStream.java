package br.com.fiap.bean;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroComStream {
    public static void main(String[] args) {
        ArrayList<String> herois = new ArrayList<>(Arrays.asList("Homem-Aranha", "Wolverine", "Hulk", "Capitão América", "Homem Elástico"));

        List<String> heroisComH = herois.stream().filter(heroi -> heroi.startsWith("H")).collect(Collectors.toList());

        JOptionPane.showMessageDialog(null, String.format("Herois: %s", heroisComH));
    }
}
