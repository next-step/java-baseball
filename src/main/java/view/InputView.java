package view;

import domain.BaseballNumbers;
import domain.enums.GameStatus;
import utils.UtilMeassage;

import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static BaseballNumbers userInputValue() {
        System.out.print(UtilMeassage.REQUIRE_NUMBER_INPUT_MESSAGE);
        try {
            String numbers = sc.next();
            return BaseballNumbers.of(numbers);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
            return userInputValue();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return userInputValue();
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
            return userInputValue();
        }
    }

    public static boolean playAgain() {
        System.out.println(UtilMeassage.REQUIRE_RESTART_INPUT_MESSAGE);

        try {
            String selectNum = sc.next();
            GameStatus option = GameStatus.of(selectNum);

            if(option == GameStatus.STOP) {
                System.out.println(UtilMeassage.END);
            }

            return option.isRestart();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return playAgain();
        }

    }
}
