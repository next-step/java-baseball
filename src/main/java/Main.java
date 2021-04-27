import util.ProgramUtils;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        startBaseballGame();
    }

    public static boolean startBaseballGame() {
        boolean isGameRunning;
        do {
            runGame();
            isGameRunning = getGameRunningStatus();
        } while (isGameRunning);

        return isGameRunning;
    }

    public static boolean getGameRunningStatus() {

        int newgameFlag;

        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Scanner sc = new Scanner(System.in);
            newgameFlag = sc.nextInt();
        } while (newgameFlag < 1 || newgameFlag > 2);

        return newgameFlag == 1;
    }

    static void runGame() {

        boolean isGameRunning;
        String commRandomNum = getRandomNumStr();
        System.out.println("commRandomNum : " + commRandomNum);

        do {
            String userBaseballStr = scanUserInput(commRandomNum);
            isGameRunning = verifyBaseballNum(userBaseballStr, commRandomNum);

        } while (isGameRunning);
    }

    private static String scanUserInput(String commRandomNum) {
        String userBaseballStr;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            Scanner sc = new Scanner(System.in);
            userBaseballStr = sc.next();

        } while (!ProgramUtils.isNumeric(userBaseballStr) || userBaseballStr.length() < commRandomNum.length());

        return userBaseballStr;
    }

    private static boolean verifyBaseballNum(String userBaseballStr, String commRandomNum) {

        // Check Strike
        int strikeCount = getStrikeCount(userBaseballStr, commRandomNum);

        // Check Ball
        int ballCount = getBallCount(userBaseballStr, commRandomNum);
        ballCount -= strikeCount;

        // Check Nothing
        boolean isNothing = strikeCount + ballCount > 0 ? false : true;

        if (strikeCount == commRandomNum.length()) {
            System.out.println(commRandomNum.length() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        } else if (strikeCount > 0) {
            System.out.println(strikeCount + "스트라이크");
        }

        if (ballCount > 0) {
            System.out.println(ballCount + "볼");
        }

        if (isNothing) {
            System.out.println("낫싱");
        }

        return true;
    }

    public static int getBallCount(String userBaseballStr, String commRandomNum) {
        int ballCnt = 0;

        for (int i = 0; i < userBaseballStr.length(); i++) {
            int userNum = userBaseballStr.charAt(i) - '0';
            ballCnt += compareBallCount(userNum, commRandomNum);
        }

        return ballCnt;
    }

    private static int compareBallCount(int userNum, String commRandomNum) {

        boolean isBall = false;

        for (int i = 0; i < commRandomNum.length() && !isBall; i++) {
            int commNum = commRandomNum.charAt(i) - '0';

            isBall = verifyBall(userNum, commNum);
        }

        if (isBall) return 1;
        else return 0;
    }

    private static boolean verifyBall(int userNum, int commNum) {
        return userNum == commNum;
    }

    static int getStrikeCount(String userBaseballStr, String commRandomNum) {

        int strikeCnt = 0;

        for (int i = 0; i < userBaseballStr.length(); i++) {
            int userNum = userBaseballStr.charAt(i) - '0';
            int commNum = commRandomNum.charAt(i) - '0';

            strikeCnt += compareStrikeNum(userNum, commNum);
        }

        return strikeCnt;
    }

    private static int compareStrikeNum(int userNum, int commNum) {
        if (userNum == commNum) return 1;
        else return 0;
    }

    private static boolean compareNum(int userNum, int index) {

        String userRandomNum = getRandomNumStr();

        for (int i = 0; i < userRandomNum.length(); i++) {
            int comNum = userRandomNum.charAt(i) - '0';

            verifyNum(comNum, i);
        }

        return false;
    }

    private static boolean verifyNum(int comNum, int i) {


        return false;
    }


    static String getRandomNumStr() {
        StringBuilder baseballNum = new StringBuilder();
        Set baseballNumSet = new HashSet();

        final int baseballIntLen = 3;
        for (int i = 0; i < baseballIntLen; i++) {
            int num = getRandomNum(baseballNumSet);
            baseballNumSet.add(num);
            baseballNum.append(num);
        }

        return baseballNum.toString();
    }

    static int getRandomNum(Set baseballNumSet) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis() * random.nextInt());

        int randomNum;

        do {
            randomNum = random.nextInt(10);
        } while (randomNum == 0 || baseballNumSet.contains(randomNum));

        return randomNum;
    }
}
