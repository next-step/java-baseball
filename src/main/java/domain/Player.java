package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int NUMBER_COUNT = 3;
    private static final int TEN = 10;
    private List<Number> scoreBoard;
    public Player(int number) {
        this(toNumber(number));
    }

    public Player(List<Number> board) {
        this.scoreBoard = board;
    }

    public Player() {
        this(Number.randomList());
    }

    public static List<Number> toNumber(int inputNumber) {
        List<Number> board = new ArrayList<>();
        List<Number> list = toNumberList(inputNumber);
        for (Number number : list) {
            if (!board.contains(number)) {
                board.add(number);
            }
        }

        if (board.size() !=NUMBER_COUNT) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
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

    public int indexOf(Number number){
        return this.scoreBoard.indexOf(number);
    }

    public void match(Player user, Result result){
        for(int i =0; i<scoreBoard.size(); i++){
            State state = check(user.indexOf(scoreBoard.get(i)) , i);
            result.stateCountPlus(state);
        }
    }

    private State check(int computerIndex , int userIndex){
        if(computerIndex < 0){
            return State.NOTHING;
        }
        if(computerIndex == userIndex){
            return State.STRIKE;
        }
        return State.BOLL;
    }

    @Override
    public String toString() {
        return this.scoreBoard.toString();
    }

    public void reset(boolean isContinue) {
        if(isContinue){
            this.scoreBoard = Number.randomList();
        }
    }
}
