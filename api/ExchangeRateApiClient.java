package api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ExchangeRateApiClient {

    private final String baseUrl;
    private final String apiKey;
    private final HttpClient httpClient;

    private final Gson gson;

    // Constructor
    public ExchangeRateApiClient(String baseUrl) {
        Dotenv dotenv = Dotenv.load();
        this.baseUrl = baseUrl;
        this.apiKey = dotenv.get("API_KEY");
        System.out.println(apiKey);
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public JsonObject getExchangeRates(String baseCurrency) throws Exception {
        String endpoint = String.format("/latest/%s", baseCurrency);
        URI uri = URI.create(baseUrl + apiKey + endpoint);
        System.out.println(uri);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Conexão falhou com seguinte erro: " + response.statusCode());
        }

        try {
            return gson.fromJson(response.body(), JsonObject.class);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException("Falha ao processar json: ", e);
        }
    }
}