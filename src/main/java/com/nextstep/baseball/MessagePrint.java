package com.nextstep.baseball;

public class MessagePrint {
	
	public static void printMessage(int strikeCnt, int ballCnt) {
		printStrike(strikeCnt, ballCnt);
		printBall(strikeCnt, ballCnt);
		printStrikeBall(strikeCnt, ballCnt);
		printNothing(strikeCnt, ballCnt);
	}
	
	public static void printStrike(int strikeCnt, int ballCnt){
		if(strikeCnt != 0 && ballCnt == 0){
			System.out.println(strikeCnt+" 스트라이크");
		}
	}
	
	public static void printBall(int strikeCnt, int ballCnt){
		if(strikeCnt == 0 && ballCnt != 0){
			System.out.println(ballCnt+" 볼");
		}
	}
	
	public static void printStrikeBall(int strikeCnt, int ballCnt){
		if(strikeCnt != 0 && ballCnt != 0){
			System.out.println(strikeCnt+" 스트라이크 "+ballCnt+" 볼");
		}
	}
	
	public static void printNothing(int strikeCnt, int ballCnt){
		if(strikeCnt == 0 && ballCnt == 0){
			System.out.println("낫싱");
		}
	}
}
