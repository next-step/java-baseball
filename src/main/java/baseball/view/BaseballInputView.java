package baseball.view;

import baseball.domain.Baseball;

import java.util.Scanner;

public class BaseballInputView {
    private static Scanner sc = new Scanner(System.in);

    public static Baseball userInputValue() {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            String numbers = sc.next();
            return Baseball.of(numbers);
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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2 입력하세요.");
        try {
            String selectNum = sc.next();
            SelectOption option = SelectOption.of(selectNum);
            return option.isRestart();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return playAgain();
        }

    }

}
