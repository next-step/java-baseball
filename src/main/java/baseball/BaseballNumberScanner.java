package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class BaseballNumberScanner {

    public List<Integer> getNumber() {
        List<Integer> numberList = inputNumber();
        while (numberList == null) {
            numberList = inputNumber();
        }
        return numberList;
    }

    public List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scan = new Scanner(System.in);
        List<Integer> numberList = null;
        String numberStr = scan.next();
        try {
            numberList = makeNumberList(numberStr);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return numberList;
    }

    public List<Integer> makeNumberList(String numberStr) {
        List<Integer> numberList = new ArrayList<>();
        Set<Integer> numberSet = new HashSet<>();
        for (char number : numberStr.toCharArray()) {
            numberList.add(charToInt(number));
        }
        numberSet.addAll(numberList);
        if (numberSet.size() != 3 || numberList.size() != 3) {
            throw new RuntimeException("중복된 숫자 또는 3자리가 아닌 수를 입력하셨습니다.");
        }
        return numberList;
    }

    public int charToInt(char input) {
        int number = Character.getNumericValue(input);
        if (number < 1 || number > 9) {
            throw new RuntimeException("숫자가 아닌 다른 문자를 입력하셨습니다.");
        }
        return number;
    }
}
