package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baseball {

    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 9;
    public static final int NUMBER_SELECTED_SIZE = 3;
    public static final String REG_EXP =
            "^[" + MINIMUM_NUMBER + "-" + MAXIMUM_NUMBER + "]{" + NUMBER_SELECTED_SIZE + "}$";
    private List<Integer> expectedBallList = new ArrayList<>();

    public Baseball() {}

    public void start() {
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            playBaseball(scan);
            loop = !quit(scan);
        }
    }

    public void playBaseball(Scanner scan) {
        int[] computerNumbers = prepareComputerNumbers();
        boolean loof = true;
        while (loof) {
            int[] userNumbers = prepareUserNumbers(scan);
            loof = !checkAllStrike(computerNumbers, userNumbers);
        }
    }

    public int[] prepareComputerNumbers() {
        List<Integer> orderedNumbers = createOrderedNumbers();
        int[] computerNumbers = new int[NUMBER_SELECTED_SIZE];
        for (int i = 0; i < NUMBER_SELECTED_SIZE; i++) {
            int index = generateIndex(i);
            computerNumbers[i] = orderedNumbers.get(index);
            orderedNumbers.remove(index);
        }
        return computerNumbers;
    }

    private List<Integer> createOrderedNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MINIMUM_NUMBER; i < MAXIMUM_NUMBER + 1; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private int generateIndex(int i) {
        return (int)(Math.random() * 10000) % (MAXIMUM_NUMBER - i);
    }

    public int[] prepareUserNumbers(Scanner scan) {
        boolean loof = true;
        String inputNumber = null;
        while (loof) {
            System.out.print("숫자를 입력해주세요 : ");
            inputNumber = scan.next();
            loof = !checkInputNumbers(inputNumber);
        }
        return convertStringToIntArray(inputNumber);
    }

    public boolean checkInputNumbers(String inputNumber)  {
        if (inputNumber.matches(REG_EXP)) {
            return true;
        }
        return false;
    }

    public int[] convertStringToIntArray(String inputNumber) {
        char[] inputNumbers = inputNumber.toCharArray();
        int[] userNumbers = new int[NUMBER_SELECTED_SIZE];
        for (int i = 0; i < inputNumber.length(); i++) {
            userNumbers[i] = Integer.parseInt(String.valueOf(inputNumbers[i]));
        }
        return userNumbers;
    }

    public boolean checkAllStrike(int[] computerNumbers, int[] userNumbers) {
        BaseballJudgment baseballJudgment = baseballJudgment(computerNumbers, userNumbers);
        System.out.println(createMessage(baseballJudgment.getStrikeCount(), baseballJudgment.getBallCount()));
        if (baseballJudgment.getStrikeCount() == NUMBER_SELECTED_SIZE) {
            return true;
        }
        return false;
    }

    public BaseballJudgment baseballJudgment(int[] computerNumbers, int[] userNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_SELECTED_SIZE; i++) {
            strikeCount += isStrike(computerNumbers[i], userNumbers[i]);
        }
        int ballCount = getBallCount(userNumbers);
        expectedBallList.clear();

        BaseballJudgment baseballJudgment = new BaseballJudgment();
        baseballJudgment.setStrikeCount(strikeCount);
        baseballJudgment.setBallCount(ballCount);
        return baseballJudgment;
    }

    public int isStrike(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            return 1;
        }
        expectedBallList.add(computerNumber);
        return 0;
    }

    public int getBallCount(int[] userNumbers) {
        int ballCount = 0;
        for (int i = 0; i < userNumbers.length; i++) {
            ballCount += isBall(userNumbers[i]);
        }
        return ballCount;
    }

    public int isBall(int number) {
        if (expectedBallList.contains(number)) {
            return 1;
        }
        return 0;
    }

    public String createMessage(int strikeCount, int ballCount) {
        String message = createGameOverMessage(strikeCount);
        message += createNothingMessage(strikeCount, ballCount);
        message += createStrikeMessage(strikeCount, ballCount);
        message += createBallMessage(strikeCount, ballCount);
        message += createStrikeAndBallMessage(strikeCount, ballCount);
        return message;
    }

    public String createGameOverMessage(int strikeCount) {
        if (strikeCount == NUMBER_SELECTED_SIZE) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        return "";
    }

    public String createNothingMessage(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        return "";
    }

    public String createStrikeMessage(int strikeCount, int ballCount) {
        if (strikeCount > 0 && strikeCount < NUMBER_SELECTED_SIZE && ballCount == 0) {
            return strikeCount  + " 스트라이크 ";
        }
        return "";
    }

    public String createBallMessage(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount > 0) {
            return ballCount  + " 볼";
        }
        return "";
    }

    public String createStrikeAndBallMessage(int strikeCount, int ballCount) {
        if (strikeCount > 0 && strikeCount < NUMBER_SELECTED_SIZE
                && ballCount > 0 && ballCount < NUMBER_SELECTED_SIZE) {
            return strikeCount  + " 스트라이크 " + ballCount  + " 볼";
        }
        return "";
    }

    public boolean quit(Scanner scan) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (scan.nextInt() == 1) {
            return false;
        }
        return true;
    }

}
