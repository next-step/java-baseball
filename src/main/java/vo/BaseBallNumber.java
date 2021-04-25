package vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBallNumber {

    public static final int BASEBALL_NUMBER_SIZE = 3;

    private final List<Integer> numbers;

    public BaseBallNumber(List<Integer> list) {
        validateSize(list);
        validateDuplicate(list);
        numbers = new ArrayList<>(list);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != BASEBALL_NUMBER_SIZE)
            throw new IllegalArgumentException(String.format("숫자야구게임의 생성 숫자는 %d개만 가능합니다.",
                    BASEBALL_NUMBER_SIZE));
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != BASEBALL_NUMBER_SIZE)
            throw new IllegalArgumentException("숫자야구게임의 생성 숫자는 중복될 수 없습니다.");
    }

    public CompareResult compare(List<Integer> inputList) {
        if (inputList.size() != BASEBALL_NUMBER_SIZE)
            throw new IllegalArgumentException(String.format("숫자야구게임의 입력 숫자는 %d개만 가능합니다.",
                    BASEBALL_NUMBER_SIZE));
        Set<Integer> inputSet = new HashSet<>(inputList);
        if (inputSet.size() != BASEBALL_NUMBER_SIZE)
            throw new IllegalArgumentException("숫자야구게임의 입력 숫자는 중복될 수 없습니다.");

        CompareResult compareResult = new CompareResult();
        Set<Integer> numberSet = new HashSet<>(this.numbers);
        for (int i = 0; i < inputList.size(); i++) {
            setUpCompareResult(compareResult, inputList.get(i), this.numbers.get(i), numberSet);
        }

        return compareResult;
    }

    private void setUpCompareResult(CompareResult compareResult, int inputValue, int numberValue, Set<Integer> numberSet) {
        if (inputValue == numberValue) {
            compareResult.plusStrikeCnt();
            return;
        }

        if (numberSet.contains(inputValue)) {
            compareResult.plusBallCnt();
        }
    }
}
