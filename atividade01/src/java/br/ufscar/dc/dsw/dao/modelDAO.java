package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class modelDAO {
    
    public modelDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/DBLocadora", "root", "root");
    }
}
