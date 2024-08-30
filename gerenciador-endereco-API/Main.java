import com.google.gson.Gson;
import java.io.IOException;
import java.util.Scanner;
import java.sql.SQLException;


public class Main {
public static void main(String[] args) throws IOException, InterruptedException {

    Scanner scan = new Scanner(System.in);

    try(var connection = Banco.connection()){

        System.out.println("Conexão bem sucedida!");

        System.out.println("\nBem vindo ao Gerenciador de Endereços");

        int j=1;
        while(j==1) {
            System.out.println("\nDigite o numero da opção que deseja: " +
                    "\n1 - Consultar CEP" +
                    "\n2 - Listar CEPs consultados" +
                    "\n3 - Sair");

            int i = Integer.parseInt(scan.nextLine());

            switch (i) {
                case 1:
                    Gson gson = new Gson();
                    ConsomeApi consome = new ConsomeApi();
                    
                    System.out.println("Digite o CEP:");
                    String cep=scan.nextLine();
                    
                    String json = consome.BuscaEndereco(cep);
                    String json2 = consome.BuscaData();

                    Endereco endereco = gson.fromJson(json, Endereco.class);
                    Data data = gson.fromJson(json2, Data.class);

                    String conteudo="Dados:"+endereco+"Data do Registro:"+data;
                    Log.log(conteudo);
                    Interacao.adicionar(endereco.getCep(), endereco.getRua(), endereco.getCidade());

                    System.out.println(conteudo);

                    break;
                case 2:
                   Interacao.exibir();
                    break;
                case 3:
                    j=0;
                    break;
            }

        }
    }catch(SQLException e){
        System.err.println("Ocorreu um erro na conexão"+e.getMessage());

    }


}

   
}

