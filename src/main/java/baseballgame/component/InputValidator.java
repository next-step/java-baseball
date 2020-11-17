package baseballgame.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputValidator {

    private static final int VALID_INPUT_SIZE = 3;

    /**
     * 입력값에 대한 유효성 검사 진행
     * @param input
     * @return 입력값을 리스트에 담아 반환
     * @throws IllegalArgumentException
     */
    public static List<Integer> validate(String input) throws IllegalArgumentException {
        isNumber(input);
        isZeroNotIncluded(input);
        isValidSize(input);
        isDifferentFromEachOther(input);
        return getInputAsList(input);
    }

    /**
     * 입력값이 숫자인지 확인
     * @param input
     */
    private static void isNumber(String input) throws IllegalArgumentException {
        Integer.parseInt(input);
    }

    /**
     * 입력값에 0이 포함되지 않은지 확인
     * @param input
     */
    private static void isZeroNotIncluded(String input) throws IllegalArgumentException {
        if(input.indexOf("0") > -1) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력값이 올바른 크기인지 확인
     * @param input
     */
    private static void isValidSize(String input) throws IllegalArgumentException {
        if(input.length() != VALID_INPUT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력값이 서로 다른 숫자인지 확인
     * @param input
     */
    private static void isDifferentFromEachOther(String input) throws IllegalArgumentException {
        HashSet<String> diffChecker= new HashSet<String>(Arrays.asList(input.split("")));
        if (diffChecker.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력값을 List<Integer>에 담아 반환
     * @param input
     */
    private static List<Integer> getInputAsList(String input){
        List<Integer> inputList = new ArrayList<>();
        String[] inputArray = input.split("");
        for (String s : inputArray) {
            inputList.add(Integer.parseInt(s));
        }
        return inputList;
    }

}
