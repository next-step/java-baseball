package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {

    private List<Number> numberList;
    private static final int MAX_SIZE = 3;
    private static final int THOUSAND = 1000;
    private static final int HUNDREDS = 100;
    private static final int TEN = 10;
    private Set<Integer> duplicateCheckNumberSet;
    private int number;

    Numbers(int number) {
        checkSize(number);
        this.numberList = changeNumberType(number);
        checkDuplicateNumber(numberList);
    }

    public List<Number> numbers() {
        return this.numberList;
    }

    private List<Number> changeNumberType(int number) {
        int firstNumber = number / HUNDREDS;
        int secondNumber = (number % HUNDREDS) / TEN;
        int thirdNumber = (number % HUNDREDS) % TEN;
        Number number1 = new Number(firstNumber);
        Number number2 = new Number(secondNumber);
        Number number3 = new Number(thirdNumber);
        return changeListNumber(number1, number2, number3);

    }

    private List<Number> changeListNumber(Number number1, Number number2, Number number3) {
        List<Number> numberList = new ArrayList<>();
        numberList.add(number1);
        numberList.add(number2);
        numberList.add(number3);
        return numberList;
    }

    private void checkSize(int number){
        if(number >THOUSAND){
            throw new IllegalArgumentException("숫자 3개 초과입력하셨습니다.");
        }

        if(number < HUNDREDS){
            throw new IllegalArgumentException("입력된 숫자 갯수가 2개이하로 입력하였습니다.");
        }
    }

    private void checkDuplicateNumber(List<Number> numberList) {
        duplicateCheckNumberSet = new HashSet<>();
        for (Number number : numberList) {
            duplicateCheckNumberSet.add(number.number());
        }

        if (duplicateCheckNumberSet.size() < MAX_SIZE) {
            throw new IllegalArgumentException("중복된 숫자를 입력하였습니다.");
        }
    }

}
