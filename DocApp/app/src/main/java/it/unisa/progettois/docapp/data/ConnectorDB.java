package it.unisa.progettois.docapp.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {
    private static final String DB_URL = "jdbc:mysql://IP:185.177.116.54/docapp";
    private static final String USER = "docappadmin";
    private static final String PASS = "K5@jnNk!DJo$tC1F";

    public ConnectorDB(){}

    public static Connection getConnection() throws SQLException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connessione avvenuta con successo");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
