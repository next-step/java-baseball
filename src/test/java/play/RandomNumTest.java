package play;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import play.RandomNumProcess;

public class RandomNumTest {

	Map<Integer, Integer> ranNumMap;

	@BeforeClass
	public static void beforeClassTest() {
		System.out.println("난수 발생 프로세스 테스트를 시작합니다.");
	}

	@AfterClass
	public static void afterClassTest() {
		System.out.println("난수 발생 프로세스 테스트를 종료합니다.");
	}

	@Before
	public void beforeTest() {
		ranNumMap = new HashMap<Integer, Integer>();
	}

	@Test
	public void testSetRandomNum() {

		RandomNumProcess.setRandomNum(ranNumMap);

		try {
			assertTrue("3자리 난수 발생 실패", ranNumMap.size() == 3);
		} catch (AssertionError e) {
			System.out.println(ranNumMap + " : " + e.getMessage());
		}
	}

	@Test
	public void testRandomNumOccur() {

		Set<Integer> ranNumSet = RandomNumProcess.randomNumOccur();

		try {
			assertTrue("3자리 난수 발생 실패", ranNumSet.size() == 3);
		} catch (AssertionError e) {
			System.out.println(ranNumSet + " : " + e.getMessage());
		}
	}
}
