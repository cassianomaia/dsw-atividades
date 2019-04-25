package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends modelDAO {

    public UsuarioDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(Usuario usuario) {

        String sql = "INSERT INTO Usuario (email, cpf, nome, telefone, senha, sexo, ativo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getCpf());
            statement.setString(3, usuario.getNome());
            statement.setInt(4, usuario.getTelefone());
            statement.setString(5, usuario.getSenha());
            statement.setString(6, usuario.getSexo());
            statement.setBoolean(7, usuario.getAtivo());
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
                Integer telefone = resultSet.getInt("telefone");
                String senha = resultSet.getString("senha");
                String sexo = resultSet.getString("sexo");
                boolean ativo = resultSet.getBoolean("ativo");

                Usuario usuario = new Usuario(id, email, cpf, nome, telefone, senha, sexo, ativo);
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
        String sql = "UPDATE Usuario SET email = ?, cpf = ?, nome = ?, telefone = ?, senha = ?, sexo = ?, ativo = ?";
        sql += " WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, usuario.getEmail());
            statement.setString(2, usuario.getCpf());
            statement.setString(3, usuario.getNome());
            statement.setInt(4, usuario.getTelefone());
            statement.setString(5, usuario.getSenha());
            statement.setString(6, usuario.getSexo());
            statement.setBoolean(7, usuario.getAtivo());
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
                Integer telefone = resultSet.getInt("telefone");
                String senha = resultSet.getString("senha");
                String sexo = resultSet.getString("sexo");
                boolean ativo = resultSet.getBoolean("ativo");

                usuario = new Usuario(email, cpf, nome, telefone, senha, sexo, ativo);
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
