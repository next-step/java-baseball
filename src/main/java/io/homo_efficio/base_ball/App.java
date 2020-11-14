package io.homo_efficio.base_ball;

import java.util.Scanner;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-11-14
 */
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        playGame(scanner);
    }

    private static void playGame(Scanner scanner) {
        String genNumber = NumberGenerator.generate(3);
        Result result;
        do {
            String inputNumber = getInputNumber(scanner);
            result = new Umpire(genNumber, inputNumber).judge();
            System.out.println(result.getText());
        } while (!result.is3Strikes());

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        postGame(scanner);
    }

    private static String getInputNumber(Scanner scanner) {
        System.out.print("숫자를 입력해 주세요: ");
        String input = scanner.nextLine();
        InputValidator.check3Digits(input);
        return input;
    }

    private static void postGame(Scanner scanner) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        switch (scanner.nextLine()) {
            case "1":
                playGame(scanner);
                break;
            case "2":
                break;
            default:
                break;
        }
    }
}
