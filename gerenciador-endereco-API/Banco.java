
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
    public static Connection connection(){
        try {
            var jdbcUrl = "jdbc:postgresql://localhost:5432/db_fatec";
            var user = "fatec";
            var password = "fatec777";
            return DriverManager.getConnection(jdbcUrl, user, password);
        }catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }

       /* CRIE ESTA TABELA NO BANCO e divirta-se
       CREATE TABLE Endereco (
                id SERIAL PRIMARY KEY,
                cep VARCHAR(25),
                rua VARCHAR(155),
                cidade varchar(25))*/
    }}
