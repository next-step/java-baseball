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
            end(strikeCount);
        }
    }

    private void end(int strikeCount) {
        if (strikeCount == PlayGame.RANDOM_NUMBER_LENGTH) {
            System.out.println(String.format("%d 개의 숫자를 모두 맞히셨습니다! 게임 종료", PlayGame.RANDOM_NUMBER_LENGTH));
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String reGame = PlayGame.scanner.nextLine();
            replay(reGame);
        }
    }

    private void replay(String reGame) {
        if ("1".equals(reGame)) {
            pitcherNumber = getPitcherNumber();
            playGame = true;
            return;
        }

        playGame = false;
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
