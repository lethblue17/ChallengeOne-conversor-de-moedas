package api;

import java.util.List;
import java.util.Map;

public class ExchangeResponse {

    private List<List<String>> supported_codes;
    private double conversion_rate;

    private Map<String, Double> conversion_rates;
    private double conversion_result;

    public double getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    public void setConversion_result(double conversion_result) {
        this.conversion_result = conversion_result;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public List<List<String>> getSupported_codes() {
        return supported_codes;
    }

    public void setSupported_codes(List<List<String>> supported_codes) {
        this.supported_codes = supported_codes;
    }
}
