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
        Integer strikeResult = 0;

        for(int i = 0; i < inputNum.length(); i++){
            strikeResult += Util.checkEqualChar(inputNum.charAt(i), computerNum.charAt(i));
        }
        return strikeResult;
    }

}
