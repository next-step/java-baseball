package application;

import domain.BaseballNumbers;
import utils.BaseballNumberFactory;

/**
 * @author : byungkyu
 * @date : 2020/11/12
 * @description : 야구게임 비즈니스로직
 **/
public class BaseballService {
    private static BaseballNumberFactory baseballNumberFactory = new BaseballNumberFactory();

    public BaseballNumbers generateAnswer() {
        return baseballNumberFactory.generateNumbers();
    }
}
