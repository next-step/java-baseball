package me.kingcjy.baseball;

import java.util.Scanner;

/**
 * @author KingCjy
 */
public class InputManager {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요: ";

    private Scanner scanner = new Scanner(System.in);

    public int[] scanValidInput() {
        ValidationResult validationResult = null;
        int input = 0;

        while (validationResult != ValidationResult.SUCCESS) {
            System.out.print(INPUT_MESSAGE);
            input = scanner.nextInt();
            validationResult = ValidationUtils.getValidationResult(Integer.toString(input));
            validationResult.printMessage();
        }

        return intToArray(input);
    }

    private int[] intToArray(int number) {
        char[] chars = Integer.toString(number).toCharArray();
        int[] result = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            result[i] = Character.getNumericValue(chars[i]);
        }

        return result;
    }
}
