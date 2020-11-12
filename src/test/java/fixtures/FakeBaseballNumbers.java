package fixtures;

import domain.BaseballNumber;
import domain.BaseballNumbers;

import java.util.Arrays;

public class FakeBaseballNumbers {
    public static final BaseballNumbers ONE_TWO_THREE =
            new BaseballNumbers(Arrays.asList(BaseballNumber.ONE, BaseballNumber.TWO, BaseballNumber.THREE));
    public static final BaseballNumbers ONE_THREE_TWO =
            new BaseballNumbers(Arrays.asList(BaseballNumber.ONE, BaseballNumber.THREE, BaseballNumber.TWO));
    public static final BaseballNumbers ONE_TWO_FIVE =
            new BaseballNumbers(Arrays.asList(BaseballNumber.ONE, BaseballNumber.TWO, BaseballNumber.FIVE));
    public static final BaseballNumbers ONE_FIVE_NINE =
            new BaseballNumbers(Arrays.asList(BaseballNumber.ONE, BaseballNumber.FIVE, BaseballNumber.NINE));
    public static final BaseballNumbers ONE_NINE_FIVE =
            new BaseballNumbers(Arrays.asList(BaseballNumber.ONE, BaseballNumber.NINE, BaseballNumber.FIVE));
    public static final BaseballNumbers FOUR_FIVE_SIX =
            new BaseballNumbers(Arrays.asList(BaseballNumber.FOUR, BaseballNumber.FIVE, BaseballNumber.SIX));
}
