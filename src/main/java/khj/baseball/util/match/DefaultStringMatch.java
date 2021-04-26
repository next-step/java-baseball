package khj.baseball.util.match;

import khj.baseball.model.Record;

public class DefaultStringMatch implements StringMatch {
    private Record record;

    @Override
    public Record matchString(String expected, String actual) {
        record = new Record();
        char[] inputStrArr = expected.toCharArray();

        for (int index = 0; index < inputStrArr.length; index++) {
            int matchingIndex = actual.indexOf(inputStrArr[index]);

            isStrikeAddCounting(index, matchingIndex);
            isBallAddCounting(index, matchingIndex);
        }
        return record;
    }

    private void isStrikeAddCounting(int index, int matchingIndex) {
        if (matchingIndex != -1 && matchingIndex == index) {
            record.addStrike();
        }
    }

    private void isBallAddCounting(int index, int matchingIndex) {
        if (matchingIndex != -1 && matchingIndex != index) {
            record.addBall();
        }
    }
}
