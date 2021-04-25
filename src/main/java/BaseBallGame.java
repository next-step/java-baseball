import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.start();
    }

    private void start() {
        int endValue = 1;
        while (endValue == 1) {
            endValue = playGame();
        }
    }

    private int playGame() {
        String threeNumbers = generateThreeNumbers();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String inputNumbers = scanner.next();
            if (!isValidInputValue(inputNumbers)) {
                continue;
            }
            if (isThreeStrikes(threeNumbers, inputNumbers)) {
                return end();
            }
        }
    }

    private String generateThreeNumbers() {
        Random random = new Random();
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        while (num1 == num2 || num1 == num3 || num2 == num3) {
            num1 = random.nextInt(9) + 1;
            num2 = random.nextInt(9) + 1;
            num3 = random.nextInt(9) + 1;
        }
        return String.valueOf(num1) + num2 + num3;
    }

    private boolean isValidInputValue(String inputNumbers) {
        if (!isValidLength(inputNumbers)) {
            System.out.println("유효하지 않은 입력길이 입니다. 다시 입력 해주세요.");
            return false;
        }
        if (!isValidFormat(inputNumbers)) {
            System.out.println("유효하지 않은 입력형식 입니다. 다시 입력 해주세요.");
            return false;
        }
        return true;
    }

    private boolean isValidLength(String inputNumbers) {
        return inputNumbers != null && inputNumbers.length() == 3;
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

    private boolean isThreeStrikes(String threeNumbers, String inputNumbers) {
        int[] strikeBallCount = calculate(threeNumbers, inputNumbers);
        printResult(strikeBallCount[0], strikeBallCount[1]);
        return strikeBallCount[0] == 3;
    }

    private int[] calculate(String inputNumbers, String threeNumbers) {
        char[] base = threeNumbers.toCharArray();
        char[] input = inputNumbers.toCharArray();
        int baseLength = base.length;
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < baseLength; i++) {
            strikeCount += calculateStrike(base[i], input[i]);
            ballCount += calculateBall(i, base[i], input);
        }
        return new int[] {strikeCount, ballCount};
    }

    private int calculateStrike(char base, char input) {
        return base == input ? 1 : 0;
    }

    private int calculateBall(int baseIndex, int base, char[] input) {
        int inputLength = input.length;
        for (int i = 0; i < inputLength; i++) {
            if (i != baseIndex && base == input[i]) {
                return 1;
            }
        }
        return 0;
    }

    private void printResult(int strikeCount, int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            System.out.println(strikeCount + " 스트라이크 " + ballCount + " 볼");
        } else if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + " 스트라이크");
        } else if (ballCount > 0) {
            System.out.println(ballCount + " 볼");
        } else if (ballCount == 0) {
            System.out.println("낫싱");
        }
    }

    private int end() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1. 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int endValue = scanner.nextInt();
            if (endValue == 1 || endValue == 2) {
                return endValue;
            }
            System.out.println("유효하지 않은 입력 값 입니다. 다시 입력 해주세요.");
        }
    }
}
