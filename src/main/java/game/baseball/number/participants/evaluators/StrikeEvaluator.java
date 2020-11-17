package game.baseball.number.participants.evaluators;

import game.baseball.number.utils.CollectionUtil;
import game.baseball.number.utils.ConsoleOutputUtil;
import java.util.Iterator;

class StrikeEvaluator implements Evaluator {

    private static final String STRIKE_TEXT = " 스트라이크";
    private static final int ANSWER = 3;

    @Override
    public boolean test(String pitchedNumbers, String hitNumbers) {
        int strikes = countStrikes(pitchedNumbers.toCharArray(), hitNumbers.toCharArray());
        return strikes == ANSWER;
    }

    private int countStrikes(char[] pitchedNumbers, char[] hitNumbers) {
        int count = 0;
        Iterator<Character> pitchedIterator = CollectionUtil.toList(pitchedNumbers).iterator();
        Iterator<Character> hitIterator = CollectionUtil.toList(hitNumbers).iterator();
        while (pitchedIterator.hasNext() && hitIterator.hasNext()) {
            count += addCount(pitchedIterator.next(), hitIterator.next());
        }
        if (count > 0) {
            ConsoleOutputUtil.print(count + STRIKE_TEXT);
        }
        return count;
    }

    private int addCount(char a, char b) {
        if (a == b) {
            return 1;
        }
        return 0;
    }
}
