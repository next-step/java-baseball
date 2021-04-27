public class Game {
    private String computerNum;
    private String inputNum;

    public void setComputerNum() {
        ComputerNum computer = new ComputerNum();
        computerNum = computer.getComputerNum();
    }
    public String getComputerNum(){
        setComputerNum();
        return computerNum;
    }

    public void setInputNum() {
        InputNum input = new InputNum();
        inputNum = input.getInputNum();
    }
    public String getInputNum(){
        setInputNum();
        return inputNum;
    }

    public void play(boolean isNew) {
        if(isNew){ computerNum = getComputerNum(); }
        inputNum = getInputNum();
        Integer strikeCount = strike(computerNum, inputNum);
        Integer ballCount = Math.max((ball(computerNum, inputNum) - strikeCount),0);

        System.out.println(setResultMsg(strikeCount, ballCount));

        if (strikeCount != computerNum.length()){ play(false); }
        if (strikeCount == computerNum.length()){ return; }
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

    public String setResultMsg(Integer strikeCount, Integer ballCount) {
        StringBuilder resultMsg = new StringBuilder();

        if(checkNothing(strikeCount, ballCount)){
            resultMsg.append("낫싱");
        }
        if (checkStrike(strikeCount)) {
            resultMsg.append(strikeCount+" 스트라이크");
        }
        if (checkBall(ballCount)) {
            resultMsg = Util.setEmptyMsg(resultMsg).append(ballCount+" 볼");
        }
        return resultMsg.toString();
    }

}
