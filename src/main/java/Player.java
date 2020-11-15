import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private final String INPUT_MSG = "숫자를 입력해주세요 : ";

    private ArrayList<Integer> numberList;
    private int strikeCount = 0;
    private int ballCount = 0;

    Scanner sc = new Scanner(System.in);

    public Player() {}

    public int requestInput(boolean isPlaying) {
        if (isPlaying) System.out.print(INPUT_MSG);
        String input = sc.next();
        if (!isPlaying && input.length() == 1 && checkUserInput(input) == 1) return 1;
        if (!isPlaying) return 2;
        if (input.length() != BaseballGame.CHECK_NUMBER_SIZE) return BaseballGame.INPUT_ERROR;
        return checkUserInput(input);
    }

    public int checkUserInput(String txt) {
        try {
            return getValidInput(txt);
        } catch (NumberFormatException e) {
            return BaseballGame.INPUT_ERROR;
        }
    }

    public int getValidInput(String text) throws NumberFormatException {
        if ("".equals(text)) throw new NumberFormatException("Invalid Input");
        if (text.contains("0")) throw new NumberFormatException("Invalid Input");
        return Integer.parseInt(text);
    }

    public ArrayList<Integer> convertNumberToList(int number) {
        // 서로 다른 수로 이루어진 3자리 숫자
        ArrayList<Integer> inputNumbers = new ArrayList<>();
        for (int i = 0; i < BaseballGame.CHECK_NUMBER_SIZE; i++) {
            inputNumbers.add(0, number % 10);
            number = number / 10;
        }
        return numberList = inputNumbers;
    }

    public void initBallCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    public ArrayList<Integer> getNumberList() {
        return numberList;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }
}
