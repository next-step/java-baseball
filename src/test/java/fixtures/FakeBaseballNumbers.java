package fixtures;

import domain.BaseballNumber;
import domain.BaseballNumbers;

import java.util.Arrays;

public class FakeBaseballNumbers {
    public static final BaseballNumbers ONE_TWO_THREE =
            new BaseballNumbers(Arrays.asList(BaseballNumber.ONE, BaseballNumber.TWO, BaseballNumber.THREE));
    public static final BaseballNumbers ONE_TWO_FIVE =
            new BaseballNumbers(Arrays.asList(BaseballNumber.ONE, BaseballNumber.TWO, BaseballNumber.FIVE));
    public static final BaseballNumbers ONE_FIVE_NINE =
            new BaseballNumbers(Arrays.asList(BaseballNumber.ONE, BaseballNumber.FIVE, BaseballNumber.NINE));;
}
