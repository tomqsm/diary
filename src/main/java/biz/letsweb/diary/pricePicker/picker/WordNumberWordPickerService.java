package biz.letsweb.diary.pricePicker.picker;

import biz.letsweb.diary.pricePicker.numberFinder.NumberFinder;
import biz.letsweb.diary.pricePicker.numberFinder.NumberFinderResponse;
import com.google.common.base.Predicate;
import lombok.Lombok;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.util.List;

/**
 *
 * @author toks
 */
public class WordNumberWordPickerService implements PricePickable {

    public static final Logger LOGGER = LoggerFactory.getLogger(WordNumberWordPickerService.class);
    public static String DOUBLE_PATTERN_WITH_WORDS = "\\p{Nd}+([[:WB=MB:][:WB=MN:]]\\p{Nd}+)?";
    //maybe better approach will be to replace all spaces with , and load it all in array
    // then check for digits in the item
    public static String REPLACE_SPACES = "\\s";
//    public static String DOUBLE_PATTERN_WITH_WORDS = "[0-9]{1,13}(\\.[0-9]*)?";

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
