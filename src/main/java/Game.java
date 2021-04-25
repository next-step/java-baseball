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

}
