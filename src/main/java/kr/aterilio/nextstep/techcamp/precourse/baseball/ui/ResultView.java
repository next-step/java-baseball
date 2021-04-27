package kr.aterilio.nextstep.techcamp.precourse.baseball.ui;

import kr.aterilio.nextstep.techcamp.precourse.baseball.Judgement;

public class ResultView {

    private static final String MSG_RESULT_CLEAR = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String MSG_RESULT_NOTHING = "낫싱";
    private static final String MSG_RESULT_STRIKE = "%d 스트라이크 ";
    private static final String MSG_RESULT_BALL = "%d 볼 ";
    
    private static final int NOTHING = 0;

    public void printResult(Judgement judgement) {
        System.out.println(getMsg(judgement));
    }
    
    public String getMsg(Judgement judgement) {
        if ( judgement.isClear() ) {
            return MSG_RESULT_CLEAR;
        }
        if ( judgement.isNothing() ) {
            return MSG_RESULT_NOTHING;
        }
        return getStrikeOrBall(judgement);
    }

    private String getStrikeOrBall(Judgement judgement) {
        return getStrike(judgement) + getBall(judgement);
    }

    private String getStrike(Judgement judgement) {
        int strike = judgement.strike();
        if ( strike != NOTHING ) {
            return String.format(MSG_RESULT_STRIKE, strike);
        }
        return "";
    }

    private String getBall(Judgement judgement) {
        int ball = judgement.ball();
        if ( ball != NOTHING ) {
            return String.format(MSG_RESULT_BALL, ball);
        }
        return "";
    }
}
