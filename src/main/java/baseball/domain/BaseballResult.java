package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class BaseballResult {
    private final Map<BaseballEnum, Integer> baseballCounts;
    private final int ZERO = 0;

    public BaseballResult(final Map<BaseballEnum, Integer> baseballCounts) {
        this.baseballCounts = baseballCounts;
    }

    public static BaseballResult getResult(final Numbers randomNumbers, final Numbers userNumbers) {
        final Map<BaseballEnum, Integer> map = new HashMap();
        final BaseballEnum[] enumValues = BaseballEnum.values();
        for (BaseballEnum baseballEnum : enumValues) {
            map.put(baseballEnum, baseballEnum.getCount(randomNumbers, userNumbers));
        }
        return new BaseballResult(map);
    }

    public boolean isNothing() {
        return baseballCounts.get(BaseballEnum.STRIKE) == ZERO && baseballCounts.get(BaseballEnum.BALL) == ZERO;
    }

    public Map<BaseballEnum, Integer> getBaseballCounts() {
        return baseballCounts;
    }

}
