package biz.letsweb.diary.pricePicker.picker;

/**
 *
 * @author toks
 */
public interface PricePickable {

    PricePickerResponse pickPrice(String content) throws PricePickerException;

}
