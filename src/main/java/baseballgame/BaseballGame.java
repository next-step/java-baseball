package baseballgame;

import baseballgame.computer.Computer;
import baseballgame.player.Player;
import baseballgame.player.PlayerRequest;
import baseballgame.referee.Referee;

import java.io.BufferedReader;
import java.io.IOException;

public class BaseballGame {
    private BufferedReader bufferedReader;

    public BaseballGame(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public Player playerInput() throws IOException {
        while (true){
            String input = bufferedReader.readLine();
            try {
                return PlayerRequest.requestCreatePlayer(input);
            } catch (IllegalArgumentException e) {
                System.out.println("규칙에 맞게 다시 입력하세요");
            }
        }
    }

    public void game() throws IOException {
        System.out.println("새로운 게임이 시작됩니다.");
        boolean isRoundFinish = false;
        Computer computer = Computer.createComputer();
        Referee referee = new Referee();
        while (!isRoundFinish) {
            Player player = playerInput();
            isRoundFinish = referee.judgementGame(player.getBalls(), computer.getBalls());
        }
        System.out.println("정답입니다! 이번 게임이 종료되었습니다. 그만 하시려면 0을 입력해주세요.");
    }

    public boolean isFinishGame() throws IOException {
        if (bufferedReader.readLine().equals("0")) {
            return true;
        }
        return false;
    }
}
