package baseball.match;

import baseball.Inning;

public class BaseBallInningPlay implements BaseBallPlay {
    @Override
    public Inning play(int[] source, int[] target) {
        int strike = 0;
        int ball = 0;

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if(source[i] == target[j]) {
                  if(i == j) {
                      strike++;
                  } else {
                      ball++;
                  }
                }
            }
        }

        return new Inning(strike, ball);
    }
}
