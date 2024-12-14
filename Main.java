import api.ExchangeRateApiClient;
import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;
import menu.MenuConversor;

public class Main {

    public static void main(String[] args) {
        MenuConversor menu = new MenuConversor();
        menu.run();
    }
}
