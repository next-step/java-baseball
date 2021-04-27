import java.util.Scanner;

public class BaseballGame {
    private int[] balls;

    public void start() {
        boolean restart = true;
        do {
            Baseball baseball = new Baseball();
            balls = baseball.createNumberArray();
            restart = getUserInput();
        } while (restart == true);
    }

    public boolean getUserInput() {
        Scanner s = new Scanner(System.in);
        boolean result = false;
        boolean restart = false;
        int value = 0;
        do {
            System.out.print("숫자를 입력해주세요: ");
            value = s.nextInt();
            Calculation cal = new Calculation(balls, value);
            result = result(cal);
        } while (result == false);
        return shouldRestart();
    }

    public boolean shouldRestart() {
        Scanner s = new Scanner(System.in);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (s.nextInt() == 1) {
            return true;
        }
        return false;
    }

    public boolean result(Calculation cal) {
        System.out.println(cal.getResultString());
        if (cal.getStrike() == 3) {
            return true;
        }
        return false;
    }
}
