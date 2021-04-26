package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import java.util.Iterator;
import java.util.LinkedList;

public class BaseBallGame {
    int[] comNum = new int[3];
    int[] userNum = new int[3];

    int strike;	// 스트라이크 개수
	int ball;	// 볼 개수

    Scanner sc = new Scanner(System.in);

    // 컴퓨터의 수를 생성한다.
    public void createComNum(){
        Set<Integer> numSet = new HashSet<Integer>();
		
		// Set을 이용한 3개의 난수 생성
		while(numSet.size()<3){
			numSet.add( (int)(Math.random() * 9 + 1) );
		}
		
		Iterator<Integer> it = numSet.iterator();
		
		int i = 0; 
		while(it.hasNext()){
			comNum[i++] = it.next().intValue();
		}
		
		// 데이터를 섞는다.
		for(int j=1; j<=100; j++){  
			int rnd = (int)(Math.random() * comNum.length);  // 0 ~ 2 사이의 난수
			int temp = comNum[0];
			comNum[0] = comNum[rnd];
			comNum[rnd] = temp;
		}
    }

    public void inputUserNum(){
		int inputUser, cnt = 0;  // 입력한 값을 저장할 변수
		
		do{
			System.out.print("숫자를 입력해주세요 : ");
			inputUser = sc.nextInt();
			
            if (inputUser > 99 && inputUser <= 999){
                LinkedList<Integer> stack = new LinkedList<Integer>();

                while (inputUser > 0){
                    stack.push(inputUser % 10);
                    inputUser = inputUser / 10;
                }

                while ((!stack.isEmpty())){
                    userNum[cnt] = stack.pop();
                    cnt++;
                }
            }
		}while(inputUser != 0);
	}

	// 볼 체크 메서드
	public void checkBallCount(){
		// 초기화
		strike = 0;
		ball = 0;   
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<comNum.length; i++){
			for(int j=0; j<userNum.length; j++){
				if(comNum[i] == userNum[j]){  

					if(i == j){// 값이 같고 첨자가 같으면 스트라이크
						strike++;
						continue;
					}

					if (i != j){ // 값은 같은데 첨자가 다르면 볼
						ball++;
					}
				}
			}
		}

		sb.append(userNum[0]).append(userNum[1]).append(userNum[2]).append(" 을 제시한 경우 : ");
		
		if (strike != 0 && ball == 0){
			sb.append(strike).append("스트라이크");
		}

		if (strike == 0 && ball != 0){
			sb.append(ball).append("볼");
		}

		if (strike != 0 && ball != 0){
			sb.append(strike).append("스트라이크 ").append(ball).append("볼");
		}
		
		System.out.println(sb.toString());
	}

    public void gameStart(){
		
        // 컴퓨터 수 난수 생성
		createComNum();
		
		// 확인용
		System.out.println("난수값 => " + comNum[0] + " " + comNum[1] + " " + comNum[2]);
		
		do{
			inputUserNum(); 	// 사용자 입력 메서드 호출
			checkBallCount();  	// 볼카운트하는 메서드 호출
		}while(strike!=3);  	// 3 스트라이크가 될 때까지 반복
		
		// 다시 시작하시겠습니까?
	}

    public static void main(String[] args) {

        BaseBallGame bbg = new BaseBallGame();
        bbg.gameStart();
    }

    
    
}
