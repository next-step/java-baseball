public class Game {
    private static String computerNum;
    private static String inputNum;

    public static void setComputerNum() {
        ComputerNum computer = new ComputerNum();
        computerNum = computer.getComputerNum();
    }
    public String getComputerNum(){
        setComputerNum();
        return computerNum;
    }

    public static void setInputNum() {
        InputNum input = new InputNum();
        inputNum = input.getInputNum();
    }
    public String getInputNum(){
        setInputNum();
        return inputNum;
    }

    public Integer strike(String computerNum, String inputNum) {
        int strikeResult = 0;

        for(int i = 0; i < inputNum.length(); i++){
            strikeResult += Util.checkEqualChar(inputNum.charAt(i), computerNum.charAt(i));
        }
        return strikeResult;
    }

    public Integer ball(String computerNum, String inputNum) {
        int ballResult = 0;

        String[] inputNumArr = inputNum.split("");

        for(String inputNumStr:inputNumArr ){
            ballResult += Util.checkContains(computerNum, inputNumStr);
        }
        return ballResult;
    }

    public Boolean checkNothing(int strikeCount, int ballCount) {
        if (strikeCount + ballCount == 0) {
            return true;
        }
        return false;
    }

    public Boolean checkStrike(int strikeCount){
        if(strikeCount > 0){
            return true;
        }
        return false;
    }

    public Boolean checkBall(int ballCount){
        if(ballCount > 0){
            return true;
        }
        return false;
    }

}
