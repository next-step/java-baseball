package service.user;

import java.util.Scanner;

import model.entity.Player;

public class PlayerApiLogicService {
	Scanner scan = new Scanner(System.in);
    Player player = new Player();

    public String getInputNumber() {
    	return player.getInputNumber();
    }
    
    public void inputNumber() {
    	System.out.print("3자리 숫자를 중복과 공백없이 입력하세요(범위 : 1~9) : ");
    	player.setInputNumber(scan.nextLine().trim());
    }
    
    public boolean willPlay() {
    	System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
		System.out.print("게임을 새로 시작하려면 1, 종료하려면 2을 입력하세요 : ");
    	String stoppedYn = scan.nextLine().substring(0).trim().toUpperCase();
    	
    	if(stoppedYn.equals("2")) {
    		System.out.println("종료 되었습니다.");
    		return false;
    	}
    	return true;
    }    
}
