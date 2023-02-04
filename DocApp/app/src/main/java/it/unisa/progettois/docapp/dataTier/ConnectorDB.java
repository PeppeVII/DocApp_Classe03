package it.unisa.progettois.docapp.dataTier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {
    private String url = "jdbc:mysql://IP:185.177.116.54/docapp";
    private String user = "docappadmin";
    private String password = "K5@jnNk!DJo$tC1F";

    public ConnectorDB(){
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione avvenuta con successo");

        }catch(SQLException exception){
            System.out.println("Collegamento al db fallito");
        }
    }
}
