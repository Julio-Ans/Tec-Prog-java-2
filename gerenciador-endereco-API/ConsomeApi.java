import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsomeApi {

    public String BuscaEndereco(String cep) throws IOException, InterruptedException {
        String url_cep="http://viacep.com.br/ws/"+cep+"/json/";

        //Client, Request, Response
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url_cep)).build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    return response.body();
    }

    public String BuscaData() throws IOException, InterruptedException {
        String url_data="https://worldtimeapi.org/api/timezone/America/Sao_Paulo";

        //Client, Request, Response
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url_data)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());



    return response.body();
    }

    }

