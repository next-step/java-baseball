import java.util.*;

public class BaseBall {
    private static final List<Integer> DEFAULT_RANGE = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static final int DEFAULT_LENGTH = 3;

    private List<Integer> answer;

    public BaseBall() {
        this.answer = makeAnswer();
    }

    public BaseBall(List<Integer> answer) {
        this.answer = answer;
    }

    public static void play() {
        Scanner scan = new Scanner(System.in);
        BaseBall game = new BaseBall();
        boolean isFinish = false;

        while (!isFinish) {
            List<Integer> userAnswer = game.askAnswer(scan);
            boolean isAnswer = game.isAnswer(userAnswer);
            if (isAnswer) isFinish = game.finish(game.askFinish(scan));
        }
        scan.close();
    }

    public static List<Integer> makeAnswer() {
        List<Integer> copy = new ArrayList<>(DEFAULT_RANGE);
        Collections.shuffle(copy);
        return copy.subList(0, DEFAULT_LENGTH);
    }

    public boolean isAnswer(List<Integer> userAnswer) {
        int strike = getStrike(userAnswer);
        int ball = getBall(userAnswer) - strike;

        System.out.println(resultMessage(strike, ball));
        if (strike == DEFAULT_LENGTH) {
            System.out.println(DEFAULT_LENGTH + "개의 숫자를 모두 맞추셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    public boolean finish(boolean isFinish) {
        if (!isFinish) refresh();
        return isFinish;
    }

    private List<Integer> askAnswer(Scanner scan) {
        List<Integer> converted = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String[] userResponse = String.valueOf(scan.nextInt()).split("");
        for (int i = 0; i < userResponse.length; ++i) {
            converted.add(Integer.valueOf(userResponse[i]));
        }

        return converted;
    }

    private boolean askFinish(Scanner scan) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userResponse = scan.nextInt();
        if (userResponse == 1) {
            return false;
        }
        return true;
    }

    private void refresh() {
        answer = makeAnswer();
    }

    private String resultMessage(int strike, int ball) {
        StringBuilder message = new StringBuilder();

        if (strike + ball < 1) {
            message.append("일치하는 숫자가 존재하지 않습니다.");
            return message.toString();
        }
        if (strike > 0) message.append(strike + " 스트라이크 ");
        if (ball > 0) message.append(ball + " 볼");

        return message.toString().trim();
    }

    private int getBall(List<Integer> userAnswer) {
        int ball = 0;

        for (int i = 0; i < answer.size(); ++i) {
            if (answer.contains(userAnswer.get(i))) ++ball;
        }

        return ball;
    }

    private int getStrike(List<Integer> userAnswer) {
        int strike = 0;

        for (int i = 0; i < answer.size(); ++i) {
            if (answer.get(i).equals(userAnswer.get(i))) ++strike;
        }

        return strike;
    }
}
