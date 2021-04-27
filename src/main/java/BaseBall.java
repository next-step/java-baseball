import java.util.Random;

public class BaseBall {
    private int[] answer;
    private boolean finish;
    private boolean replay;
    private GameInput gameInput;
    private GameOutput gameOutput;
    private final static int GAME_LENGTH = 3;
    private final static int LOWER_BOUND = 1;
    private final static int UPPER_BOUND = 9;

    public void startGame() {
        do {
            init();
            playGame();
        } while (replay);
    }

    private void playGame() {
        while (!finish) {
            gameOutput.writeMessage(Message.PUTIN_NUMBER.getMessage());
            check(gameInput.getGameInput());
        }
        gameOutput.writeMessage(String.valueOf(GAME_LENGTH), Message.ALL_STRIKES.getMessage());
        gameOutput.writeMessage(Message.REPLAY_GUIDE.getMessage());
        replayGame();
    }

    private void replayGame() {
        String input = gameInput.getControlInput();
        replay = Integer.parseInt(input) == 1;
    }

    public void check(String input) {
        Result result = new Result();
        for (int i = 0; i < GAME_LENGTH; i++) {
            judge(input, result, i);
        }
        showHint(result);
        finish = result.getStrikes() == GAME_LENGTH;
    }

    public void showHint(Result result) {
        if (result.getStrikes() != 0) {
            gameOutput.writeMessageInline(String.valueOf(result.getStrikes()), Message.STRIKE.getMessage() );
        }
        if (result.getBalls() != 0) {
            gameOutput.writeMessageInline(String.valueOf(result.getBalls()), Message.BALL.getMessage() );
        }
        if (result.getStrikes() == 0 && result.getBalls() == 0) {
            gameOutput.writeMessageInline(Message.NOTHING.getMessage() );
        }
        gameOutput.writeFlush();
    }

    public void judge(String input, Result result, int i) {
        int value = Integer.parseInt(String.valueOf(input.charAt(i)));
        if (isStrike(i, value)) {
            result.setStrikes(result.getStrikes() + 1);
        }
        if (isBall(i, value)) {
            result.setBalls(result.getBalls() + 1);
        }
    }

    private void init() {
        finish = false;
        answer = new int[GAME_LENGTH];
        genRandomAnswer();
        replay = true;
        gameInput = GameInput.getInstance();
        gameInput.setGameLength(GAME_LENGTH);
        gameInput.setLowerBound(LOWER_BOUND);
        gameInput.setUpperBound(UPPER_BOUND);
        gameOutput = GameOutput.getInstance();
    }

    private void genRandomAnswer() {
        Random random = new Random(System.currentTimeMillis());
        int index = 0;
        while (index < GAME_LENGTH) {
            index = fillNum(random, index);
        }
    }

    private int fillNum(Random random, int index) {
        int value = random.nextInt(UPPER_BOUND-LOWER_BOUND+1) + LOWER_BOUND;
        if (!isContain(value)) {
            answer[index] = value;
            return index + 1;
        }
        return index;
    }

    public boolean isContain(int value) {
        boolean returnVal = false;
        for (int val : answer) {
            returnVal = val==value||returnVal;
        }
        return returnVal;
    }

    public boolean isStrike(int index, int value) {
        return answer[index] == value;
    }

    public boolean isBall(int index, int value) {
        return isContain(value) && !isStrike(index, value);
    }
}
