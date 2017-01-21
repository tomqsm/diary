package biz.letsweb.diary.pricePicker.picker;

import biz.letsweb.diary.pricePicker.numberFinder.NumberFinder;
import biz.letsweb.diary.pricePicker.numberFinder.NumberFinderResponse;
import biz.letsweb.diary.pricePicker.picker.PricePickable;
import biz.letsweb.diary.pricePicker.picker.PricePickerResponse;
import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;
import java.util.List;
import lombok.Lombok;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;

/**
 *
 * @author toks
 */
public class PlnDotPickerService implements PricePickable {

    public static final Logger LOGGER = LoggerFactory.getLogger(PlnDotPickerService.class);
    public static String DOUBLE_PATTERN = "[0-9]{1,13}(\\.[0-9]*)?";
    public static String DOUBLE_PATTERN_WITH_WORDS = "[0-9]{1,13}(\\.[0-9]*)?";

    @Override
    public PricePickerResponse pickPrice(@Nullable  String content) {

        Lombok.checkNotNull(content, "Content cannot be null.");


        return null;
    }

    Predicate<List<NumberFinderResponse>> pr = new Predicate<List<NumberFinderResponse>>() {
        @Override
        public boolean apply(@Nullable List<NumberFinderResponse> patternFinderResponses) {
            return false;
        }
    };

    

}
