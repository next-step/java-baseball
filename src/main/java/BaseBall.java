

import java.util.Scanner;


/**
 * 프리코스 1주차 숫자야구게임
 * @author 손두한
 */
public class BaseBall {
	
	
	/* 입력수 */
	public static String initNum;
	
	/* 컴퓨터 측 난수 */
	public static String cpuNum;
	
	/* 볼카운트 변수 (첫번째 방이 스트라이크, 두번째 방이 볼) */
	public static int[] ballCount = new int[2];
	
	/* 스캐너 변수 */
	public static Scanner sc = new Scanner(System.in);
	
	/* 유효성 검증 실패 여부 */
	public static boolean isError = false;
	
	/* 유효성 검증 실패메시지 */
	public static String errMsg;
	
	
	
	/**
	 * start : 게임 시작
	 * @return
	 */
	public static void start () {
		
		System.out.println("게임을 시작합니다.");
		
		/* 난수 셋팅 */
		setGenerateNum();
		
	}
	
	
	
	/**
	 * setGenerateNum : 1부터 9까지 서로 다른수로 이루어진 3자리 수를 생성 후 전역변수에 담는다.
	 */
	private static void setGenerateNum () {
		
		String result = "";
		String ran = "";
		
		while (result.length() < 3) {
			
			ran = String.valueOf((int) ((Math.random() * (9 - 1)) + 1));
			result = result.replace(ran, "");
			result = ran + result;
			
		}
		
		cpuNum = result;
		
	}
	
	
}
