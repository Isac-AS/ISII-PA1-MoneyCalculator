package Persistence;

import Model.Currency;
import Model.ExchangeRate;

public interface ExchangeRateLoader {
    public ExchangeRate getRate(Currency from, Currency to);
}
