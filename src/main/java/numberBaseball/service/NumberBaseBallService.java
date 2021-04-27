package numberBaseball.service;

import numberBaseball.domain.GameNumber;
import numberBaseball.dto.ResultResponse;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseBallService {
    private GameNumber targetNumber;

    public void generateTargetNumber() {
        targetNumber = GameNumber.randomGenerate();
    }

    public ResultResponse getResultResponse(String inputNumber) {
        GameNumber inputGameNumber = convertInputToGameNumber(inputNumber);
        return targetNumber.getResultResponse(inputGameNumber);
    }

    private GameNumber convertInputToGameNumber(String inputGameNumber) {
        List<Integer> inputGameNumberList = new ArrayList<>();
        for (char ch : inputGameNumber.toCharArray()) {
            inputGameNumberList.add(Character.getNumericValue(ch));
        }
        return GameNumber.of(inputGameNumberList);
    }
}
