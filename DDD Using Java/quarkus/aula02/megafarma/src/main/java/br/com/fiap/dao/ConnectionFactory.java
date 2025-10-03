package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;


    public static void closeConnection (){
        try{
            if(!connection.isClosed()){
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("Erro: "+  e.getMessage());
        }

    }

    public static Connection getConnection(){
        try{
            if (connection != null && !connection.isClosed()){
                return connection;
            }
            // acessa os pacotes oracle -> jdbc -> driver e acessa o oracle driver como class forname
        Class.forName("oracle.jdbc.driver.OracleDriver");
            // acessa api de conexão com banco -> modelo oracle -> modelo do banco -> localhost do banco -> porta -> orcl
            String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
            String user = "rm563925";
            String password = "070602";
            connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro Nome da Classe: " + e.getMessage());
        }
        return connection;

    }
}
