public class BaseballController {

    private final BaseballModel baseballModel = new BaseballModel();
    private final BaseballView baseballView = new BaseballView();

    public void run() {
        boolean continued = true;
        while(continued){
            continued = playRound();
        }
    }

    public boolean playRound() {
        baseballModel.initializeBallNumber();

        boolean isCorrectBall = false;
        while(!isCorrectBall){
            isCorrectBall = throwBall();
        }

        String restartInput = getRestartInput();
        return restartInput.equals("1");
    }

    public String getRestartInput(){
        String restartInput = "";
        while(isValidRestartInput(restartInput)){
            restartInput = baseballView.viewCorrectResult(BaseballModel.getLengthOfBallNumber());
        }
        return restartInput;
    }

    boolean isValidRestartInput(String restartInput){
        return !restartInput.equals("1") && !restartInput.equals("2");
    }

    public boolean throwBall(){
        String ballInput = baseballView.viewInput();
        while(!isValidBallInput(ballInput)){
            ballInput = baseballView.viewInput();
        }

        int strikeCount = getStrikeCount(ballInput, baseballModel.getBallNumber());
        int ballCount = getBallCount(ballInput, baseballModel.getBallNumber());

        baseballView.viewStrikeBallCount(strikeCount, ballCount);

        return strikeCount == BaseballModel.getLengthOfBallNumber();
    }

    public boolean isValidBallInput(String ballInput){
        return ballInput.matches(String.format("[0-9]{%d}", BaseballModel.getLengthOfBallNumber()));
    }

    public int isStrikeAtIndex(String input, String answer, int index){
        if(input.charAt(index) == answer.charAt(index)){
            return 1;
        }
        return 0;
    }

    public int getStrikeCount(String input, String answer){
        int strikeCount = 0;
        for(int index = 0 ; index < input.length() ; ++index){
            strikeCount += isStrikeAtIndex(input, answer, index);
        }
        return strikeCount;
    }

    public int isBallAtIndex(String input, String answer, int index){
        if(isStrikeAtIndex(input, answer, index) == 1){
            return 0;
        }
        if(answer.indexOf(input.charAt(index)) == -1){
            return 0;
        }
        return 1;
    }

    public int getBallCount(String input, String answer){
        int ballCount = 0;
        for(int index = 0 ; index < input.length() ; ++index){
            ballCount += isBallAtIndex(input, answer, index);
        }
        return ballCount;
    }
}
