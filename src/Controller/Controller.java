package Controller;

import Model.*;
import View.DialogSwing;
import Persistence.Archive.ExchangeRateArchive;

public class Controller {

    DialogSwing dialog;
    ExchangeRateArchive exchangeRateArchive;

    
    public Controller(ExchangeRateArchive exchangeRateArchive) {
        this.exchangeRateArchive = exchangeRateArchive;
    }
    
    public Controller(DialogSwing dialog, ExchangeRateArchive exchangeRateArchive) {
        this.dialog = dialog;
        this.exchangeRateArchive = exchangeRateArchive;
    }

    public void setDialog(DialogSwing dialog) {
        this.dialog = dialog;
    }
    
    public void trigger() {
        Money money=dialog.getMoney();
        Currency from=dialog.getCurrencyFrom();
        Currency to=dialog.getCurrencyTo();
        ExchangeRate rate=exchangeRateArchive.getRate(from, to);
        
        dialog.display(this.convertedResult(money, rate));
    }
    
    private Money convertedResult(Money money, ExchangeRate rate) {
        return new Money(money.getAmount()*rate.getRate(), rate.getTo());
    }
}
