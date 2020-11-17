package com.baseball.game.type;

import com.baseball.game.domain.Batter;
import com.baseball.game.domain.Pitcher;
import com.baseball.game.domain.ResultBoard;
import com.baseball.game.service.GameOperator;

import java.util.Arrays;

import static com.baseball.game.common.Utils.inputNumber;
import static com.baseball.game.common.Utils.isNumberRange;

public enum GameState implements GameOperator {
    START(1){
        public boolean operate() {
            System.out.println("투수 등장...");
            Pitcher pitcher = Pitcher.create();
            System.out.println(pitcher.toString());

            while (!getResultBoard(pitcher)){}

            System.out.println("타자 아웃!");
            return false;
        }
    },
    END(2){
        public boolean operate() {
            System.out.println("======================== 게임을 종료 합니다 ========================");
            System.exit(0);

            return true;
        }
    }
    ;

    private int state;
    GameState(int state) {
        this.state = state;
    }

    public boolean getResultBoard(Pitcher pitcher) {
        System.out.print("숫자를 입력해주세요(1~9까지 서로 다른 3자리 수): ");
        Batter batter = Batter.create(inputNumber());
        ResultBoard resultBoard = ResultBoard.of(pitcher, batter);
        System.out.println(resultBoard.toString());

        return resultBoard.isOut();
    }

    public static GameState findByGameState(int state){
        isNumberRange(START.getState(), END.getState(), state);
        return Arrays.stream(GameState.values()).filter(gameState -> gameState.getState() == state).findFirst().get();
    }

    public int getState() {
        return state;
    }
}
