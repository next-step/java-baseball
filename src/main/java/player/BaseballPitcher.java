package player;

import exception.BaseballException;
import utils.ValidateNumbers;

import java.util.*;

public class BaseballPitcher {

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final Scanner scan = new Scanner(System.in);

    private List<Integer> numbers;

    public BaseballPitcher() {
        throwingBall();
    }

    public void throwingBall() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String input = scan.nextLine();
        String[] splitString = input.split("");

        List<Integer> numbers = parseNumbers(splitString);
        new ValidateNumbers(numbers).checkAllConditions();
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> parseNumbers(String[] splitString) {
        List<Integer> numbers = new ArrayList<>();
        for (String str : splitString) {
            numbers.add(parseNumber(str));
        }
        return numbers;
    }

    public static Integer parseNumber(String str) {
        if (isNumeric(str)) {
            return Integer.parseInt(str);
        }
        throw new BaseballException.ParseNumberException();
    }

    private static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
}
