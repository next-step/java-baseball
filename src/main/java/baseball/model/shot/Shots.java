package baseball.model.shot;

import baseball.model.AnswerNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Shots {
    private final List<Shot> shots;
    private int index = -1;

    public Shots(final String inputData, final AnswerNumbers answerNumbers) {
        final List<Integer> inputList = parsingInput(inputData);
        shots = compareAnswer(inputList, answerNumbers);
    }

    public List<Shot> getShots() {
        return shots;
    }

    private List<Integer> parsingInput(final String inputData) {
        return Arrays
                .stream(inputData.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<Shot> compareAnswer(final List<Integer> inputList, final AnswerNumbers answerNumbers) {
        return inputList.stream()
                .map(answerNumber -> {
                    index++;
                    return getResult(answerNumber, answerNumbers);
                })
                .collect(Collectors.toList());
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
}
