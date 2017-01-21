package biz.letsweb.diary.pricePicker;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author toks
 */
public class DotDecimalFormat {

    private final DecimalFormat decimalFormat;

    public DotDecimalFormat() {
        decimalFormat = new DecimalFormat();
        configureDecimalFormat(decimalFormat);
    }
    
    private void configureDecimalFormat(DecimalFormat decimalFormat){
        final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator(' ');
        decimalFormat.setDecimalFormatSymbols(symbols);
    }

    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }
    
    
    
}
