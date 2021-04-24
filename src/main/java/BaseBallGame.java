import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.start();
    }

    private void start() {
        System.out.println("야구 게임 시작");
        String threeNumbers = generateThreeNumbers();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputNumbers = scanner.next();

            if (!isValidLength(inputNumbers)) {
                System.out.println("유효하지 않은 입력길이 입니다.");
            }
            if (!isValidFormat(inputNumbers)) {
                System.out.println("유효하지 않은 입력형식 입니다.");
            }
        }
    }

    private String generateThreeNumbers() {
        Random random = new Random();
        String num1 = String.valueOf(random.nextInt(9) + 1);
        String num2 = String.valueOf(random.nextInt(9) + 1);
        String num3 = String.valueOf(random.nextInt(9) + 1);

        return num1+num2+num3;
    }

    private boolean isValidLength(String inputNumbers) {
        if (inputNumbers == null || inputNumbers.length() != 3) {
            return false;
        }
        return true;
    }

    private boolean isValidFormat(String inputNumbers) {
        int inputNumbersLength = inputNumbers.length();

        for (int i = 0; i < inputNumbersLength; i++) {
            String s = inputNumbers.substring(i, i+1);
            int number;
            try {
                number = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return false;
            }
            if (number < 1 || number > 9) {
                return false;
            }
        }

        return true;
    }
}
