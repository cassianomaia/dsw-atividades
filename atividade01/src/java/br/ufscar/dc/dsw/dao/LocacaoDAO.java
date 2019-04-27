/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Locacao;
import java.sql.Connection;
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

        String sql = "INSERT INTO Locacao (cpf, cnpj, data, hora) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, locacao.getCpf());
            statement.setString(2, locacao.getCnpj());
            statement.setString(3, locacao.getData());
            statement.setString(4, locacao.getHora());
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
                int id = resultSet.getInt("id");
                String cpf = resultSet.getString("cpf");
                String cnpj = resultSet.getString("cnpj");
                String data = resultSet.getString("data");
                String hora = resultSet.getString("hora");

                Locacao locacao = new Locacao(id, cpf, cnpj, data, hora);
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
        String sql = "DELETE FROM Locacao where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, locacao.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Locacao get(Integer id) {
        Locacao locacao = null;
        String sql = "SELECT * FROM Locadora WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String cpf_recebido = resultSet.getString("cpf");
                String cnpj_recebido = resultSet.getString("cnpj");
                String data = resultSet.getString("data");
                String hora = resultSet.getString("hora");

                locacao = new Locacao(cpf_recebido, cnpj_recebido, data, hora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locacao;
    }
    
        public void update(Locacao locacao) {
        String sql = "UPDATE Locacao SET cpf = ?, cnpj = ?, data = ?, hora = ?";
        sql += " WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, locacao.getCpf());
            statement.setString(2, locacao.getCnpj());
            statement.setString(3, locacao.getData());
            statement.setString(4, locacao.getHora());
            statement.setInt(5, locacao.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
