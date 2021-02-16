package view;

import dto.ResultData;

public class Output {
    private static final String RESULT_DATA_DELIMITER = " ";
    private static final String GAME_END_MSG = "3개의 숫자를 모두 맞히셨습니다!";

    public void printResultData(ResultData data) {
        System.out.println(String.join(RESULT_DATA_DELIMITER, data.getData()));
    }

    public void printGameEndMessage() {
        System.out.println(GAME_END_MSG);
    }
}
