import java.util.Scanner;

public class BaseballGame {
    public static final int DEFAULT_LEN = 3;

    private int maxLen;

    public UserBallInput userBallInput;
    public RandomGenerator randomGenerator;
    public GameCalculator gameCalculator;
    public BaseballGameResultPrinter baseballGameResultPrinter;

    private void init() {
        userBallInput = new UserBallInput(DEFAULT_LEN);
        randomGenerator = new RandomGenerator(DEFAULT_LEN);
        gameCalculator = new GameCalculator(DEFAULT_LEN);
        baseballGameResultPrinter = new BaseballGameResultPrinter(DEFAULT_LEN);
    }

    public BaseballGame() {
        this(DEFAULT_LEN);
        init();
    }

    public BaseballGame(int maxLen) {
        this.maxLen = maxLen;
        init();
    }

    private void gameStage(String randomGenerated) {
        boolean isWin = false;
        while(!isWin) {
            String userInput = this.userBallInput.userBallInputRead();
            int[] calRes = this.gameCalculator.calculateResult(randomGenerated, userInput);
            System.out.println(this.baseballGameResultPrinter.baseballGameResultPrint(calRes));
            isWin = isWin || (calRes[0] == 3);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private int endInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = sc.nextInt();
        return input;
    }

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(DEFAULT_LEN);
        int isEnd = 1;
        while(isEnd == 1) {
            String randomGenerated = baseballGame.randomGenerator.generateBalls();
            baseballGame.gameStage(randomGenerated);
            isEnd = baseballGame.endInput();
        }

    }
}
