package baseball;

public final class BaseballGameModel {

    private String userInput;

    public BaseballGameModel(String userInput) {
        this.userInput = userInput;
    }

    public String userInput() {
        if (hasThreeLength(userInput) == false || isOnlyInteger(userInput) == false) {
            throw new IllegalArgumentException("3자리 숫자만 허용합니다.");
        }

        return userInput;
    }

    private boolean hasThreeLength(String userInput) {
        return userInput.length() == 3;
    }

    private boolean isOnlyInteger(String userInput) {
        char[] chars = userInput.toCharArray();
        for (char aChar : chars) {
            if (Character.isDigit(aChar) == false) {
                return false;
            }
        }
        return true;
    }
}
