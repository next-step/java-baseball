package service.user;

import java.util.Scanner;

import model.entity.Player;

/**
 * 게임 참가자
 */
public class PlayerApiLogicService {
	Scanner scan = new Scanner(System.in);
    Player player = new Player();

    public void inputNumber() {
    	System.out.print("3자리 숫자를 중복과 공백없이 입력하세요 : ");
    	player.setInputNumber(scan.nextLine().trim());
    }
    
    public void willPlay(String inputStopped) {
    	inputStopped = inputStopped.substring(0).toUpperCase();
    	
    	System.out.print("게임을 시작하려면 Y, 종료하려면 N을 입력하세요 : ");
    	if(inputStopped.equals("N")) {
    		System.out.println("종료 되었습니다.");
    	}
    }
}
