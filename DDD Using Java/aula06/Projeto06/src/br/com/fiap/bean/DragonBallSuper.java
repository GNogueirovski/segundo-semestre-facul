package br.com.fiap.bean;

import br.com.fiap.interfaces.IDBSuper;

import java.io.*;

/**
 * Classe que representa o personagem de Dragon Ball Super
 * Implementa a interface IDBSuper com os métodos de leitura e gravação de arquivos
 * @version 1.0
 * @author Gabriel Nogueira
 */
public class DragonBallSuper implements IDBSuper {
    private String nome;
    private int ki;
    private int tecnica;
    private int velocidade;
    private int transformacao;

    public DragonBallSuper() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getKi() {
        return ki;
    }

    public void setKi(int ki) {
        this.ki = ki;
    }

    public int getTecnica() {
        return tecnica;
    }

    public void setTecnica(int tecnica) {
        this.tecnica = tecnica;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getTransformacao() {
        return transformacao;
    }

    public void setTransformacao(int transformacao) {
        this.transformacao = transformacao;
    }

    /**
     * Metodo responsável pela leitura dos arquivos
     * @param path - responsável para indicar o diretorio onde esta o arquivo a ser lido
     * @return Faz o retorno de um objeto do tipo DragonBallSuper que foi lido através do BufferedReader.
     * @throws IOException - Exceção da classe IO para tratar as exceções relacionadas a arquivos.
     */

    public DragonBallSuper ler(String path) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader(path + "/" + nome + ".txt"));

        nome = br.readLine();
        ki = Integer.parseInt(br.readLine());
        tecnica = Integer.parseInt(br.readLine());
        velocidade = Integer.parseInt(br.readLine());
        transformacao = Integer.parseInt(br.readLine());
        br.close();

        return this;

    }
    /**
     * Metodo responsável pela gravação dos arquivos
     * @param path - responsável para indicar o diretorio onde será gravado o arquivo
     * @return Faz o retorno de uma String contendo se deu certo a gravação de arquivo ou se deu errado.
     */


    public String gravar(String path) {
        try {
            File dir = new File(path);
            if(!dir.exists()){
                dir.mkdir();
            }
            PrintWriter pw = new PrintWriter(path + "/" + nome + ".txt");
            pw.println(nome);
            pw.println(ki);
            pw.println(tecnica);
            pw.println(velocidade);
            pw.println(transformacao);

            pw.flush();
            pw.close();
            return "Arquivo gravado com sucesso";
        } catch (IOException e) {
            return "Falha ao gravar arquivo: " + e.getMessage();
        }
    }

}
