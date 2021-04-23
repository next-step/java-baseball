public class BaseBallReferee {

    private int nothing;
    private int ball;
    private int strike;

    private void initScore() {
        this.nothing = 0;
        this.strike = 0;
        this.ball = 0;
    }

    private void judgeScore(int index, int hitIndex) {
        if (hitIndex == -1) {
            nothing++;
            return;
        }

        if (index != hitIndex) {
            ball++;
            return;
        }

        strike++;
    }

    private void printScore() {
        if (this.nothing == PlayGame.RANDOM_NUMBER_LENGTH) {
            System.out.println("낫싱");
            return;
        }

        if (this.ball > 0 && this.strike > 0){
            System.out.println(String.format("%d 스트라이크 %d 볼", this.strike, this.ball));
            return;
        }

        if (this.ball == 0 || this.strike == PlayGame.RANDOM_NUMBER_LENGTH) {
            System.out.println(String.format("%d 스트라이크", this.strike));
            return;
        }

        if (this.strike == 0 || this.ball == PlayGame.RANDOM_NUMBER_LENGTH) {
            System.out.println(String.format("%d 볼", this.ball));
            return;
        }

        System.out.println(String.format("%d 스트라이크 %d 볼 %d 낫싱", this.strike, this.ball, this.nothing));
    }

    private int countStrike(String pitcherNumber, String batterNumber) {
        initScore();
        // 숫자 값이 없으면 -1(nothing) 값이 있을 때 hit 과 i 값 비교
        for (int i = 0; i < PlayGame.RANDOM_NUMBER_LENGTH; i++) {
            String pitchNumber = pitcherNumber.substring(i, i+1);
            int hitIndex = batterNumber.indexOf(pitchNumber);
            judgeScore(i, hitIndex);
        }

        return this.strike;
    }

    /**
     * pitcher(투수, 컴퓨터) 와 batter(타자, 사용자) 의 입력 값을 비교
     *
     * @param pitcherNumber 투수, 컴퓨터의 난수
     * @param batterNumber  타자, 사용자의 입력 값
     * @return strike 유효타
     */
    public int judgeGame(String pitcherNumber, String batterNumber) {
        int strike = countStrike(pitcherNumber, batterNumber);
        printScore();
        return strike;
    }
}
