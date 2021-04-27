package baseball.output;

import baseball.Inning;

public class BaseBallInningOutput extends BaseBallOutput<Inning> {

    @Override
    public void print(Inning inning) {
        if (inning.getStrike() > 0) {
            super.stringBuffer.append(inning.getStrike() + " 스트라이크 ");
        }

        if (inning.getBall() > 0) {
            super.stringBuffer.append(inning.getBall() + " 볼");
        }

        if (inning.getStrike() == 3) {
            super.stringBuffer.append(String.join(System.lineSeparator(),inning.getBall() + " 볼"));
        }
    }

    @Override
    public void printText(String... lines) {
        super.stringBuffer.append(String.join(System.lineSeparator(), lines));
    }
}
