import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * 프리코스 1주차 숫자야구게임
 * @author 손두한
 */
public class BaseBall {
	
	
	/* 입력수 */
	private static String initNum;
	
	/* 컴퓨터 측 난수 */
	private static String cpuNum;
	
	/* 볼카운트 변수 (첫번째 방이 스트라이크, 두번째 방이 볼) */
	private static int[] ballCount = new int[2];
	
	/* 스캐너 변수 */
	private static Scanner sc = new Scanner(System.in);
	
	/* 유효성 검증 실패 여부 */
	private static boolean isError = false;
	
	/* 유효성 검증 실패메시지 */
	private static String errMsg;
	
	
	
	/**
	 * start : 게임 시작
	 * @param inputStr
	 * @return
	 */
	public static void start () {
		
		System.out.println("게임을 시작합니다.");
		
		/* 난수 셋팅 */
		setGenerateNum();
		
		/* 숫자를 입력받는다. */
		throwBalls();
		
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
	private static void throwBalls () {
		
		/* 전역변수 초기화 */
		staticReset();
		
		/* 입력값 호출 */
		initNum = requestSc("숫자를 입력해주세요.");
		
		/* 입력값 검증 */
		valid();
		
		/* 게임 결과를 체크한다. */
		referee();
		
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
			
			/* 재귀 호출 */
			throwBalls();
			
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
	 * referee : 인입된 문자열을 토대로 볼카운트를 호출하는 심판역활 메소드
	 */
	private static void referee () {
		
		/* 입력된 넘버로 볼카운팅 한다. */
		for (int i = 0; i < initNum.length(); i++) {
			
			count(cpuNum.indexOf(initNum.substring(i, (i+1))), i);
			
		}
		
		/* 볼카운트가 3스트라이크일 경우 경기 종료 선언 */
		if (ballCount[0] == 3) {
			
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			
			/* 재시작 여부 확인 */
			reGame();
			
		}
		
		/* 볼카운트 결과 선언 */
		declare();
	
	}
	
	
	
	/**
	 * count : 볼카운트를 하는 메소드
	 * @param idxOf
	 * @param digit
	 */
	private static void count (int idxOf, int digit) {
		
		/* 숫자가 아얘 미포함된 경우 */
		if (idxOf == -1) {
			
			return;
		}
		
		/* 숫자가 포함되었고 위치가 정확한 경우 스트라이크 칸에 카운트 */
		if (idxOf == digit) {
			
			ballCount[0] += 1;
			return;
			
		}
		
		/* 숫자가 포함되었고 위치가 정확한 경우 볼 칸에 카운트 */
		ballCount[1] += 1;
		
	}
	
	
	
	/**
	 * declare : 볼카운트를 선언하는 메소드
	 */
	private static void declare () {
		
		String prnt = ballCount[0] + "스트라이크 " + ballCount[1] + "볼";
		
		/* 아무 번호도 매칭이 안 되었을때 */
		if (ballCount[0] + ballCount[1] == 0) {
			
			prnt = "낫싱";
			
		}
		
		System.out.println(prnt);
		
		/* 숫자를 재입력받는다. */
		throwBalls();
		
	}
	
	
	
	/**
	 * reGame : 변수를 클리어하고 새 게임을 결정하는 메소드
	 */
	private static void reGame () {
		
		String initNum = requestSc("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		
		if ("1".equals(initNum)) {
			
			/* 게임 재시작! */
			start();
			
		}
		
		if ("2".equals(initNum)) {
			
			/* 게임 종료! */
			exit();
			
		}
		
		/* 그외 값 입력 시 재귀호출! */
		reGame();
		
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
	
	
	
	/**
	 * exit : 종료함수
	 * @return
	 */
	private static void exit () {
		
		System.out.println("굿바이.");
		
		/* 스캐너 크로징 */
		sc.close();
		
		/* 시스템 종료 */
		System.exit(0);
		
	}
	
	
	
}
