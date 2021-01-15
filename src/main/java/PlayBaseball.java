import java.util.Scanner;

public class PlayBaseball {
    public String getResult(int ans, int check){
        int[] ans_arr = {(ans - (ans % 100)) / 100, (ans % 100 - ans % 10) / 10, ans % 10};
        int[] check_arr = {(check - (check % 100)) / 100, (check % 100 - check % 10) / 10, check % 10};
        int strike = 0;
        int ball = 0;
        String res = "";

        if (ans_arr[0] == check_arr[0]) {
            strike++;
        } else if (ans_arr[0] == check_arr[1]) {
            ball++;
        } else if (ans_arr[0] == check_arr[2]) {
            ball++;
        }

        if (ans_arr[1] == check_arr[1]) {
            strike++;
        } else if (ans_arr[1] == check_arr[0]) {
            ball++;
        } else if (ans_arr[1] == check_arr[2]) {
            ball++;
        }

        if (ans_arr[2] == check_arr[2]) {
            strike++;
        } else if (ans_arr[2] == check_arr[0]) {
            ball++;
        } else if (ans_arr[2] == check_arr[1]) {
            ball++;
        }

        String str_strike = Integer.toString(strike);
        String str_ball = Integer.toString(ball);

        if (ball != 0) {
            res = str_ball + "볼";
        }
        if (strike != 0) {
            if (res != "") {
                res = res + " ";
            }
            res = res + str_strike + "스트라이크";
        }
        if (res == "") {
            res = "낫싱";
        }
        return res;
    }

    public int oneGame() {
        PlayBaseball myGame = new PlayBaseball;
        Scanner sc = new Scanner(System.in);
        int try_ans;
        int ans;
        int stop;
        String res;

        ans = myGame.makeAnswer();

        while (true) {
            System.out.print("숫자를 입력 주세요 : ");
            try_ans = sc.nextInt();
            res = myGame.getResult(ans, try_ans);
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
        PlayBaseball myGame = new PlayBaseball;
        int stop;

        while (true) {
            stop = myGame.oneGame();
            if (stop == 2) {
                break;
            }
        }
    }
}