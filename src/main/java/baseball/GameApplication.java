package baseball;

import baseball.model.Hitter;
import baseball.model.Pitcher;
import baseball.model.Referee;
import baseball.util.Util;

public class GameApplication {

    private static final short MAX_PITCHING_COUNT = 3; // 최대 투구 수
    private static final String CHOOSE_RESUME_OR_STOP_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다.";

    public static void main(String[] args) {
        while (true) {
            boolean isGameOver = playGame(); // 게임시작

            if (isGameOver) {
                chooseResumeOrStop(); // 게임 재시작/종료 선택
            }
        }
    }

    /**
     * 게임시작
     *
     * @return 3스트라이크(게임종료) 여부 반환
     */
    private static boolean playGame() {
        Pitcher pitcher = new Pitcher(MAX_PITCHING_COUNT); // 투수(선언)
        pitcher.pitching(); // 투구
        Hitter hitter = new Hitter(); // 타자(선언)
        hitter.betting(pitcher.getPitches().length()); // 타격
        Referee referee = new Referee(); // 심판(선언)
        referee.judge(pitcher.getPitches(), hitter.getBets()); // 심판의 투구결과 판단
        referee.printResult(pitcher.getPitches().length()); // 게임결과 선언(출력)

        return referee.getBallCount().getStrikeCount() == pitcher.getPitches().length();
    }

    /**
     * 게임 재시작/종료 선택
     */
    private static void chooseResumeOrStop() {
        String input = Util.input(CHOOSE_RESUME_OR_STOP_MESSAGE);

        if (!input.equals("1") && !input.equals("2")) {
            System.out.println(INVALID_INPUT_MESSAGE);
            chooseResumeOrStop();
        }

        if (input.equals("2")) {
            System.exit(0);
        }
    }

}
