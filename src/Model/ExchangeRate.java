package Model;

public class ExchangeRate {

    private final double rate;
    private final Currency from;
    private final Currency to;

    public ExchangeRate(double rate, Currency from, Currency to) {
        this.rate = rate;
        this.from = from;
        this.to = to;
    }

    public double getRate() {
        return rate;
    }

    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

}
