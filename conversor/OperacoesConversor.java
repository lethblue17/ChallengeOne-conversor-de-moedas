package conversor;

import api.ExchangeRateApiClient;
import com.google.gson.JsonObject;

import java.util.Scanner;

public class OperacoesConversor {
    private static String url = "https://v6.exchangerate-api.com/v6/";
    private final ExchangeRateApiClient apiClient = new ExchangeRateApiClient(url);

    public void getActualRate() throws Exception{
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a moeda base:\n");
        var moeda = scan.next();
        try {
            JsonObject res = apiClient.getExchangeRates(moeda);
            System.out.println(res);
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro: ", e);
        }
    }


}
