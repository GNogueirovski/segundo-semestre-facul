package br.com.fiap.interfaces;

import br.com.fiap.bean.DragonBallSuper;

import java.io.IOException;

public interface IDBSuper {
    public DragonBallSuper ler (String path) throws IOException;
    public String gravar (String path);

}
