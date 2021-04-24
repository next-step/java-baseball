package baseball.view.output;

import baseball.domain.BaseballEnum;
import baseball.domain.BaseballResult;

import java.util.Map;

import static baseball.view.input.InputMessages.PLEASE_INPUT_VALID_NUMBERS;
import static baseball.view.output.OutputMessages.*;

public class ConsoleOutput implements Output {
    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void printValiedateNumber(int numberSize) {
        System.out.println(PLEASE_INPUT_VALID_NUMBERS);
    }

    @Override
    public void printEndMessage() {
        System.out.println(END_GAME);
        System.out.println(RE_START);
    }

    @Override
    public void printResult(BaseballResult result) {
        if (result.isNothing()) {
            System.out.println(NOTHING);
            return;
        }
        System.out.println(formatResult(result.getBaseballCounts()));
    }

    private String formatResult(Map<BaseballEnum, Integer> result) {
        return result.get(BaseballEnum.STRIKE) +
                " " +
                BaseballEnum.STRIKE.getMessage() +
                " " +
                result.get(BaseballEnum.BALL) +
                " " +
                BaseballEnum.BALL.getMessage();
    }

}
