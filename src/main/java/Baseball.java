
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Baseball {

    public static void main(String[] args) {
        boolean _continue;

        System.out.println("숫자야구 게임을 시작합니다.");

        do {
            playBaseball();
            _continue = askUserContinue();
        } while(_continue);

        System.out.println("게임이 종료되었습니다.");
    }


    public static void playBaseball() {
        int gameNumber = generateRandomNumber();
        boolean isEnd;
        System.out.println(gameNumber);
        do {
            int inputNumber = getInputNumber();

            String gameResult = getGameResult(gameNumber, inputNumber);

            isEnd = isThreeStrike(gameResult);
        } while (!isEnd);
    }


    public static int getInputNumber() {
        boolean isCorrect = false;
        int inputNumber = 0;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("숫자를 입력해주세요 : ");
                inputNumber = scanner.nextInt();
                isCorrect = isValidNumber(inputNumber);

                if (!isCorrect) {
                    System.out.println("각 자리수가 서로 다른 세자리 숫자가 아닙니다.");
                }

            } catch (InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다. 숫자를 입력해주세요.");
            }
        } while (!isCorrect);

        return inputNumber;
    }


    public static boolean isValidNumber(int number) {
        int[] digits = new int[10];
        int digit;

        if (number < 123 || number > 987) {
            return false;
        }

        do {
            digit = number % 10;

            if(digits[digit] != 0)
                return false;

            digits[digit] += 1;
            number /= 10;
        } while (number != 0);

        return true;
    }


    public static String getGameResult(int gameNumber, int inputNumber) {

        int strikeCount;
        int ballCount;
        String gameResult = "";

        strikeCount = getStrikeCount(gameNumber, inputNumber);
        ballCount = getBallCount(gameNumber, inputNumber);

        if (strikeCount != 0) {
            gameResult = strikeCount + " strike ";
        }
        if (ballCount != 0) {
            gameResult += ballCount + " ball";
        }
        if (gameResult.equals("")) {
            gameResult = "Nothing";
        }

        System.out.println(gameResult);

        return gameResult;
    }


    public static int getStrikeCount(int number1, int number2) {
        int strikeCount = 0;
        int digit1, digit2;

        for (int i=0; i<3; i++) {
            digit1 = number1%10;
            digit2 = number2%10;

            number1 /= 10;
            number2 /= 10;

            if (digit1 == digit2) {
                strikeCount += 1;
            }
        }

        return strikeCount;
    }


    public static int getBallCount(int number1, int number2) {
        int ballCount = -getStrikeCount(number1, number2);
        int digit1, digit2;
        int[] digits = new int[10];

        for (int i=0; i<3; i++) {
            digit1 = number1%10;
            digit2 = number2%10;

            number1 /= 10;
            number2 /= 10;

            digits[digit1]++;
            digits[digit2]++;
        }

        for (int i=0; i<10; i++) {
            if (digits[i] == 2)
                ballCount++;
        }

        return ballCount;
    }


    public static int generateRandomNumber() {
        Random random = new Random();
        boolean isCorrect;
        int number;

        do {
            number = random.nextInt(865) + 123;
            isCorrect = isValidNumber(number);
        } while (!isCorrect);

        return number;
    }


    public static boolean askUserContinue() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int number = scanner.nextInt();

        return number == 1;
    }


    public static boolean isThreeStrike(String gameResult) {
        String threeStrike = "3 strike ";

        if (gameResult.equals(threeStrike)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다.");
            System.out.println("게임 종료");
            return true;
        }

        return false;
    }
}
