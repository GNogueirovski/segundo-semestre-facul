package br.com.fiap.main;

public class TesteVetores {
    public static void main(String[] args) {
        String[] carros = {"Chevrolet", "Peugeout", "Volkswagen", "FIAT", "Volvo", "BMW"};

        for (String carro : carros) {
            if (carro.equals("Chevrolet")) {
                System.out.println(carro);
            }
        }


        for (int i = 0; i < carros.length; i++) {
            System.out.println(carros[i]);
        }





    }
}
