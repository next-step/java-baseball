public class Main {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();

        while(baseballGame.continuing()){
            baseballGame.generateBaseBallNumber();
            baseballGame.putNumbers();



        }
    }
}
