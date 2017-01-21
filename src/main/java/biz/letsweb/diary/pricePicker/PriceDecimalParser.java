package biz.letsweb.diary.pricePicker;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 *
 * @author toks
 */
public class PriceDecimalParser {
    
    DecimalFormat decimalFormat;

    public PriceDecimalParser(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }
    

    public Double parse(String string) {
        Double result = null;
        try {
            decimalFormat.parse(string);
        } catch (ParseException ex) {
            //ignore
        }
        return result;
    }

    
}
