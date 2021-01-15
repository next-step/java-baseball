import java.util.Scanner;

public class PlayBaseball {
    public int oneGame() {
        Scanner sc = new Scanner(System.in);
        int try_ans;
        int ans;
        int stop;
        String res;

        ans = makeAnswer();

        while (true) {
            System.out.print("숫자를 입력 주세요 : ");
            try_ans = sc.nextInt();
            res = getResult(ans, try_ans);
            System.out.println(res);
            if (res == "3스트라이크") {
                break;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        stop = sc.nextInt();
        while (stop != 1 && stop != 2) {
            System.out.println("잘못된 입렵입니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            stop = sc.nextInt();
        }
        return stop;
    }


    public static void main(String[] args) throws Exception{
        int stop;

        while (true) {
            stop = oneGame();
            if (stop == 2) {
                break;
            }
        }
    }
}
