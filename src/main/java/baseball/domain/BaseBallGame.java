package baseball.domain;

public class BaseBallGame {
    private String computerBaseNum = "";

    BaseBallComputer baseBallComputer = new BaseBallComputer();

    public void init(){
        baseBallComputer.computerCreateNum();
        computerBaseNum = baseBallComputer.getComputerCreateNum();
    }
}
