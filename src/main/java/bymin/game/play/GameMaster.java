package bymin.game.play;

import java.util.HashMap;
import java.util.Map;

public class GameMaster {
    GamePlay gamePlay = new GamePlay();
    MakeNumberBaseBall makeNumberBaseBall = new MakeNumberBaseBall();

    public GameMaster() {
        makeNumberBaseBall.make();
    }

    public void whilePlay () {
        boolean endFlag = true;
        while (endFlag) {
            String end = whileRun();
            if ("1".equals(end)) makeNumberBaseBall.make();
            if ("2".equals(end)) endFlag = false;
        }
    }

    public String whileRun(){
        Map<String, Integer> mapResult = new HashMap<>();
        mapResult.put("스트라이크", 0);
        mapResult.put("볼", 0);
        String run = gamePlay.run();
        System.out.println(run);
        return gamePlay.play(mapResult, run, makeNumberBaseBall.getNumList());
    }
}
