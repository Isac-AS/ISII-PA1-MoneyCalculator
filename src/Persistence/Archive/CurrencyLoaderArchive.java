package Persistence.Archive;

import Model.Currency;
import Persistence.CurrencyLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CurrencyLoaderArchive implements CurrencyLoader{

    private final String FilePathname;

    public CurrencyLoaderArchive(String FilePathname) {
        this.FilePathname = FilePathname;
    }
    
    @Override
    public List<Currency> loadAllCurrencies() {
        List<Currency> listCurrencies = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(this.FilePathname)));
            while (true) {
                String lineText = reader.readLine();
                if (lineText == null) break;
                listCurrencies.add(currencyOf(lineText));
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR CurrencyLoaderArchive::loadAllCurrencies FileNotFoundException" +
                    ex.getMessage());
        } catch (IOException ex) {
            System.out.println("ERROR CurrencyLoaderArchive::loadAllCurrencies IOException" + ex.getMessage());
        }
        
        return listCurrencies;
    }

    private Currency currencyOf(String lineText) {
        String[] splitLine = lineText.split(",");
        return new Currency(splitLine[0], splitLine[1], splitLine[2]);
    }
    
}
