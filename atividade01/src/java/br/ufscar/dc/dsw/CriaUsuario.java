
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriaUsuario {

    public static void main(String[] args) throws ClassNotFoundException {

        try {

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            DataSource ds = JDBCUtil.getDataSource();

            Connection conn = ds.getConnection();

            String userSql = "Insert into Usuario (email, cpf, nome, telefone, senha, sexo, ativo)"
                    + "values (?,?,?,?,?,?,?)";

            String roleSql = "Insert into TipoUsuario (email, tipo)"
                    + "values (?,?)";

            // Criando Usuario admin com papel ROLE_ADMIN
            PreparedStatement userStatement = conn.prepareStatement(userSql);
            userStatement.setString(1, "admin@admin");
            userStatement.setString(2, "2131321");
            userStatement.setString(3, "rodrigo");
            userStatement.setString(4, "2131321");
            userStatement.setString(5, encoder.encode("admin"));
            userStatement.setString(6, "M");
            userStatement.setBoolean(7, true);
            userStatement.execute();

            PreparedStatement roleStatement = conn.prepareStatement(roleSql);
            roleStatement.setString(1, "admin@admin");
            roleStatement.setString(2, "ROLE_ADMIN");
            roleStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
