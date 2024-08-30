import com.google.gson.annotations.SerializedName;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
public class Data {


    @SerializedName("datetime")
    public String data;



    @Override
    public String toString() {
        return "Data e Hora:"+ data;
    }
}
