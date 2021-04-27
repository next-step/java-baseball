import util.ProgramUtils;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        startBaseballGame();
    }

    static void startBaseballGame() {

        boolean isGameRunning;
        String commRandomNum = getRandomNumStr();
        System.out.println("commRandomNum : " + commRandomNum);

        do {
            String userBaseballStr = scanUserInput(commRandomNum);
            isGameRunning = verifyBaseballNum(userBaseballStr, commRandomNum);
        } while (isGameRunning);

        System.out.println(getRandomNumStr());
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

        boolean isGameRunning = true;

        // Check Strike
        int strikeCount = getStrikeCount(userBaseballStr, commRandomNum);
        System.out.println(strikeCount + "스트라이크");

        return isGameRunning;
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
