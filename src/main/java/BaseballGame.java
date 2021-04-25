public class BaseballGame {
    private static RandomNumGenerator systemGenerator;
    private static UserInputNumGenerator userGenerator;
    private static BaseballGameResultCalculator calculator;
    private static BaseballGameResultPrinter printer;

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

    public static void run(){
        String systemBalls = systemGenerator.generateRandomNum();
        int [] res;

        do {
            String userBalls = userGenerator.generateNum();
            res = calculator.calculateGameResult(systemBalls, userBalls);
            printer.print(res);
        }while(!isGameClear(res));

        System.out.println("3개의 숫자를 모두 맞히셨습니다");
    }

    private static boolean isGameClear(int[] result) {
        int strikesCnt = result[0];
        return strikesCnt == 3;
    }

    public static void main(String[] args) {
        BaseballGame basballgame = new BaseballGame(DEFAULT_LEN);
        do {
            basballgame.run();
        }while(UserInputNumGenerator.playAgain());

        System.out.println("게임 종료");
    }
}