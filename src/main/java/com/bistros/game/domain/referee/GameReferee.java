package com.bistros.game.domain.referee;

import com.bistros.game.domain.BallNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임의 정답을 체크하는 심판 클래스. 처음에 생성될 때 정답을 알고 있다.
 * 사용자의 입력을 받아 게임 결과를 알려준다. (hit 출력은 별도로 처리)
 */
public class GameReferee {

    private final BallNumbers ballNumbers;

    public GameReferee(BallNumbers ballNumbers) {
        this.ballNumbers = ballNumbers;
    }

    public InningReport check(List<Integer> userInputs) {
        List<InningReport.HIT> checks = new ArrayList<>();

        for (int index = 0; index < BallNumbers.LENGTH; index++) {
            Integer userInput = userInputs.get(index);
            checks.add(checkBall(index, userInput));
        }
        return new InningReport(checks);
    }

    private InningReport.HIT checkBall(int index, int userInputNumber) {
        if (ballNumbers.isNothing(userInputNumber)) {
            return InningReport.HIT.NOTHING;
        }
        if (index == ballNumbers.isStrike(userInputNumber)) {
            return InningReport.HIT.STRIKE;
        }
        return InningReport.HIT.BALL;

    }
}
