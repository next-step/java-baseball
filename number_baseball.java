import java.util.Random;
import java.util.Scanner;

public class Ex {
	public static void main(String[] args) {
		
		int com[] = new int[3]; // 컴퓨터 숫자 
		int user[] = new int[3]; // 사용자 숫자
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
        // 랜덤 숫자 생성
		while(com[0]==0) {
			com[0] = r.nextInt(10);
 		}
		while(com[0]==com[1] || com[1]==0) {
			com[1] = r.nextInt(10);
		}
		while(com[1]==com[2] || com[2]==0) {
			com[2] = r.nextInt(10);
		}
		
		while(true) {
	
			int strike = 0;
			int ball = 0;
			for(int i=0; i<user.length; i++) {
				System.out.print((i+1)+"번째 수: ");
				user[i] = sc.nextInt();
			}
			for(int i=0; i<com.length; i++) {
				for(int j=0; j<user.length; j++) {
					if(com[i] == user[j] && i==j) { // 숫자와 위치가 일치
						strike++;
					} else if(com[i] ==user[j] && i!=j) { // 위치는 다르나 숫자는 일치
						ball++;
					}
				}
			}
			if (strike > 0 || ball >0){
                System.out.println(strike+" 스트라이크 "+ball+" 볼 ");
            }
            if (strike == 0 & ball ==0) {
                System.out.println("낫싱");
            }


			if(strike == 3) {
				System.out.println("3개의 숫자를 모두 맞히셧습니다! 게임종료\n게임을 새로 시작하려면 1,종료하려면 2를 입력하세요");
                if (sc.nextInt() == 2) {
                     break;
            
                }
			}
		}
	}
}

