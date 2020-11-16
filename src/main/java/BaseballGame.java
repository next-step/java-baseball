import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    int strike = 0;
    int ball = 0;
    static char menu = ' ';

    public String getNum() {
        Random random = new Random();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int tmp = 0;
        for (int i = 0; i < 100; i++) {
            int j = random.nextInt(9);
            tmp = arr[0];
            arr[0] = arr[j];
            arr[j] = tmp;
        }
        return "" + arr[0] + arr[1] + arr[2];
    }

    public void playGame() {
        String com = getNum();
        System.out.println("computer number : " + com);
        String user = "";
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("input user number : ");
            user = in.next();
            scoreValue(com, user);
            inspectResult(strike, ball);
        } while (!com.equals(user));
    }

    private void scoreValue(String com, String user) {
        for (int i = 0; i < com.length(); i++) {
            for (int j = 0; j < user.length(); j++) {
                if (com.charAt(i) == user.charAt(j)) {
                    if (i == j) ++strike;
                    if (i != j) ++ball;
                }
            }
        }
    }

    private void inspectResult(int strike, int ball) {
        if (strike != 0) System.out.println(strike + " strike ");
        if (ball != 0) System.out.println(ball + " ball ");
        if (strike == 0 && ball == 0) System.out.println("Nothing!");
        this.strike = 0;
        this.ball = 0;
    }

    private static void selectMenu() {
        try {
            menu = (char)System.in.read();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BaseballGame bg = new BaseballGame();
        do {
            bg.playGame();
            System.out.print("메뉴<다시시작(1) | 완전히 종료(2)>를 선택하세요 : ");
            selectMenu();
            if (menu == '2') break;
        } while (menu == '1');
    }
}
