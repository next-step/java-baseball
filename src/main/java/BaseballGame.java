import java.util.Scanner;

public class BaseballGame {

    private final int LENGTH_OF_NUMBER = 3;

    private ComputerNumber computerNumber;
    private PlayerNumber playerNumber;
    private BaseballGameNumberComparator comparator;

    public BaseballGame() {
        computerNumber = new ComputerNumber(LENGTH_OF_NUMBER);
        playerNumber = new PlayerNumber(LENGTH_OF_NUMBER);
        comparator = new BaseballGameNumberComparator(LENGTH_OF_NUMBER);
    }

    public void run() {
        int check = 0;
        Scanner scan = new Scanner(System.in);
        do {
            playGame();
            printEndState();
            check = scan.nextInt();
        } while (check == 1);
    }

    public void playGame() {
        int answer  = computerNumber.getNumber();
        int input = 0;
        do {
            input = playerNumber.getNumber();
            int strike = comparator.getStrike(answer, input);
            int ball = comparator.getBall(answer, input);
            printResult(strike, ball);
        } while(answer != input);
    }

    public void printEndState() {
        System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 아무 숫자나 입력해주세요.");
    }

    public void printResult(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (strike > 0) {
            sb.append(strike).append(" 스트라이크");
        }
        if (ball > 0) {
            sb.append(ball).append("볼");
        }
        if (sb.length() == 0) {
            sb.append("낫싱");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        game.run();
    }

}
