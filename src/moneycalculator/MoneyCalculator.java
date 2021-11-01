package moneycalculator;

import Controller.Controller;
import Persistence.Archive.CurrencyLoaderArchive;
import Persistence.Archive.ExchangeRateArchive;
import Persistence.CurrencyLoader;
import View.DialogSwing;

public class MoneyCalculator {

    public static void main(String[] args) {
        CurrencyLoader currencyLoader = new CurrencyLoaderArchive("currencies.csv");
        ExchangeRateArchive exchangeRateArchive = new ExchangeRateArchive("exchangeRates.csv");
        Controller controller = new Controller(exchangeRateArchive);
        DialogSwing dialog = new DialogSwing(currencyLoader.loadAllCurrencies(), controller);
        controller.setDialog(dialog);
        dialog.setVisible(true);
    }
    
}
