public class Main {
    public static void main(String[] args) {
        BaseballNumberValidator validator = new BaseballNumberValidator();
        BaseballGame baseballGame = new BaseballGame(validator);

        while(baseballGame.continuing()){
            baseballGame.generateBaseBallNumber();
            baseballGame.putNumbers();



        }
    }
}
