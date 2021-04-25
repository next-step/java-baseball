import util.Calculator;
import util.Computer;

import java.util.Scanner;

class Game {
    Computer computer;
    Calculator calculator;
    static String endGameString = "3개의 숫자를 모두 맞히셨습니다 ! 게임 종료";

    Game(){
        computer = new Computer();
        calculator = new Calculator();
    }

    public int startGame(){
        computer.initComputerValue();
        Scanner scanner = new Scanner(System.in);
        String playerVariable = "";
        String endMessage = "";
        while(!endGameString.equals(endMessage)){
           System.out.print("숫자를 입력해주세요 : ");
           try { playerVariable = scanner.nextLine();
           }catch (NumberFormatException e) { System.out.print("이상한 값이 입력되었습니다."); e.printStackTrace();
           } endMessage = calculatorGaming(playerVariable);
        } return 1;
    }

    public String calculatorGaming(String playerVariable){


    }

}
