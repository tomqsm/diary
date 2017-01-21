package biz.letsweb.diary.pricePicker.picker;

import biz.letsweb.diary.pricePicker.PriceDecimalFormat;
import biz.letsweb.diary.pricePicker.numberFinder.NumberFinder;
import biz.letsweb.diary.pricePicker.numberFinder.NumberFinderResponse;
import com.google.common.collect.Lists;

import java.util.List;

import lombok.ToString;

import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author toks
 */
public final class WordNumberWordPickerServiceTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(WordNumberWordPickerServiceTest.class);

    private PricePickable pricePickable;

    @Before
    public void beforeTest() {
        pricePickable = new PlnDotPickerService();
    }

    @Test
    public void testRegex() {

        PriceDecimalFormat priceDecimalFormat = new PriceDecimalFormat(',');

        String content = " c23,5 litrów paliwa za 234.00 pln nie   wiem";

        //split by space
        final String[] split = content.split("\\s+");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String found = NumberFinder
                    .findPattern("[0-9]{1,13}([\\.,][0-9]*)?", s);
            Double price;
            try {
                price = priceDecimalFormat.getDecimalFormat().parse(found).doubleValue();
            } catch (Exception ex) {
                price = null;
            }
            if (price == null) {

            } else {
                PriceContext pc = new PriceContext();
                pc.price = price;
                if (i > 0 && i < split.length) {
                    pc.beforeWord = split[i - 1];
                    pc.afterWord = split[i + 1];
                } else if (i == 0) {
                    pc.beforeWord = StringUtils.EMPTY;
                    pc.afterWord = split[2];
                } else if (i == split.length) {
                    pc.beforeWord = split[i - 1];
                    pc.afterWord = StringUtils.EMPTY;
                }
                System.out.println(pc);
            }
        }

    }

    @ToString
    class PriceContext {

        String beforeWord;
        Double price;
        String afterWord;
    }

    /**
     * Test of pickPrice method, of class PlnPickService.
     */
    @Test
    public void testPickPrice() throws Exception {
        String content = " 23,5 litrów paliwa za 234.00 pln y    yy nie   wiem";
        final String[] split = content.split("\\s+");
        for (String s : split) {
            System.out.println(s);
        }

        PricePickerResponse price = pricePickable.pickPrice(content);

        List<NumberFinderResponse> patternFinderResponses = Lists.newArrayList(NumberFinderResponse.builder()
                .found("23,5")
                .content(content)
                .build(),
                NumberFinderResponse.builder()
                        .found("234.00")
                        .content(content)
                        .build()
        );

        val expectedResponse = PricePickerResponse.builder()
                .patternFinderResponses(patternFinderResponses)
                .source(PlnDotPickerService.class)
                .build();
    }

}
