package com.nextstep.baseball;

import java.util.HashSet;

public class ValidationCheck {
	
		private static final int LEN = 3;
	
		//숫자 확인 메서드
		public static boolean checkRule(String num) {
			boolean isNumCheck = ValidationCheck.numCheck(num);//숫자 체크 확인 메서드
			boolean isLenthCheck = ValidationCheck.lengthCheck(num, LEN);//자릿수 체크 메서드
			boolean isOverlapCheck = ValidationCheck.overlapCheck(num);//1~9사이의 중복되지 않는 숫자 - 작성해야함 
			
			if(isNumCheck && isLenthCheck && isOverlapCheck){
				return true;
			}
			
			return false;
		}
	
	
		//숫자 확인 메서드
		public static boolean numCheck(String num) {
			boolean isNumCheck =  num.matches("^[1~9]{1}$|[1-9]{1}[1-9]{1}[1-9]{1}$");
			return isNumCheck;
		}
		
		//자릿수 체크 메서드
		public static boolean lengthCheck(String num, int checkLength) {
			if(num.length() == checkLength) {
				return true;
			}
			return false;
		}
		
		//중복 확인 메서드
		public static boolean overlapCheck(String num) {
			String arrBallNum[] = num.split("");

	        HashSet<String> hashSet = new HashSet<>();
	        for(String item : arrBallNum){
	            hashSet.add(item);
	        }
			
			if(hashSet.size() == LEN) {
				return true;
			}
			return false;
		}
		
		//두문자열을 비교하여 같으면 1을 반환하는 함수
		public static int compareString(String num, String num2){
			if(num.equals(num2)){
				return 1;
			}
			return 0;
		}
}
