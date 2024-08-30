import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Interacao {


    public static void inserir() {
        Scanner scan = new Scanner(System.in);
        try (var connection = Banco.connection()) {
            System.out.println("Conexão bem sucedida!");

            String query = "INSERT INTO tarefa(nome, ds_conteudo, status, categoria) VALUES (?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query);

            System.out.println("Digite o nome da tarefa");
            stmt.setString(1, scan.nextLine());

            System.out.println("Digite a descrição da tarefa");
            stmt.setString(2, scan.nextLine());

            System.out.println("Digite a categoria da tarefa");
            stmt.setString(4, scan.nextLine());

            System.out.println("Qual o status da tarefa?");
            stmt.setString(3, scan.nextLine());

            if(!stmt.execute()){
                System.out.println("A Tarefa foi inserida com sucesso!");

            }else {
                System.out.println("Não existe tarefa com esse nome");
            }
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro na conexão" + e.getMessage());

        }
    }

    public static void excluir() {
        Scanner scan = new Scanner(System.in);
        try (var connection = Banco.connection()) {

            String query = "DELETE FROM tarefa WHERE nome = ?";
            PreparedStatement stmt = connection.prepareStatement(query);

            System.out.println("Digite o nome da tarefa para excluir:");
            stmt.setString(1, scan.nextLine());

            if (!stmt.execute()) {
                System.out.println("A Tarefa foi excluída com sucesso!");

            } else {
                System.out.println("Não existe tarefa com esse nome");
            }
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro na conexão" + e.getMessage());
    }
    }

    public static void editar(){
        Scanner scan = new Scanner(System.in);
        try (var connection = Banco.connection()) {

            String query = "UPDATE tarefa SET nome = ?, ds_conteudo = ?, status = ?, categoria = ? WHERE nome = ?";

            PreparedStatement stmt = connection.prepareStatement(query);

            System.out.println("Digite o nome da tarefa para editar:");
            stmt.setString(5, scan.nextLine());

            System.out.println("Qual o novo nome da tarefa:");
            stmt.setString(1, scan.nextLine());

            System.out.println("Qual a nova descrição da tarefa:");
            stmt.setString(2, scan.nextLine());

            System.out.println("Qual o novo status da tarefa:");
            stmt.setString(3, scan.nextLine());

            System.out.println("Qual a nova categoria da tarefa:");
            stmt.setString(4, scan.nextLine());

            if (!stmt.execute()) {
                System.out.println("A Tarefa foi editada com sucesso!");

            } else {
                System.out.println("Não existe tarefa com esse nome");
            }
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro na conexão" + e.getMessage());
        }
    }




    public static void exibir() {
        Scanner scan = new Scanner(System.in);
        try (var connection = Banco.connection()) {

            String query = "SELECT * FROM tarefa";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Digita 1 para exibir todos e 2 para exibir por categoria:");
            int opci = scan.nextInt();

            if(opci==1){
                while(rs.next()){

                    System.out.println("Nome: "+rs.getString("nome")+" Descrição: "+rs.getString("ds_conteudo")+" Status: "+rs.getString("status")+" Categoria: "+rs.getString("categoria"));
                }

            }else if(opci==2){
                scan.nextLine();
                System.out.println("Digite a categoria que deseja exibir:");
                String categ = scan.nextLine();

                while(rs.next()){
                    String categ2=rs.getString("categoria");
                    if (categ.equals(categ2)){
                  System.out.println("Nome: "+rs.getString("nome")+" Descrição: "+rs.getString("ds_conteudo")+"Status: "+rs.getString("status")+" Categoria: "+rs.getString("categoria"));
                        }
                    }

                /* Mais eficiente  com query especifica por linha que cumpra a condição de filtro
                else if(opci==2){
                scan.nextLine();

                String query = "SELECT * FROM tarefa WHERE categoria = ?";
                PreparedStatement stmt = connection.prepareStatement(query);

                System.out.println("Digite a categoria que deseja exibir:");
                stmt.setString(1, scan.nextLine());
                ResultSet rs = stmt.executeQuery();

                while(rs.next()){
                  System.out.println("Nome: "+rs.getString("nome")+" Descrição: "+rs.getString("ds_conteudo")+"Status: "+rs.getString("status")+" Categoria: "+rs.getString("categoria"));

                    }
                        */



            } else{
                System.out.println("Digite uma opção válida");
            }



        } catch (SQLException e) {
            System.err.println("Ocorreu um erro na conexão" + e.getMessage());
        }
    }

}
