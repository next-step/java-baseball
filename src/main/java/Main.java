public class Main {
    public static void main(String[] args) {
        BaseballNumberValidator validator = new BaseballNumberValidator();
        BaseballNumberGenerator generator = new BaseballNumberGenerator();
        BaseballNumberEvaluator evaluator = new BaseballNumberEvaluator();
        BaseballGame baseballGame = new BaseballGame(generator, validator, evaluator);

        while(baseballGame.continuing()){
            baseballGame.generateBaseBallNumber();
            baseballGame.putNumbers();
            baseballGame.evaluate();
            baseballGame.printResult();
            baseballGame.validateSuccess();
        }
    }
}
