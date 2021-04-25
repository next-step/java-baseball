package baseball.domain;

public class BaseBallGame {
    private String computerBaseNum = "";
    private String userBaseNum = "";

    BaseBallComputer baseBallComputer = new BaseBallComputer();
    BaseBallUser baseBallUser = new BaseBallUser();

    public void init(){
        baseBallComputer.computerCreateNum();
        computerBaseNum = baseBallComputer.getComputerCreateNum();
    }

    public void gameStart(){
        boolean check = true;
        while(check){
            baseBallUser.userSelectNum();
            userBaseNum = baseBallUser.getUserCreateNum();
            check = baseBallComputer.game(computerBaseNum, userBaseNum);
        }
    }
}
