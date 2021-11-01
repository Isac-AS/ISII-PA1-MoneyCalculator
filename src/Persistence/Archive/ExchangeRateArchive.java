package Persistence.Archive;

import Model.Currency;
import Model.ExchangeRate;
import Persistence.ExchangeRateLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExchangeRateArchive implements ExchangeRateLoader{

    private final String FilePathname;

    public ExchangeRateArchive(String FilePathname) {
        this.FilePathname = FilePathname;
    }
    
    @Override
    public ExchangeRate getRate(Currency from, Currency to) {
        
        try {
            double fromToEuro = 0;
            double toToEuro = 0;
            
            BufferedReader reader = new BufferedReader(new FileReader(new File(this.FilePathname)));
            while (true) {
                String lineText = reader.readLine();
                if (lineText == null) break;
                String[] splitLine = lineText.split(",");
                if (splitLine[0].equals(from.getCode())) {
                    fromToEuro=Double.parseDouble(splitLine[2]);
                }
                if (splitLine[0].equals(to.getCode())) {
                    toToEuro=Double.parseDouble(splitLine[2]);
                }
            }
            double rate = toToEuro/fromToEuro;
            return new ExchangeRate(rate, from, to);
            
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR CurrencyLoaderArchive::loadAllCurrencies FileNotFoundException" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("ERROR CurrencyLoaderArchive::loadAllCurrencies IOException" + ex.getMessage());
        }
        
        
        return null;
    }
    
}
