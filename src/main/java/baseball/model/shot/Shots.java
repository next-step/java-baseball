package baseball.model.shot;

import baseball.model.AnswerNumbers;
import baseball.model.InningResult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Shots {
    private final Map<Shot, Integer> shots = new HashMap<>();
    private final AnswerNumbers answerNumbers;
    private int index = -1;

    public Shots(final AnswerNumbers answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public InningResult makeResult(final String inputData) {
        final List<Integer> inputList = parsingInput(inputData);
        compareAnswer(inputList, answerNumbers);
        final InningResult inningResult = new InningResult(shots);
        initialize();
        return inningResult;
    }

    private List<Integer> parsingInput(final String inputData) {
        return Arrays
                .stream(inputData.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void compareAnswer(final List<Integer> inputList, final AnswerNumbers answerNumbers) {
        inputList.stream()
                .map(answerNumber -> {
                    index++;
                    return getResult(answerNumber, answerNumbers);
                })
                .forEach(result -> shots.put(result, shots.getOrDefault(result, 0) + 1));
    }

    private Shot getResult(int oneCount, final AnswerNumbers answerNumbers) {
        if (oneCount == answerNumbers.getAnswerNumber(index)) {
            return Shot.STRIKE;
        }
        if (answerNumbers.contains(oneCount)) {
            return Shot.BALL;
        }
        return Shot.OUT;
    }

    private void initialize() {
        shots.clear();
        index = -1;
    }
}
