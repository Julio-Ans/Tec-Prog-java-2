import com.google.gson.annotations.SerializedName;

public class Endereco {
    public String cep;

    @SerializedName("logradouro")
    public String rua;

    @SerializedName("localidade")
    public String cidade;

    @Override
    public String toString() {
        return "Endereco \n" +
                "CEP: " + cep + "\n" +
                "RUA: " + rua + "\n" +
                "CIDADE: " + cidade + "\n";
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getCidade() {
        return cidade;
    }

}