package Persistence.WebService;

import Model.Currency;
import Persistence.CurrencyLoader;
import java.util.List;

public class CurrencyLoaderWebService implements CurrencyLoader
{
    private final String URL;

    public CurrencyLoaderWebService(String URL) {
        this.URL = URL;
    }
    
    @Override
    public List<Currency> loadAllCurrencies() {
        return null;
    }
    
}
