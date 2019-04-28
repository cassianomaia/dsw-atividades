package br.ufscar.dc.dsw.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PopulaBanco {

    public static void main(String[] args) throws ClassNotFoundException {

        try {

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            DataSource ds = JDBCUtil.getDataSource();

            Connection conn = ds.getConnection();

            String usuarioSql = "Insert into Usuario (email, cpf, nome, telefone, senha, data_nascimento, sexo, ativo)"
                    + "values (?,?,?,?,?,?,?,?)";

            String tipousuarioSql = "Insert into TipoUsuario (email, tipo)"
                    + "values (?,?)";
            
            String locadoraSql = "Insert into Locadora (nome, email, senha, cnpj, cidade)"
                    + "values (?,?,?,?,?)";
            
            String locacaoSql = "Insert into Locacao (cpf, cnpj, data, hora)"
                    + "values (?,?,?,?)";
            
            
            // Criando Usuario admin com papel ROLE_ADMIN
            PreparedStatement userStatement = conn.prepareStatement(usuarioSql);
            userStatement.setString(1, "admin@admin");
            userStatement.setString(2, "444.444.444-44");
            userStatement.setString(3, "Administrador");
            userStatement.setString(4, "16999999999");
            userStatement.setString(5, encoder.encode("admin"));
            userStatement.setString(6, "04/04/1970");
            userStatement.setString(7, "Masc");
            userStatement.setBoolean(8, true);
            userStatement.execute();

            PreparedStatement roleStatement = conn.prepareStatement(tipousuarioSql);
            roleStatement.setString(1, "admin@admin");
            roleStatement.setString(2, "ROLE_ADMIN");
            roleStatement.execute();

            // Criando Usuarios com papel ROLE_USER
            userStatement = conn.prepareStatement(usuarioSql);
            userStatement.setString(1, "user@user");
            userStatement.setString(2, "555.555.555-55");
            userStatement.setString(3, "User");
            userStatement.setString(4, "16999999999");            
            userStatement.setString(5, encoder.encode("user"));
            userStatement.setString(6, "04/04/1970");
            userStatement.setString(7, "Masc");
            userStatement.setBoolean(8, true);
            userStatement.execute();

            roleStatement = conn.prepareStatement(tipousuarioSql);
            roleStatement.setString(1, "user@user");
            roleStatement.setString(2, "ROLE_USER");
            roleStatement.execute();
            
            userStatement = conn.prepareStatement(usuarioSql);
            userStatement.setString(1, "user2@user");
            userStatement.setString(2, "666.666.666-66");
            userStatement.setString(3, "User2");
            userStatement.setString(4, "16999999999");
            userStatement.setString(5, encoder.encode("user2"));
            userStatement.setString(6, "04/04/1970");
            userStatement.setString(7, "Fem");
            userStatement.setBoolean(8, true);
            userStatement.execute();

            roleStatement = conn.prepareStatement(tipousuarioSql);
            roleStatement.setString(1, "user2@user");
            roleStatement.setString(2, "ROLE_USER");
            roleStatement.execute();
            
            roleStatement = conn.prepareStatement(locadoraSql);
            roleStatement.setString(1, "Locadora");
            roleStatement.setString(2, "locadora@locadora");
            roleStatement.setString(3, encoder.encode("locadora"));
            roleStatement.setString(4, "53.129.541/0001-80");
            roleStatement.setString(5, "São Carlos");
            roleStatement.execute();
            
            roleStatement = conn.prepareStatement(tipousuarioSql);
            roleStatement.setString(1, "locadora@locadora");
            roleStatement.setString(2, "ROLE_LOCADORA");
            roleStatement.execute();
            
            roleStatement = conn.prepareStatement(locadoraSql);
            roleStatement.setString(1, "Locadora2");
            roleStatement.setString(2, "locadora2@locadora");
            roleStatement.setString(3, encoder.encode("locadora2"));
            roleStatement.setString(4, "66.023.808/0001-00");
            roleStatement.setString(5, "São Carlos");
            roleStatement.execute();
            
            roleStatement = conn.prepareStatement(tipousuarioSql);
            roleStatement.setString(1, "locadora2@locadora");
            roleStatement.setString(2, "ROLE_LOCADORA");
            roleStatement.execute();
            
            roleStatement = conn.prepareStatement(locadoraSql);
            roleStatement.setString(1, "Locadora3");
            roleStatement.setString(2, "locadora3@locadora");
            roleStatement.setString(3, encoder.encode("locadora3"));
            roleStatement.setString(4, "59.965.771/0001-66");
            roleStatement.setString(5, "Ibaté");
            roleStatement.execute();
            
            roleStatement = conn.prepareStatement(tipousuarioSql);
            roleStatement.setString(1, "locadora3@locadora");
            roleStatement.setString(2, "ROLE_LOCADORA");
            roleStatement.execute();
            
            roleStatement = conn.prepareStatement(locacaoSql);
            roleStatement.setString(1, "444.444.444-44");
            roleStatement.setString(2, "53.129.541/0001-80");
            roleStatement.setString(3, "28/04/2019");
            roleStatement.setString(4, "14:00");
            roleStatement.execute();
            
            roleStatement = conn.prepareStatement(locacaoSql);
            roleStatement.setString(1, "444.444.444-44");
            roleStatement.setString(2, "66.023.808/0001-00");
            roleStatement.setString(3, "28/04/2019");
            roleStatement.setString(4, "16:00");
            roleStatement.execute();
            
            roleStatement = conn.prepareStatement(locacaoSql);
            roleStatement.setString(1, "555.555.555-55");
            roleStatement.setString(2, "53.129.541/0001-80");
            roleStatement.setString(3, "28/04/2019");
            roleStatement.setString(4, "14:00");
            roleStatement.execute();
            
            roleStatement = conn.prepareStatement(locacaoSql);
            roleStatement.setString(1, "666.666.666-66");
            roleStatement.setString(2, "59.965.771/0001-66");
            roleStatement.setString(3, "28/04/2019");
            roleStatement.setString(4, "14:00");
            roleStatement.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
