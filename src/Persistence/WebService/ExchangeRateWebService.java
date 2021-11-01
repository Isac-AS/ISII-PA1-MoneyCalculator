package Persistence.WebService;

import Model.Currency;
import Model.ExchangeRate;
import Persistence.ExchangeRateLoader;

public class ExchangeRateWebService implements ExchangeRateLoader {

    private final String URL;

    public ExchangeRateWebService(String URL) {
        this.URL = URL;
    }
    
    @Override
    public ExchangeRate getRate(Currency from, Currency to) {
        return null;
    }
    
}
