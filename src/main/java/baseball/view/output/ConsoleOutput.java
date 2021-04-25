package baseball.view.output;

import baseball.domain.BaseballEnum;
import baseball.domain.BaseballResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static baseball.view.input.InputMessages.PLEASE_INPUT_VALID_NUMBERS;
import static baseball.view.output.OutputMessages.*;

public class ConsoleOutput implements Output {
    private final String STRING_DELIMITER = " ";

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void printValiedateNumber() {
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
        List<String> strings = new ArrayList<>();
        for (BaseballEnum baseballEnum : result.keySet()) {
            addToList(strings, result, baseballEnum);
        }
        return String.join(STRING_DELIMITER, strings);
    }

    private void addToList(List<String> strings, Map<BaseballEnum, Integer> result, BaseballEnum baseballEnum) {
        final int count = result.get(baseballEnum);
        if (count > 0) {
            strings.add(String.valueOf(count));
            strings.add(baseballEnum.getMessage());
        }
    }

}
