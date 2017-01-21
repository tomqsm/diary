package biz.letsweb.diary.pricePicker.numberFinder;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by toks on 22.01.17.
 */
@Builder
@EqualsAndHashCode
@ToString
@Getter
public class NumberFinderResponse {

    private String content;
    private String found;
    
}
