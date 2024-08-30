import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Interacao {


    public static void adicionar(String cep, String rua, String cidade) {
        Scanner scan = new Scanner(System.in);
        try (var connection = Banco.connection()) {
            System.out.println("Conexão bem sucedida!");

            String query = "INSERT INTO endereco(cep, rua, cidade) VALUES (?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, cep);

            stmt.setString(2,rua);

            stmt.setString(3, cidade);

            if(!stmt.execute()){
                System.out.println("O endereço foi inserido com sucesso!");

            }else {
                System.out.println("Erro na inverção do endereço");
            }
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro na conexão" + e.getMessage());

        }
    }

    public static void exibir() {
        Scanner scan = new Scanner(System.in);
        try (var connection = Banco.connection()) {

            String query = "SELECT * FROM endereco";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();




                while(rs.next()){

                    System.out.println("Cep: "+rs.getString("cep")+" Rua: "+rs.getString("rua")+" Status: "+rs.getString("cidade")+" Cidade: "+rs.getString("cidade"));
                }




        } catch (SQLException e) {
            System.err.println("Ocorreu um erro na conexão" + e.getMessage());
        }
    }

}
