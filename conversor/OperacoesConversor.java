package conversor;

import api.ExchangeRateApiClient;
import api.ExchangeResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperacoesConversor {
    private Gson gson = new Gson();
    private static String url = "https://v6.exchangerate-api.com/v6/";
    private final ExchangeRateApiClient apiClient = new ExchangeRateApiClient(url);

    public void getActualRate() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a moeda base:\n");
        var moeda = scan.next();
        try {
            JsonObject res = apiClient.getExchangeRates(moeda);
            ExchangeResponse response = gson.fromJson(res, ExchangeResponse.class);
            response.getConversion_rates().forEach((key, value) ->
                    System.out.println("País: " + key + " | taxa: " + value));
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro: ", e);
        }
    }

    public void convertFromUSAToBRA() throws Exception {
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

    public void convertFromEURToBRA() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o valor a ser convertido:");
        var moeda = scan.next();
        List<String> currencies = new ArrayList<String>();
        currencies.add("EUR");
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

    public void convertFromBRLToJPY() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o valor a ser convertido:");
        var moeda = scan.next();
        List<String> currencies = new ArrayList<String>();
        currencies.add("BRL");
        currencies.add("JPY");
        try {
            JsonObject res = apiClient.pairConversion(moeda, currencies);
            ExchangeResponse response = gson.fromJson(res, ExchangeResponse.class);
            System.out.println("Taxa de câmbio utilizada: " + response.getConversion_rate());
            System.out.println("Resultado da conversão em reais: R$" + response.getConversion_result() + "\n");
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro: ", e);
        }
    }

    public void convertFromJPYToCNY() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o valor a ser convertido:");
        var moeda = scan.next();
        List<String> currencies = new ArrayList<String>();
        currencies.add("JPY");
        currencies.add("CNY");
        try {
            JsonObject res = apiClient.pairConversion(moeda, currencies);
            ExchangeResponse response = gson.fromJson(res, ExchangeResponse.class);
            System.out.println("Taxa de câmbio utilizada: " + response.getConversion_rate());
            System.out.println("Resultado da conversão em reais: R$" + response.getConversion_result() + "\n");
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro: ", e);
        }
    }

    public void supportedCodes() throws Exception {
        try {
            JsonObject res = apiClient.getSupportedCodes();
            ExchangeResponse response = gson.fromJson(res, ExchangeResponse.class);
            for(List<String> code : response.getSupported_codes()) {
                System.out.println("Código: " + code.getFirst() + " | País: " + code.getLast());
            }
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro: ", e);
        }
    }



}
