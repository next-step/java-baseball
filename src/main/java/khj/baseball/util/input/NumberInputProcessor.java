package khj.baseball.util.input;

import khj.baseball.exception.DuplicateInputException;
import khj.baseball.exception.LengthWrongInputException;
import khj.baseball.exception.TypeWrongInputException;

import java.util.Scanner;

public class NumberInputProcessor implements InputProcessor {
    private String regExp = "[1-9]+";

    @Override
    public String inputNumberString(int length) throws TypeWrongInputException, LengthWrongInputException, DuplicateInputException {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();

        isCheckLength(result, length);
        isCheckNumber(result);
        isDuplicates(result);

        return result;
    }

    private void isCheckNumber(String result) {
        if (!result.matches(regExp)) {
            throw new TypeWrongInputException();
        }
    }

    private void isCheckLength(String result, int length) {
        if (result.length() != length) {
            throw new LengthWrongInputException();
        }
    }

    private void isDuplicates(String result) {
        char[] chArray = result.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char ch : chArray) {
            isDuplicatesAppendChar(sb, ch);
        }

        if (sb.toString().length() != result.length()) {
            throw new DuplicateInputException();
        }
    }

    private void isDuplicatesAppendChar(StringBuilder sb, char ch) {
        if (sb.indexOf(String.valueOf(ch)) == -1) {
            sb.append(ch);
        }
    }
}
