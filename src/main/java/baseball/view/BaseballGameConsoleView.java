package baseball.view;


import baseball.GameResult;

public class BaseballGameConsoleView implements BaseballGameView {

    @Override
    public void showBallCountMessage(GameResult result) {
        StringBuilder sb = new StringBuilder();
        int strike = result.getStrike();
        int ball = result.getBall();
        if (hasNonCount(strike, ball)) {
            print(sb.append("낫씽").toString());
            return;
        }
        appendMessageIfExists(strike, ball, sb, strike + " 스트라이크");
        appendMessageIfExists(ball, sb, ball + " 볼");
        print(sb.toString());
    }

    @Override
    public void showAskingForInputMessage() {
        System.out.print("숫자를 입력해주세요: ");
    }

    @Override
    public boolean showFinishMessage(boolean roundFinished) {
        if (roundFinished) {
            print("3개의 숫자를 모두 맞히셨습니다! 게임종료.");
            print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        return roundFinished;
    }

    private void appendMessageIfExists(int strike, int ball, StringBuilder sb, String str) {
        if (isNotZero(strike)) {
            sb.append(str);
            appendMessageIfExists(ball, sb, " ");
        }
    }

    private void appendMessageIfExists(int ball, StringBuilder sb, String message) {
        if (isNotZero(ball)) {
            sb.append(message);
        }
    }

    private boolean isNotZero(int num) {
        return num != 0;
    }

    private boolean hasNonCount(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

    private void print(String messages) {
        System.out.println(messages);
    }
}
