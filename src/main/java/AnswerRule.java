import java.util.HashSet;
import java.util.StringTokenizer;

public class AnswerRule {

    private final int VALID_LENGTH = 3;

    private boolean duplicated = false;

    private HashSet<String> tokens;

    public boolean isValidate(String userAnswer) {
        if (!checkValidLength(userAnswer)) {
            return false;
        }

        int index = 0;
        tokens = new HashSet<>();
        while (!duplicated && index++ < userAnswer.length() - 1) {
            checkDuplicate(userAnswer, index);
        }

        return !duplicated;
    }

    private void checkDuplicate(String userAnswer, int index) {
        String userAnswerToken = String.valueOf(userAnswer.charAt(index));
        if(tokens.contains(userAnswerToken)) {
            duplicated = true;
            return;
        }
        tokens.add(userAnswerToken);
    }

    private boolean checkValidLength(String userAnswer) {
        if (userAnswer.length() != VALID_LENGTH) {
            return false;
        }
        return true;
    }
}
