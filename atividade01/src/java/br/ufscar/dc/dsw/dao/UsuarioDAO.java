package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioDAO extends GenericDAO {

    public UsuarioDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(Usuario usuario) {

        String sql = "INSERT INTO Usuario (email, cpf, nome, telefone, senha, data_nascimento, sexo, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            
            statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getCpf());
            statement.setString(3, usuario.getNome());
            statement.setString(4, usuario.getTelefone());
            statement.setString(5, encoder.encode(usuario.getSenha()));
            statement.setString(6, usuario.getDataNasc());
            statement.setString(7, usuario.getSexo());
            statement.setInt(8, usuario.getAtivo());
            statement.executeUpdate();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Usuario> getAll() {

        List<Usuario> listausuarios = new ArrayList<>();

        String sql = "SELECT * FROM Usuario";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String senha = resultSet.getString("senha");
                String data_nascimento = resultSet.getString("data_nascimento");
                String sexo = resultSet.getString("sexo");
                int ativo = resultSet.getInt("ativo");

                Usuario usuario = new Usuario(id, email, cpf, nome, telefone, senha, data_nascimento, sexo, ativo);
                listausuarios.add(usuario);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listausuarios;
    }

    public void delete(Usuario usuario) {
        String sql = "DELETE FROM Usuario where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, usuario.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Usuario usuario) {
        String sql = "UPDATE Usuario SET email = ?, cpf = ?, nome = ?, telefone = ?, senha = ?, data_nascimento = ?, sexo = ?, ativo = ?";
        sql += " WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getCpf());
            statement.setString(3, usuario.getNome());
            statement.setString(4, usuario.getTelefone());
            statement.setString(5, encoder.encode(usuario.getSenha()));
            statement.setString(6, usuario.getDataNasc());
            statement.setString(7, usuario.getSexo());
            statement.setInt(8, usuario.getAtivo());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario get(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String senha = resultSet.getString("senha");
                String data_nascimento = resultSet.getString("data_nascimento");
                String sexo = resultSet.getString("sexo");
                int ativo = resultSet.getInt("ativo");

                usuario = new Usuario(email, cpf, nome, telefone, senha, data_nascimento, sexo, ativo);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
    
    public Usuario getEmail(String email) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE email = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                String senha = resultSet.getString("senha");
                String data_nascimento = resultSet.getString("data_nascimento");
                String sexo = resultSet.getString("sexo");
                int ativo = resultSet.getInt("ativo");

                usuario = new Usuario(id, email, cpf, nome, telefone, senha, data_nascimento, sexo, ativo);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

}
