package View;

import Model.Currency;
import Model.Money;

public interface Dialog {
    public Money getMoney();
    public Currency getCurrencyTo();
    public Currency getCurrencyFrom();
}
