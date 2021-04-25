package baseball.domain;

import java.util.Scanner;

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
        gameRestart();
    }

    private boolean gameRestart(){
        boolean check = true;
        while(check){
            Scanner sc = new Scanner(System.in);
            System.out.println("게임을 새로 시작하려면 1, 종료 하려면 2를 입력하세요.");
            String number = sc.nextLine();
            check = gameRestartCheck(number);
        }
        return check;
    }

    private boolean gameRestartCheck(String num){
        if("2".equals(num)){
            return false;
        }else if("1".equals(num)){
            init();
            gameStart();
        }else if(!num.matches("^[1-2]+$")){
            System.out.println("1~2까지의 수를 입력해주시기 바랍니다.");
            return true;
        }
        return false;
    }
}
