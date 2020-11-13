package io.homo_efficio.base_ball;

import java.util.Scanner;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-11-14
 */
public class App {

    public static void main(String[] args) {
        String genNumber = NumberGenerator.generate();
        Scanner scanner = new Scanner(System.in);
        Result result;
        do {
            String inputNumber = getInputNumber(scanner);
            result = new Umpire(genNumber, inputNumber).judge();
            System.out.println(result.getText());
        } while (!result.is3Strikes());

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static String getInputNumber(Scanner scanner) {
        System.out.print("숫자를 입력해 주세요: ");
        String input = scanner.nextLine();
        InputValidator.check3Digits(input);
        return input;
    }

}
