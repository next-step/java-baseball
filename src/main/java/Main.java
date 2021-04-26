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

        String userBaseballStr;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            Scanner sc = new Scanner(System.in);
            userBaseballStr = sc.next();

            // TODO : Verify BaseBall Game Number

        } while (!ProgramUtils.isNumeric(userBaseballStr));

        System.out.println(getRandomNumStr());
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
