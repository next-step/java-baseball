package khj.baseball;

import khj.baseball.exception.DuplicateInputException;
import khj.baseball.exception.LengthWrongInputException;
import khj.baseball.exception.TypeWrongInputException;
import khj.baseball.util.generator.RandomNumberStringGenerator;
import khj.baseball.util.generator.RandomStringGenerator;
import khj.baseball.util.input.InputProcessor;
import khj.baseball.util.input.NumberInputProcessor;
import khj.baseball.util.match.DefaultStringMatch;
import khj.baseball.util.match.StringMatch;

public class BaseBallGames {
    private final RandomStringGenerator generator;
    private final InputProcessor inputProcessor;
    private final StringMatch match;
    private int checkStringSize = 3;

    public BaseBallGames () {
        generator = new RandomNumberStringGenerator();
        inputProcessor = new NumberInputProcessor();
        match = new DefaultStringMatch();
    }

    public void play() {
        String answer = generator.generatorString(checkStringSize);
        Record record = new Record();
        while (!record.isComplete(checkStringSize)) {
            String checkString = inputCheckString();
            record = match.matchString(checkString, answer);
            printResult(record);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private String inputCheckString() {
        String input = "";
        do {
            System.out.print("숫자를 입력해주세요 : ");
            input = inputCatchException(input);
        } while (input.equals(""));
        return input;
    }

    private String inputCatchException(String input) {
        try {
            input = inputProcessor.inputNumberString(checkStringSize);
        } catch (TypeWrongInputException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
        } catch (LengthWrongInputException e) {
            System.out.println("[ERROR] " + checkStringSize + "자리 숫자를 입력해주세요.");
        } catch (DuplicateInputException e) {
            System.out.println("[ERROR] 중복된 숫자를 입력하셨습니다.");
        }
        return input;
    }

    private void printResult(Record record) {
        if (record.isNoting()) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(record.getStrike() + " 스트라이크 " + record.getBall() +  " 볼");
    }
}
