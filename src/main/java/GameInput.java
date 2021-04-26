import java.util.Scanner;

public class GameInput {
    private final Scanner s;
    private int gameLength;
    private int lowerBound;
    private int upperBound;
    private static final GameInput instance= new GameInput();
    private final GameOutput gameOutput = GameOutput.getInstance();

    private GameInput() {
        this.s = new Scanner(System.in);
    }

    public static GameInput getInstance(){
        return instance;
    }

    public void setGameLength(int gameLength) {
        this.gameLength = gameLength;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }


    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public String getGameInput(){
        boolean isGameInputValid;
        String input;
        do {
            input = s.nextLine();
            isGameInputValid=isGameInputValid(input);
        }while(!isGameInputValid);
        return input;
    }

    public String getControlInput(){
        boolean isControlInputValid;
        String input;
        do {
            input = s.nextLine();
            isControlInputValid=isControlInputValid(input);
        }while(!isControlInputValid);
        return input;
    }

    public boolean isControlInputValid(String input) {
        boolean returnVal = isControlInputLengthValid(input) && isControlInputCharValid(input);
        if(!returnVal){
            gameOutput.writeMessage(Message.INVALID_INPUT.getMessage());
        }
        return returnVal;
    }

    private boolean isControlInputCharValid(String input) {
        return input.charAt(0)=='1'||input.charAt(0)=='2';
    }

    private boolean isControlInputLengthValid(String input) {
        return input.length()==1;
    }

    public boolean isGameInputValid(String input) {
        boolean returnVal;
        returnVal = isGameInputLengthValid(input);
        for (int i = 0; i < input.length(); i++) {
            returnVal=isGameInputCharValid(input.charAt(i))&&returnVal;
        }
        if(!returnVal){
            gameOutput.writeMessage(Message.INVALID_INPUT.getMessage());
        }
        return returnVal;
    }

    private boolean isGameInputLengthValid(String input){
        return input.length()==gameLength;
    }

    private boolean isGameInputCharValid(char value){
        return value-'0'<=upperBound && value-'0'>=lowerBound;
    }
}
