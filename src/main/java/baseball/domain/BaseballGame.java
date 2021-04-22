package baseball.domain;

import baseball.domain.count.Ball;
import baseball.domain.count.Out;
import baseball.domain.count.Strike;

import java.util.EnumMap;

public class BaseballGame {
    private final Numbers randomNumbers;
    private final Numbers userNumbers;

    public BaseballGame(Numbers randomNumbers, Numbers userNumbers) {
        this.randomNumbers = randomNumbers;
        this.userNumbers = userNumbers;
    }

    public boolean isNotEnd() {
        return !randomNumbers.equals(userNumbers);
    }

    public BaseballResult playOneRound() {
        EnumMap<BaseballEnum, Integer> baseballEnums = new EnumMap(BaseballEnum.class);
        baseballEnums.put(BaseballEnum.STRIKE, new Strike().count(randomNumbers, userNumbers));
        baseballEnums.put(BaseballEnum.BALL, new Ball().count(randomNumbers, userNumbers));
        baseballEnums.put(BaseballEnum.OUT, new Out().count(randomNumbers, userNumbers));
        return new BaseballResult(baseballEnums);
    }

}
