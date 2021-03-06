package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Locadora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class LocadoraDAO extends GenericDAO {
    
    public LocadoraDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(Locadora locadora) {

        String sql = "INSERT INTO Locadora (nome, email, senha, cnpj, cidade) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            
            statement = conn.prepareStatement(sql);
            statement.setString(1, locadora.getNome());
            statement.setString(2, locadora.getEmail());
            statement.setString(3, encoder.encode(locadora.getSenha()));
            statement.setString(4, locadora.getCnpj());
            statement.setString(5, locadora.getCidade());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Locadora> getAll() {

        List<Locadora> listalocadoras = new ArrayList<>();

        String sql = "SELECT * FROM Locadora";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String cnpj = resultSet.getString("cnpj");
                String cidade = resultSet.getString("cidade");

                Locadora locadora = new Locadora(id, nome, email, senha, cnpj, cidade);
                listalocadoras.add(locadora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listalocadoras;
    }
    
    public List<Locadora> getCidade(String cidade) {

        List<Locadora> listalocadoras = new ArrayList<>();

        String sql = "SELECT * FROM Locadora WHERE cidade = ?";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cidade);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String cnpj = resultSet.getString("cnpj");
                String cidade_locadora = resultSet.getString("cidade");

                Locadora locadora = new Locadora(id, nome, email, senha, cnpj, cidade);
                listalocadoras.add(locadora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listalocadoras;
    }

    public void delete(Locadora locadora) {
        String sql = "DELETE FROM Locadora where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, locadora.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Locadora locadora) {
        String sql = "UPDATE Locadora SET nome = ?, email = ?, senha = ?, cnpj = ?, cidade = ?";
        sql += " WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            
            statement.setString(1, locadora.getNome());
            statement.setString(2, locadora.getEmail());
            statement.setString(3, encoder.encode(locadora.getSenha()));
            statement.setString(4, locadora.getCnpj());
            statement.setString(5, locadora.getCidade());
            statement.setInt(6, locadora.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Locadora get(int id) {
        Locadora locadora = null;
        String sql = "SELECT * FROM Locadora WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String cnpj = resultSet.getString("cnpj");
                String cidade = resultSet.getString("cidade");

                locadora = new Locadora(id, nome, email, senha, cnpj, cidade);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return locadora;
    }
}
