import java.util.*;

public class Game {
    private GameDialogue dialogue = new GameDialogue();
    private boolean isEnded = false;
    private final int numLength;

    Game(int numLength){
        this.numLength = numLength;
    }

    public String generateAnswer(){
        Random rand = new Random();
        int generated = 0;
        ArrayList<Integer> nums = 
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        for (int i = 0; i < numLength; ++i){
            int selected = rand.nextInt(nums.size());
            generated = generated * 10 + nums.get(selected);
            nums.remove(selected);
        }

        return String.valueOf(generated);
    }

    // TODO
    public int countStrikes(String input, String answer){
        return 3;
    }

    // TODO
    public int countBalls(String input, String answer){
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
        String answer = generateAnswer();
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
