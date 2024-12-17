package conversor;

import api.ExchangeRateApiClient;
import api.ExchangeResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
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

    public void convertFromUSAToBRA() throws Exception{
        Gson gson = new Gson();
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o valor a ser convertido:");
        var moeda = scan.next();
        List<String> currencies = new ArrayList<String>();
        currencies.add("USD");
        currencies.add("BRL");
        try {
            JsonObject res = apiClient.pairConversion(moeda, currencies);
            ExchangeResponse response = gson.fromJson(res, ExchangeResponse.class);
            System.out.println("Taxa de câmbio utilizada: " + response.getConversion_rate());
            System.out.println("Resultado da conversão em reais: R$" + response.getConversion_result() + "\n");
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro: ", e);
        }
    }


}
