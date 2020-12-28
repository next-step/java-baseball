public class Game {
    private GameDialogue dialogue = new GameDialogue();
    private boolean isEnded = false;
    private final int numLength;

    Game(int numLength){
        this.numLength = numLength;
    }

    // TODO
    private String generateNum(){
        return "123";
    }

    // TODO
    private int countStrikes(String input, String answer){
        return 3;
    }

    // TODO
    private int countBalls(String input, String answer){
        return 3;
    }

    private boolean confirmAnswer(String input, String answer){
        int strikes = countStrikes(input, answer);
        int balls = countBalls(input, answer);

        dialogue.printGuessResult(strikes, balls);
        
        if(strikes == numLength){
            return true;
        }
        return false;
    }

    private void endGame(){
        isEnded = true;
    }

    public boolean isEnded(){
        return isEnded;
    }

    public void startGame(){
        String answer = generateNum();
        String input = null;

        do{
            input = dialogue.requestGuess();
        }while(!confirmAnswer(input, answer));
        dialogue.printEndGame(numLength);

        if(!dialogue.askNewGame()){
            this.endGame();
        }
    }
}
