package baseball.model;

public class Referee {

    private final String PRINT_BALL_COUNT_PATTERN = "%d 스트라이크 ";
    private final String PRINT_STRIKE_COUNT_PATTERN = "%d 볼";
    private final String PRINT_GAME_OVER_PATTERN = "\r\n%d개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String PRINT_NOTHING = "낫싱";

    private BallCount ballCount;

    public Referee() {
        ballCount = new BallCount();
    }

    /**
     * 투구결과 판단
     *
     * @param pitches
     * @param bets
     * @return
     */
    public void judge(String pitches, String bets) {
        for (int i = pitches.length() - 1; i >= 0; i--) {
            if (isStrikeZone(pitches, bets, i)) { // 스트라이크 판단
                ballCount.strike();
                continue;
            }

            if (isBallZone(pitches, bets, i)) { // 볼 판단
                ballCount.ball();
            }
        }
    }

    /**
     * 스트라이크 판단
     *
     * @param pitches
     * @param bets
     * @param i
     * @return
     */
    private boolean isStrikeZone(String pitches, String bets, int i) {
        return pitches.charAt(i) == bets.charAt(i);
    }

    /**
     * 볼인지 판단
     *
     * @param pitches
     * @param bets
     * @param i
     */
    private boolean isBallZone(String pitches, String bets, int i) {
        for (int j = 0; j < bets.length(); j++) {
            if (pitches.charAt(i) == bets.charAt(j)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 게임결과 선언(출력)
     *
     * @param pitchingCount
     */
    public void printResult(int pitchingCount) {
        String resultMessage = (ballCount.hasStrikeCount()) ? String.format(PRINT_BALL_COUNT_PATTERN, ballCount.getStrikeCount()) : "";
        resultMessage += (ballCount.hasBallCount()) ? String.format(PRINT_STRIKE_COUNT_PATTERN, ballCount.getBallCount()) : "";
        resultMessage += (ballCount.isOut(pitchingCount)) ? String.format(PRINT_GAME_OVER_PATTERN, pitchingCount) : "";
        resultMessage += ballCount.isNothing() ? PRINT_NOTHING : "";

        System.out.println(resultMessage);
    }

    /**
     * 볼카운트 반환
     *
     * @return
     */
    public BallCount getBallCount() {
        return ballCount;
    }

}
