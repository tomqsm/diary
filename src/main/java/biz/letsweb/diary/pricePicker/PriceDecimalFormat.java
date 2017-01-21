package biz.letsweb.diary.pricePicker;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author toks
 */
public class PriceDecimalFormat {

    private final DecimalFormat decimalFormat;

    public PriceDecimalFormat(char decimalSeparator) {
        decimalFormat = new DecimalFormat();
        configureDecimalFormat(decimalFormat, decimalSeparator);
    }
    
    private void configureDecimalFormat(DecimalFormat decimalFormat, char decimalSeparator){
        final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(decimalSeparator);
        symbols.setGroupingSeparator(' ');
        decimalFormat.setDecimalFormatSymbols(symbols);
    }

    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }


    
}
