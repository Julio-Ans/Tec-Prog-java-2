
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try(var connection = Banco.connection()){

            System.out.println("Conexão bem sucedida!");

            System.out.println("\nBem vindo ao Gerenciador de Tarefa");

            int j=1;
            while(j==1) {
                System.out.println("\nDigite o numero da opção que deseja: " +
                        "\n1 - Criar Tarefa " +
                        "\n2 - Excluir Tarefa " +
                        "\n3 - Editar Tarefa " +
                        "\n4 - Exibir Tarefa "+
                        "\n5 - Sair do Programa ");

                int i = Integer.parseInt(scan.nextLine());

                switch (i) {
                    case 1:
                        Interacao.inserir();
                        break;
                    case 2:
                        Interacao.excluir();
                        break;
                    case 3:
                        Interacao.editar();
                        break;
                    case 4:
                        Interacao.exibir();
                        break;
                    case 5:
                        j=0;
                        break;


                }
            }
        }catch(SQLException e){
            System.err.println("Ocorreu um erro na conexão"+e.getMessage());

        }



    }}
