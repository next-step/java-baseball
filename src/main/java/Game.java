
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

}
