import util.Calculator;

import java.util.Scanner;

class GameStartMachine {

    Game game;
    Calculator calculator;

    void startGame(){
        game = new Game();
        calculator = new Calculator();
        while(true) {
            inputStartGame();
        }
    }

    void inputStartGame(){
        int startVariable = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("게임을 시작하시려면 1, 종료하실려면 2를 입력하세요 : ");
            startVariable = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.print("이상한 값이 입력되었습니다."); e.printStackTrace();
        }if(startVariable == 2) System.exit(0);
        inGameStart();
    }

    void inGameStart(){
        int endGames = 0;
        while(!(endGames == 1)) {
            endGames = game.startGame();
        }
    }

}
