// RM: 563925 - Gabriel Nogueira Peixoto ; RM:565834 - Mariana Inoue ; RM: 566154 - Giovanna Neri dos Santos
package br.com.fiap.interfaces;

import br.com.fiap.bean.DragonBallSuper;

import java.io.IOException;

/**
 * Interface com as assinaturas dos métodos ler, que lança uma Exception de I/O e o metodo gravar.
 * @version 1.0
 * @author Gabriel Nogueira
 */
public interface IDBSuper {
    public DragonBallSuper ler (String path) throws IOException;
    public String gravar (String path);

}