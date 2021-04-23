import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseBallPlayer {

    public static void play() {
        Scanner scan = new Scanner(System.in);
        BaseBall game = new BaseBall();
        boolean isFinish = false;

        while (!isFinish) {
            BaseBallDto.Result result = game.getUserResult(askAnswer(scan));
            printResultMessage(result);
            isFinish = result.getIsAnswer() ? game.finish(askFinish(scan)) : false;
        }
        scan.close();
    }

    private static List<Integer> askAnswer(Scanner scan) {
        List<Integer> converted = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String[] userResponse = String.valueOf(scan.nextInt()).split("");

        for (int i = 0; i < userResponse.length; ++i) {
            converted.add(Integer.valueOf(userResponse[i]));
        }

        return converted;
    }

    private static boolean askFinish(Scanner scan) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userResponse = scan.nextInt();

        if (userResponse == 1) {
            return false;
        }

        return true;
    }

    private static void printResultMessage(BaseBallDto.Result result) {
        if (result.getStrike() + result.getBall() < 1) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(getMessageByResult(result.getStrike(), result.getBall()));

        if (result.getIsAnswer()) {
            System.out.println(result.getStrike() + "개의 숫자를 모두 맞추셨습니다! 게임 종료");
        }
    }

    private static String getMessageByResult(int strike, int ball) {
        StringBuilder message = new StringBuilder();

        if (strike > 0) {
            message.append(strike + " 스트라이크 ");
        }
        if (ball > 0) {
            message.append(ball + " 볼");
        }

        return message.toString().trim();
    }
}
