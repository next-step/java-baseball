package play;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GamePlayTest {
	
	Map<Integer, Integer> ranNumMap;

	@BeforeClass
	public static void beforeClassTest() {
		System.out.println("게임 프로세스 테스트를 시작합니다.");
	}

	@AfterClass
	public static void afterClassTest() {
		System.out.println("게임 프로세스 테스트를 종료합니다.");
	}
	
	@Before
	public void beforeTest() {
		ranNumMap = new HashMap<Integer, Integer>();
		
		RandomNumProcess.setRandomNum(ranNumMap);
		
		StringBuilder sb = new StringBuilder();
		sb.append("상대방 값 : ").append(ranNumMap.get(1)).append(ranNumMap.get(2)).append(ranNumMap.get(3));
		System.out.println(sb.toString());
	}
	
	@Test
	public void test() {
		
		boolean whileYn = false;
		
		Map<Integer, Integer> inNumMap = new HashMap<Integer, Integer>();
		
		repeatProcess(ranNumMap, inNumMap, whileYn);
	}
	
	public static void repeatProcess(Map<Integer, Integer> ranNumMap, Map<Integer, Integer> inNumMap, boolean whileYn) {

		if (whileYn) {
			return;
		}

		RandomNumProcess.setRandomNum(inNumMap);
		
		StringBuilder sb = new StringBuilder();
		sb.append("플레이어 값 : ").append(inNumMap.get(1)).append(inNumMap.get(2)).append(inNumMap.get(3)).append(" - 결과 : ");
		System.out.print(sb.toString());
		
		whileYn = CompareProcess.gameProcess(ranNumMap, inNumMap);

		repeatProcess(ranNumMap, inNumMap, whileYn);
	}

}
