

import java.util.Arrays;
import java.util.List;
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
	 * @param inputStr
	 * @return
	 */
	public static void start (String initNum) {
		
		System.out.println("게임을 시작합니다.");
		
		/* 난수 셋팅 */
		setGenerateNum();
		
		/* 숫자를 입력받는다. */
		throwBalls(initNum);
		
	}
	
	
	
	/**
	 * staticReset : 전역변수 초기화
	 */
	private static void staticReset () {
		
		/* 입력수 초기화. */
		initNum = null;
	
		/* 볼카운트 초기화. */
		ballCount = new int[2];
		
		/* 유효성 검증 실패 여부 초기화 */
		isError = false;
		
		/* 유효성 검증 실패메시지 초기화 */
		errMsg = null;
		
	}
	
	
	
	/**
	 * throwBalls : 스캐너로 숫자를 입력받는다.
	 */
	public static void throwBalls (String testNum) {
		
		/* 전역변수 초기화 */
		staticReset();
		
		/* 입력값 호출 */
		initNum = testNum;
		//initNum = requestSc("숫자를 입력해주세요.");
		
		/* 입력값 검증 */
		valid();
		
	}
	
	
	
	/**
	 * valid : 입력값을 유효성 검증한다.
	 * @param initNum
	 */
	private static void valid () {
		
		/* 숫자 검증 */
		integerValid();
		
		/* 길이 검증 */
		lenValid();
		
		/* 중복여부 검증 */
		dupValid();
		
		if (isError) {
			
			/* 에러메시지 출력 및 초기화 */
			System.out.println(errMsg);
			
		}
		
	}
	
	
	
	/**
	 * lenValid : 입력값의 null여부와 길이를 체크한다.
	 */
	private static void lenValid () {
		
		resultValid((initNum == null || initNum.length() != 3), "입력된 값이 없거나, 세자리 수가 아닙니다.");
		
	}
	
	
	
	/**
	 * integerValid : 입력값이 유효한 1부터 9까지의 유효한 숫자형태인지 체크한다.
	 */
	private static void integerValid () {
		
		try {
			
			Integer.parseInt(initNum);
			
		} catch (NumberFormatException e) {
			
			resultValid(true, "입력값이 숫자가 아닙니다.");
			
		}
		
		zeroValid();
		
	}
	
	
	
	/**
	 * zeroValid : 입력값 중 0이 포함되었는지 체크한다.
	 */
	private static void zeroValid () {
		
		resultValid(initNum.contains("0"), "입력값은 0이 포함될 수 없습니다.");
		
	}
	
	
	
	/**
	 * dupValid : 입력값의 중복여부를 체크한다.
	 */
	private static void dupValid () {
		
		List<String> list = Arrays.asList(initNum.split(""));
		
		for (int i = 0; i < list.size(); i++) {
			
			String tmp = list.get(i);
			list.set(i, "");
			
			resultValid(list.contains(tmp), "입력값에 중복이 있습니다.");
			
		}
		
	}
	
	
	
	/**
	 * resultValid : 유효성 검증 결과을 셋팅한다.
	 * @param flag
	 * @param msg
	 * @return
	 */
	private static void resultValid (boolean flag, String msg) {
		
		if (isError) {
			
			return;
			
		}
		
		if (flag) {
			
			/* 에러메시지 셋팅 */
			errMsg = msg;
			
			/* 결과 셋팅 */
			isError = flag;
			
		}
		
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
	
	
	
	/**
	 * requestSc : msg로 print를 하고 스캐너를 호출하여 입력받은 값을 리턴하는 메소드
	 * @param msg
	 * @return
	 */
	private static String requestSc (String msg) {
		
		String result = null;	// 결과 변수
		
		/* 입력받은 메시지로 프린트! */
		System.out.println(msg);
		
		/* 입력값을 결과에 저장 */
		result = sc.next();
		
		return result;
		
	}
	
	
}
