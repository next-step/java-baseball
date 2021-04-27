package play;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import common.MessagesCommon;
import play.InputNumberProcess;

public class InputValueCheckTest {

	int[] testNumAry = {988, 110, 888};

	@BeforeClass
	public static void beforeClassTest() {
		System.out.println("입력값 프로세스 테스트를 시작합니다.");
	}

	@AfterClass
	public static void afterClassTest() {
		System.out.println("입력값 프로세스 테스트를 종료합니다.");
	}
	
	@Before
	public void beforeTest() {
		System.out.println("");
	}

	@Test
	public void testNumMaxCheck() {
		int testNum = testNumAry[0];

		try {
			assertFalse(MessagesCommon.ERROR_MAX_MSG, InputNumberProcess.numMaxCheck(testNum));
		} catch (AssertionError e) {
			System.out.println(testNum + " : " + e.getMessage());
		}
	}

	@Test
	public void testNumMinCheck(){
		int testNum = testNumAry[1];
		
		try {
			assertFalse(MessagesCommon.ERROR_MIN_MSG, InputNumberProcess.numMinCheck(testNum));
		} catch (AssertionError e) {
			System.out.println(testNum + " : " + e.getMessage());
		}
	}

	@Test
	public void testNumOfDigits() {
		int testNum = testNumAry[2];
		
		Map<Integer, Integer> inNumMap = new HashMap<Integer, Integer>();
		Set<Integer> inNumSet = new HashSet<>();

		InputNumberProcess.numOfDigits(testNum, inNumMap, inNumSet, 4);
		
		try {
			assertFalse(MessagesCommon.ERROR_OVERLAP_MSG, inNumSet.size() != 3);
		} catch (AssertionError e) {
			System.out.println(testNum + " : " + e.getMessage() + "[" + inNumSet.size() + "]");
		}
	}
}
