package baseball;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean ing = true;
        while (ing) {
            game(new Computer(), sc);
            printEndMessage();
            ing = decisionGame(sc);
        }
    }

    private static boolean decisionGame(Scanner scanner) {
        int input = scanner.nextInt();
        if (input == 1) {
            return true;
        }
        if (input == 2) {
            return false;
        }
        System.out.println("1 또는 2만 입력해 주세요.");
        return decisionGame(scanner);
    }

    private static void printEndMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static void game(Computer computer, Scanner scanner) {
        boolean ing = true;
        while (ing) {
            printNaviMessage();
            int inputNumber = scanner.nextInt();
            computer.calc(inputNumber);
            computer.printResult();
            ing = computer.isIng(inputNumber);
        }
    }

    private static void printNaviMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }
}