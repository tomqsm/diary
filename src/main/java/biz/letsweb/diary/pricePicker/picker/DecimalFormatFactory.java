package biz.letsweb.diary.pricePicker.picker;

import biz.letsweb.diary.config.Configuration;
import biz.letsweb.diary.pricePicker.PriceDecimalFormat;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * @author toks
 */
public class DecimalFormatFactory {
    private static final char COMA = ',';
    private static final char DOT = '.';

    public DecimalFormat getDecimalFormat(Configuration configuration) {
        final DecimalFormat decimalFormat = new DecimalFormat();
        final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        final String separator = configuration.DECIMAL_SEPARATOR.toString();
        if (separator.charAt(0) == COMA) {
            symbols.setDecimalSeparator(COMA);
        } else if (separator.charAt(0) == DOT) {
            symbols.setDecimalSeparator(DOT);
        }
        decimalFormat.setDecimalFormatSymbols(symbols);
        return decimalFormat;
    }
}
