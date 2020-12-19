public class BaseballController {

    public boolean isValidInput(String input){
        return input.matches("[0-9]{3}");
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
