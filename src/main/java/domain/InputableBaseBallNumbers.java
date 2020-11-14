package domain;

public class InputableBaseBallNumbers extends BaseBallNumbers {
    public InputableBaseBallNumbers(String input) {
        char[] numbers = input.toCharArray();
        this.setBaseBallNumbers(convertChars2BaseBallNumbers(numbers));
    }

    private BaseBallNumber[] convertChars2BaseBallNumbers(char[] chars) {
        BaseBallNumber[] baseBallNumbers = new BaseBallNumber[chars.length];
        for (int i = 0; i < chars.length; i++) {
            baseBallNumbers[i] = new BaseBallNumber(chars[i] - '0');
        }
        return baseBallNumbers;
    }
}
