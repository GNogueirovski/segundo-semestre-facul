package br.com.fiap.main;

import br.com.fiap.bean.ContaBancaria;
import br.com.fiap.exception.SaldoInsuficienteException;

public class UsaContaBancaria {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000);

        try {
            conta.sacar(1000);
        } catch (SaldoInsuficienteException e) {
            throw new RuntimeException(e);
        }
    }
}
