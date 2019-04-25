/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Locacao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author catit
 */
public class LocacaoDAO extends GenericDAO {
    
    public LocacaoDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void insert(Locacao locacao) {

        String sql = "INSERT INTO Locacao (cpf, cnpj, data) VALUES (?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, locacao.getCpf());
            statement.setString(2, locacao.getCnpj());
            statement.setDate(3, locacao.getData());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Locacao> getAll() {

        List<Locacao> listalocacao = new ArrayList<>();

        String sql = "SELECT * FROM Locacao";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String cnpj = resultSet.getString("cnpj");
                Date data = resultSet.getDate("data");

                Locacao locacao = new Locacao(cpf, cnpj, data);
                listalocacao.add(locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listalocacao;
    }
    
    public void delete(Locacao locacao) {
        String sql = "DELETE FROM Locacao where cpf = ? and cnpj = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, locacao.getCpf());
            statement.setString(2, locacao.getCnpj());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Locacao get(String cpf, String cnpj) {
        Locacao locacao = null;
        String sql = "SELECT * FROM Locadora WHERE cpf = ? and cnpj = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, cpf);
            statement.setString(2, cnpj);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String cpf_recebido = resultSet.getString("cpf");
                String cnpj_recebido = resultSet.getString("cnpj");
                Date data = resultSet.getDate("data");

                locacao = new Locacao(cpf_recebido, cnpj_recebido, data);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locacao;
    }
}
