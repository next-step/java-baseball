package baseball;


public class Program {
    public static void main(String[] args) {
        //TODO 생성 주입 관리하기
        //AppConfig appconfig = new AppConfig();

        RandomNumGenerator randomNumGenerator = new RandomNumGenerator();

        Calculator calculator = new Calculator();
        NumValidChecker numValidChecker = new NumValidChecker();
        PrintGenerator printGenerator = new PrintGenerator(numValidChecker,calculator);

        BaseBallNumGame baseBallNumGame = new BaseBallNumGame(randomNumGenerator,printGenerator);

        baseBallNumGame.play();

    }
}
