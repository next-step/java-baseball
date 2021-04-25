package domain;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private static final int NUMBER_COUNT = 3;
    private static final int TEN = 10;
    private static List<Number> scoreBoard;

    public ScoreBoard(int number) {
        this(toNumber(number));
    }

    public ScoreBoard(List<Number> board) {
        this.scoreBoard = board;
    }

    public ScoreBoard() {
        this.scoreBoard = new ArrayList<>();
    }

    public static List<Number> toNumber(int inputNumber) {
        List<Number> board = new ArrayList<>();
        List<Number> list = toNumberList(inputNumber);
        for (Number number : list) {
            if (!board.contains(number)) {
                board.add(number);
            }
        }

        if (board.size() < 3) {
            throw new IllegalArgumentException("중복된 값이 존재합니다.");
        }

        return board;
    }


    private static List<Number> toNumberList(int number) {
        List<Number> list = new ArrayList<>();
        for (int i = NUMBER_COUNT; i > 0; i--) {
            int index = (int) Math.pow(TEN, i - 1);
            int num = number / index;
            list.add(Number.of(num));
            number -= num * index;
        }
        return list;
    }


    public int boardSize() {
        return scoreBoard.size();
    }
}
