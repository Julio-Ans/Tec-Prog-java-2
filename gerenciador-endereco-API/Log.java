import java.io.FileWriter;
import java.io.IOException;

public class Log {

    public static void log(String conteudo) throws IOException {
        FileWriter escrita = new FileWriter("log.txt");
        escrita.write(conteudo+"\n");
        escrita.close();
        System.out.println("Log salvo com sucesso!");
    }


}
