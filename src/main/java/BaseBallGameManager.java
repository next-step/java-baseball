import java.util.*;

public class BaseBallGameManager {
    private boolean playGame = true;
    private String pitcherNumber;
    private final BaseBallReferee referee = new BaseBallReferee();
    private final BaseBallBatter batter = new BaseBallBatter();
    private final BaseBallPitcher pitcher = new BaseBallPitcher();

    public void start() {
        pitcherNumber = getPitcherNumber();
        System.out.println(pitcherNumber);
        while (playGame) {
            String batterNumber = batter.getUserInput();
            // 심판 입장
            int strikeCount = referee.judgeGame(pitcherNumber, batterNumber);
        }
    }

    private String implode(Set<Integer> set) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : set) {
            stringBuilder.append(integer);
        }
        return stringBuilder.toString();
    }

    private String getPitcherNumber() {
        Set<Integer> pitcherChoice = pitcher.generateRandomNumber();
        return implode(pitcherChoice);
    }
}
