public class BaseballGame {
    private RandomNumGenerator systemGenerator;
    private UserInputNumGenerator userGenerator;
    private BaseballGameResultCalculator calculator;
    private BaseballGameResultPrinter printer;

    public static final int DEFAULT_LEN = 3;

    private int maxLen;

    public BaseballGame(){
        this(DEFAULT_LEN);
    }

    public BaseballGame(int maxLen){
        this.maxLen = maxLen;
        systemGenerator = new RandomNumGenerator(maxLen);
        userGenerator = new UserInputNumGenerator(maxLen);
        calculator = new BaseballGameResultCalculator(maxLen);
        printer = new BaseballGameResultPrinter();
    }

    public void run(){
        String systemBalls = systemGenerator.generateRandomNum();
        int [] res;

        do {
            String userBalls = userGenerator.generateNum();
            res = calculator.calculateGameResult(systemBalls, userBalls);
            printer.print(res);
        }while(!isGameClear(res));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean isGameClear(int[] result) {
        int strikesCnt = result[0];
        return strikesCnt == 3;
    }

    public static void main(String[] args) {
        BaseballGame basballgame = new BaseballGame(DEFAULT_LEN);
        basballgame.run();
    }
}