package bymin.game.master;

import bymin.game.play.GamePlay;
import bymin.game.play.MakeNumberBaseBall;

import java.util.HashMap;
import java.util.Map;

public class GameMaster {
    GamePlay gamePlay = new GamePlay();
    MakeNumberBaseBall makeNumberBaseBall = new MakeNumberBaseBall();

    // 게임 시작시, 숫자 야규의 정 3개를
    public GameMaster() {
        makeNumberBaseBall.make();
    }

    public void whilLoopStartePlay() {
        boolean endFlag = true;	// 종료를 판단하는 조건절
        while (endFlag) {
            String end = gamePlayCall();
            if ("1".equals(end)) makeNumberBaseBall.make();
            if ("2".equals(end)) endFlag = false;
        }
    }

    public String gamePlayCall(){
        Map<String, Integer> mapResult = new HashMap<>();
        mapResult.put("스트라이크", 0);
        mapResult.put("볼", 0);
        String run = gamePlay.run();
        return gamePlay.play(mapResult, run, makeNumberBaseBall.getNumList());
    }
}
