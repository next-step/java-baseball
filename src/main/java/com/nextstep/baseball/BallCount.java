package com.nextstep.baseball;

public class BallCount {
	//스트라이크 확인 함수
	public static int strikeCheck(String[] arrNum, String[] arrNum2){
		int sCnt = 0;
		
		for(int i = 0; i < arrNum.length; i++){
			sCnt += ValidationCheck.compareString(arrNum[i], arrNum2[i]);
		}
		
		return sCnt;
	}
	
	//볼 확인 함수
	public static int ballCheck(String[] arrNum, String[] arrNum2){
		int bCnt = 0;
		
		for(int i = 0; i < arrNum.length; i++){
			int divNum = ValidationCheck.compareString(arrNum[i], arrNum2[i]);
			bCnt += ballCheck2(arrNum[i], divNum, arrNum2);
		}
		
		return bCnt;
	}
	
	//볼 확인 함수2
	public static int ballCheck2(String arrNum, int cnt, String[] arrNum2) {
		int bCnt = 0;
		
		if(cnt == 1) {
			return 0;
		}
		
		for(int j = 0; j < arrNum2.length; j++){
			bCnt += ValidationCheck.compareString(arrNum, arrNum2[j]);
		}
		
		return bCnt;
	}
}
