import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    private static final Random random = new Random();
    private static final Scanner sc = new Scanner(System.in);
    private static final int MAX = 3;

    private int number;
    private boolean matched;

    public BaseballGame() {
        number = 0;
        matched = false;
    }

    public void setRandomNumber() {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int ret = 0;
        for (int i = 0; i < MAX; i++) {
            int num = random.nextInt(7 - i) + 1;
            ret = ret * 10 + arr.get(num);
            arr.set(num, arr.get(arr.size() - 1));
            arr.remove(arr.size() - 1);
        }
        setNumber(ret);
    }

    public boolean matching(int guessNumber) {
        String origin = number + "";
        String src = guessNumber + "";
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < MAX; i++) {
            strikes += origin.charAt(i) == src.charAt(i) ? 1 : 0;
            balls += origin.charAt(i) != src.charAt(i) && origin.contains(src.charAt(i) + "") ? 1 : 0;
        }
        System.out.println(getResult(strikes, balls));
        return false;
    }

    public void runGame() {
        while (!matched) {
            System.out.println("숫자를 입력해주세요 : ");
            matched = matching(sc.nextInt());
        }
    }

    public String getResult(int strikes, int balls) {
        if (strikes == 3) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임종료";
        }
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }
        return getScore(strikes, balls);
    }

    public String getScore(int strikes, int balls) {
        String ret = "";
        if (strikes > 0) {
            ret += strikes + " 스트라이크 ";
        }
        if (balls > 0) {
            ret += balls + " 볼";
        }
        return ret;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
