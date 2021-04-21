import java.util.HashMap;
import java.util.Map;

public class BaseBall {

    private String answer;

    public BaseBall(String answer) {
        this.answer = answer;
    }

    public Map<Character, Integer> play(String input) {
        if (notContainsByAnswer(input)) {
            return new HashMap<>();
        }

        int sizeOfInput = input.length();
        Map<Character, Integer> hint = new HashMap<>();
        for (int i = 0; i < sizeOfInput; i++) {
            if (answer.charAt(i) == input.charAt(i)) {
                hint.put('S', hint.getOrDefault('S', 0) + 1);
            }
        }

        for (int i = 0; i < sizeOfInput; i++) {
            if (answer.indexOf(input.charAt(i)) != -1 && answer.charAt(i) != input.charAt(i)) {
                hint.put('B', hint.getOrDefault('B', 0) + 1);
            }
        }

        return hint;
    }

    private boolean notContainsByAnswer(String playerInput) {
        return !answer.contains(playerInput);
    }
}
