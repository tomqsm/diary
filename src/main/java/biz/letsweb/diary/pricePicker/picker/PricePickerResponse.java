package biz.letsweb.diary.pricePicker.picker;

import biz.letsweb.diary.pricePicker.numberFinder.NumberFinderResponse;
import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by toks on 21.01.17.
 */
@Builder
@EqualsAndHashCode
@ToString
public class PricePickerResponse {
    private Class source;
    private List<NumberFinderResponse> patternFinderResponses;
}
