import java.util.*;

public class BaseBall {

    public String unique3DigitString() {
        Integer[] arrNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> numbers = new ArrayList<>(Arrays.asList(arrNumbers));
        Collections.shuffle(numbers);

        return numbers.get(0) + "" + numbers.get(1) + "" + numbers.get(2);
    }

    public boolean checkUnique3DigitString(String input) {
        Set<String> unique = new HashSet<>(Arrays.asList(input.split("")));

        return input.matches("\\d{3}") && unique.size() == 3;
    }

    public Map<String, Integer> judgeBaseBall(String goal, String source) {
        int strike = checkStrike(goal, source);
        int ball = checkBall(goal, source);

        Map<String, Integer> result = new HashMap<>();
        result.put("STRIKE", strike);
        result.put("BALL", ball);
        return result;
    }

    private int checkStrike(String goal, String source) {
        int result = 0;
        for (int i = 0; i < goal.length(); i++) {
            result += cntStrike(goal.charAt(i), source.charAt(i));
        }
        return result;
    }

    private int cntStrike(char goal, char source) {
        return goal == source ? 1 : 0;
    }

    private int checkBall(String goal, String source) {
        int result = 0;
        for (int i = 0; i < goal.length(); i++) {
            result += cntBall(goal, source.charAt(i), i);
        }
        return result;
    }

    private int cntBall(String goal, char source, int i) {
        int index = goal.indexOf(source);
        return index >= 0 && index != i ? 1 : 0;
    }
}
