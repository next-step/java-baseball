import java.util.Random;
import java.util.Scanner;

/**
 * 야구게임 클래스
 */
public class BaseBallGame {
    /**
     * [메인 메소드]
     */
    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.start();
    }

    /**
     * [야구게임시작]
     * endValue=1일시 계속 시작하고, 2일시 종료한다.
     */
    private void start() {
        int endValue = 1;
        while (endValue == 1) {
            endValue = playGame();
        }
    }

    /**
     * [게임플레이]
     * 임의의 세 자리 숫자를 생성한다.
     * 플레이어에게 세 자리 숫자를 입력 받는다.
     * 입력 받은 값의 유효성 체크를 한다.
     * 3 스트라이크인지 판단한다.
     */
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

    /**
     * [세 자리 숫자 생성]
     * 각 자릿 수 마다 서로 다른 수로 세 자리 숫자를 생성한다.
     */
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

    /**
     * [입력 값의 유효성을 검증]
     */
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

    /**
     * [길이 검증]
     * 입력 값의 길이가 3이 맞는지 체크한다.
     */
    private boolean isValidLength(String inputNumbers) {
        return inputNumbers != null && inputNumbers.length() == 3;
    }

    /**
     * [형식 검증]
     * 입력 값의 형식이 맞는지 체크한다.
     */
    private boolean isValidFormat(String inputNumbers) {
        for (char number : inputNumbers.toCharArray()) {
            if ((int) number < 49 || (int) number > 57) {
                return false;
            }
        }
        return true;
    }

    /**
     * [3 스트라이크 여부 확인]
     * 스트라이크, 볼 계산
     * 결과 출력
     * 3 스트라이크 여부 반환
     */
    private boolean isThreeStrikes(String threeNumbers, String inputNumbers) {
        int[] strikeBallCount = calculate(threeNumbers, inputNumbers);
        printResult(strikeBallCount[0], strikeBallCount[1]);
        return strikeBallCount[0] == 3;
    }

    /**
     * [스트라이크, 볼 계산]
     */
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

    /**
     * [스트라이크 계산]
     */
    private int calculateStrike(char base, char input) {
        return base == input ? 1 : 0;
    }

    /**
     * [볼 계산]
     */
    private int calculateBall(int baseIndex, int base, char[] input) {
        int inputLength = input.length;
        for (int i = 0; i < inputLength; i++) {
            if (i != baseIndex && base == input[i]) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * [스트라이크, 볼 계산 결과 출력]
     */
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

    /**
     * [야구 게임 종료]
     * 1 입력시 게임 다시 시작
     * 2 입력시 게임 종료(프로그램 종료)
     */
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
