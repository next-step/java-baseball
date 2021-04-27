package baseball;

import java.util.Arrays;

import util.RandomUtil;
import util.ScannerUtil;

public class GameMain {
    public static void main(String[] args) {
        int[] com = RandomUtil.getRandom3DigitWithoutDuplicates();
        boolean isAnswer = false;
        do {
            int[] user = ScannerUtil.getUserInputAsArray();
            isAnswer = isAnswer(com, user);
            boolean hasNewGame = isAnswer && hasNewGame(isAnswer);
            if (isAnswer && !hasNewGame) {
                break;
            }

            if (isAnswer && hasNewGame) {
                com = RandomUtil.getRandom3DigitWithoutDuplicates();
                isAnswer = false;
                continue;
            }

            int strikeCount = getStrikeCount(com, user);
            int ballCount = getBallCount(com, user);
            printStrikeAndBallCount(strikeCount, ballCount);
        } while (!isAnswer);
    }

    static boolean hasNewGame(boolean isAnswer) {
        if (!isAnswer) {
            return false;
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        int gameMode = ScannerUtil.getGameMode();
        if (gameMode == 1) {
            return true;
        }

        return false;
    }

    static boolean isAnswer(int[] com, int[] user) {
        return Arrays.equals(com, user);
    }

    static int getStrikeCount(int[] com, int[] user) {
        int strikeCount = 0;
        for (int i=0; i<3 ;i++) {
            strikeCount = isStrike(com[i], user[i]) ? ++strikeCount : strikeCount;
        }
        return strikeCount;
    }

    private static boolean isStrike(int com, int user) {
        return com == user;
    }

    static int getBallCount(int[] com, int[] user) {
        int ballCount = 0;
        for (int i=0; i<3; i++) {
            ballCount = isBall(com, user[i], i) ? ++ballCount : ballCount;
        }
        return ballCount;
    }

    private static boolean isBall(int[] com, int num, int originIndex) {
        for (int i=0; i<3; i++) {
            if (com[i] == num && i != originIndex) {
                return true;
            }
        }
        return false;
    }

    static void printStrikeAndBallCount(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();
        if (strikeCount > 0) {
            sb.append(strikeCount).append(" 스트라이크 ");
        }

        if (ballCount > 0) {
            sb.append(ballCount).append("볼");
        }

        if (strikeCount == 0 && ballCount == 0) {
            sb.append("낫싱");
        }

        sb.append("\n");
        System.out.print(sb.toString());
    }
}
