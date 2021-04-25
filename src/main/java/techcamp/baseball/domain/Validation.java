package techcamp.baseball.domain;

import java.util.Collections;
import java.util.List;

public class Validation {

    /* 입력된 값이 설정된 자리 수인지 확인 */
    public boolean isAllowableSize(String input) {
        return input.length() == Config.NUMBERS_LENGTH;
    }

    /* 입력된 값이 숫자형식인지 확인 */
    public boolean isDigit(String input) {
        return input.matches(Config.REGEXP);
    }

    /* 입력된 값이 설정된 자리 수의 범위인지 확인 */
    public boolean isAllowableDigit(int number){
        return number >= Config.NUMBERS_MIN && number <= Config.NUMBERS_MAX;
    }

    /* 숫자 리스트의 중복여부 확인 */
    public boolean isDuplicatedList(List<Integer> numbers) {
        int dupCount = 0;
        for (int number : numbers) {
            dupCount += isContainList(numbers, number);
        }

        return dupCount <= 0;
    }

    private int isContainList(List<Integer> numbers, int number) {
        return Collections.frequency(numbers, number) - 1;
    }
}
