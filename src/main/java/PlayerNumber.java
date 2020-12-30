import java.util.Scanner;

public class PlayerNumber {

    private BaseballGameNumberChecker checker;
    private Scanner scanner;

    public PlayerNumber(int lengthOfNumber) {
        checker = new BaseballGameNumberChecker(lengthOfNumber);
        scanner = new Scanner(System.in);
    }

    public int getNumber() {
        int number = 0;
        print();
        while (!checker.isCorrect(number = getInput())) {
            printError();
            print();
        }
        return number;
    }

    public int getInput() {
        int number = 0;
        try {
            number = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            number = 0;
        }
        return number;
    }

    private void print() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printError() {
        System.out.println("잘못된 값을 입력했습니다.");
    }

}
