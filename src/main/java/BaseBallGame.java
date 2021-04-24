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
}
