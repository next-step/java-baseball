package service.user;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerApiLogicServiceTest {

    @DisplayName("3자리 숫자 입력 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "123", "1111"})
    public void inputNumberLengthException(String input) {
        if(input.length() != 3)
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
    }

    @DisplayName("숫자 중복 입력 확인")
    @ParameterizedTest
    @ValueSource(strings = {"122", "123"})
    public void duplicateNumberException(String input) {
        ComputerApiLogicService computerApi = new ComputerApiLogicService();
        List<Integer> numberList = computerApi.stringToList(input);

        if(numberList.get(0).intValue() == numberList.get(1).intValue() || numberList.get(0).intValue() == numberList.get(2).intValue()
                || numberList.get(1).intValue() == numberList.get(2).intValue())
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
    }

    @DisplayName("숫자 아닌 입력 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1ㄱ2", "123"})
    public void numberFormatException(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력이 가능합니다.");
        }
    }
}