package baseballgame.view;

import baseballgame.game.GameNumber;

import java.util.ArrayList;
import java.util.List;

public class InputConverter {

    private static final char CHAR_OF_ZERO = '0';

    public static GameNumber convertToGameNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("input is empty.");
        }
        final List<Integer> numberList = convertToNumberList(input.trim());
        return GameNumber.of(numberList);
    }

    private static List<Integer> convertToNumberList(String input) {
        final List<Integer> numberList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numberList.add(c - CHAR_OF_ZERO);
        }
        return numberList;
    }

    public static boolean convertToRerunCommand(String input, String rerunCommand, String finishCommand) {
        return input.equals(rerunCommand);
    }
}
