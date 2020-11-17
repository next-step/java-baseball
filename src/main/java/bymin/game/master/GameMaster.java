package bymin.game.master;

import bymin.game.constans.GameResult;
import bymin.game.constans.Rule;
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
            if (Rule.REGAME.getPlayType().equals(end)) makeNumberBaseBall.make();
			if (Rule.STOP.getPlayType().equals(end)) endFlag = false;
        }
    }

    public String gamePlayCall(){
        Map<String, Integer> mapResult = new HashMap<>();
        mapResult.put(GameResult.STRIKE, 0);
        mapResult.put(GameResult.BALL, 0);
        String setString = gamePlay.run();
        return gamePlay.play(mapResult, setString, makeNumberBaseBall.getNumList());
    }
}
