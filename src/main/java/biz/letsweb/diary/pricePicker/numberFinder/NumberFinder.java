package biz.letsweb.diary.pricePicker.numberFinder;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.regex.Pattern;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author toks
 */
public class NumberFinder {

    public static final Logger LOGGER = LoggerFactory.getLogger(NumberFinder.class);

    public static String findPattern(String pattern, String content) {
        val p = Pattern.compile(pattern);
        val matcher = p.matcher(content);
        String response = null;
        while (matcher.find()) {
            response = matcher.group();
            LOGGER.debug("{}", response);
        }
        return response;
    }
}
