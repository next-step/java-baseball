public class BaseBallGame {
    private static final String REGULAR_EXPRESSION_FORMAT = "[1-9]{%d}";

    private final Player player;
    private final InputHelper inputHelper;
    private final int numberSize;

    public BaseBallGame(Player player, InputHelper inputHelper, int numberSize) {
        this.player = player;
        this.inputHelper = inputHelper;
        this.numberSize = numberSize;
    }

    public void start() {
        Computer computer = createComputer();
        player.play();

        while (player.playing()) {
            inputAnswerAndCompare(computer);
        }

        while (player.notSelected()) {
            selectRestartOrExit();
        }
    }

    private Computer createComputer() {
        RightAnswer answer = createRightAnswer();
        String regularExpression = String.format(REGULAR_EXPRESSION_FORMAT, numberSize);
        return new Computer(answer, regularExpression);
    }

    private RightAnswer createRightAnswer() {
        String randomNumber = RandomNumberGenerator.generate(numberSize);
        return new RightAnswer(randomNumber);
    }

    private void inputAnswerAndCompare(Computer computer) {
        String input = inputAnswer();

        try {
            Result result = computer.compareNumberWith(input);
            processResult(result);
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private String inputAnswer() {
        Log.REQUEST_ANSWER.print();
        return inputHelper.input();
    }

    private void processResult(Result result) {
        player.changeStatusIfSuccess(result);
        Log.printResult(result);
    }

    public void selectRestartOrExit() {
        Log.ASK_RESTART_OR_EXIT.println();
        String choice = inputHelper.input();
        player.restartOrExit(choice);
    }
}
