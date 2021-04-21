import java.util.Scanner;

public class baseball {
    public static void main(String[] args) {
        baseballFunction bbf = new baseballFunction();
        boolean isAllStrike = false;
        
        	while(bbf.runGame()) {
        		String randomNumber = bbf.createNumber();
        		String userNumber = bbf.insertNumber();
        		
        		isAllStrike = bbf.isAllStrike(randomNumber, userNumber);
            	
            	while(!isAllStrike) {
            		userNumber = bbf.insertNumber();
            		isAllStrike = bbf.isAllStrike(randomNumber, userNumber);
            	}
            	System.out.println("3개의 숫자를 모드 맞히셨습니다! 게임 종료");
        	}
        }
        
}


class baseballFunction{
	// 게임 시작 및 종료 메서드
    public boolean runGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String msg = sc.next();
        if(msg.equals("1")) {
        	System.out.println("게임시작");
        	return true;
        }else if(msg.equals("2")){
        	System.out.println("게임종료");
        }else {
        	System.out.println("입력값이 올바르지 않습니다.");
        }
        return false;
    }
    
 // 난수 발생 메서드
    public String createNumber(){
        String randomNumber = "";
        for(int i = 0; i < 3; i++){
            String number = Integer.toString((int) (Math.random() * 10));
            if(!number.equals("0") && !randomNumber.contains(number)){
                randomNumber += number;
            } else{
                i -= 1;
            }
        }
        return randomNumber;
    }
    
 // 사용자 입력값 받는 메서드
    public String insertNumber() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("숫자를 입력해 주세요 :");
    	String userNumber = sc.next();
    	
		return userNumber;
    }
    
 // 볼, 스트라이크 판별 메서드
    public boolean isAllStrike(String randomNumber, String userNumber) {
    	boolean isAllStrike = false;
    	int strike = 0;
    	int ball = 0;
    	
    	String randomArr[] = randomNumber.split("");
    	String userArr[] = userNumber.split("");
    	
    	for(int i = 0; i < randomArr.length; i++) {
    		for(int j = 0; j < userArr.length; j++) {
    			if(randomArr[i].equals(userArr[j]) && i == j) {
    				strike++;
    			}else if(randomArr[i].equals(userArr[j]) && i != j) {
    				ball++;
    			}
    		}
    	}
    	
    	if(strike == 3) {
    		System.out.println("3스트라이크");
    		isAllStrike = true;
    	}else if(ball == 0 && strike == 0) {
    		System.out.println("포볼");
    	}else if(ball == 0) {
    		System.out.println(strike + "스트라이크");
    	}else if(strike == 0) {
    		System.out.println(ball + "볼");
    	}else if(ball != 0 && strike != 0) {
    		System.out.println(ball + "볼 " + strike + "스트라이크");
    	}
    	
    	return isAllStrike;
    }
    
    
}
