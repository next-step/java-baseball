package game.baseball.number.participants.evaluators;

import static game.baseball.number.utils.CollectionUtil.toList;

import game.baseball.number.utils.ConsoleOutputUtil;
import java.util.List;

class BallEvaluator implements Evaluator {

    private static final String BALL_TEXT = " 볼";
    public static final String BLANK = " ";
    public static final int NOT_EXIST = -1;

    @Override
    public boolean test(String pitchedNumbers, String hitNumbers) {
        int balls = countBalls(pitchedNumbers, hitNumbers);
        return balls == 0;
    }

    private int countBalls(String pitchedNumbers, String hitNumbers) {
        int count = 0;
        List<Character> pitchedList = toList(pitchedNumbers.toCharArray());
        List<Character> hitList = toList(hitNumbers.toCharArray());
        for (int i = 0; i < pitchedList.size(); i++) {
            count += addCount(i, pitchedList.get(i), hitList);
        }
        if (count > 0) {
            ConsoleOutputUtil.print(BLANK + count + BALL_TEXT);
        }
        return count;
    }

    private int addCount(int index, Character character, List<Character> hitList) {
        int indexOf = hitList.indexOf(character);
        if (indexOf != NOT_EXIST && indexOf != index) {
            return 1;
        }
        return 0;
    }
}
