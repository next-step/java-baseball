package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;



public class BaseballTest {
private static Baseball javaBaseball;
	
	@Test
	public void checkValidRandomNumberTest_success() throws Exception {
		// test case => 1,1,3,1,4 => 134

		String result1 = javaBaseball.checkValidRandomNumber("", "1");
		String result2 = javaBaseball.checkValidRandomNumber("1", "1");
		String result3 = javaBaseball.checkValidRandomNumber("1", "3");
		String result4 = javaBaseball.checkValidRandomNumber("13", "1");
		String result5 = javaBaseball.checkValidRandomNumber("13", "4");
		
		assertEquals("1", result1);
		assertEquals("", result2);
		assertEquals("3", result3);
		assertEquals("", result4);
		assertEquals("4", result5);
	}

	
	@Test
	public void checkContainStirngTest_success_1() throws Exception {
		Map<String, String> numberCount = new HashMap<String, String>();
		numberCount.put("1", "EXIST");
		numberCount.put("2", "EXIST");
		numberCount.put("3", "EXIST");
		
		javaBaseball.checkContainStirng(numberCount, "4");
		
	}
	
	@Test
	public void checkContainStirngTest_success_2() throws Exception {
		Map<String, String> numberCount = new HashMap<String, String>();
		numberCount.put("1", "EXIST");
		numberCount.put("2", "EXIST");
		numberCount.put("3", "");
		
		javaBaseball.checkContainStirng(numberCount, "3");
		
	}
	
	@Test
	public void checkContainStirngTest_throw_exception() throws Exception {
		Map<String, String> numberCount = new HashMap<String, String>();
		numberCount.put("1", "EXIST");
		numberCount.put("2", "EXIST");
		numberCount.put("3", "EXIST");
		
		Exception exception = assertThrows(Exception.class, ()-> javaBaseball.checkContainStirng(numberCount, "3"));
	    String message = exception.getMessage();
	    assertEquals("입력한 숫자의 값에 중복된 숫자가 있습니다. 입력된 값 : [3]", message);
		
	}
	
	@Test
	public void checkDuplicationValidTest_success() throws Exception {		
		javaBaseball.checkDuplicationValid(123);
		
	}
	
	@Test
	public void checkDuplicationValidTest_throw_exception() throws Exception {
		Exception exception = assertThrows(Exception.class, ()-> javaBaseball.checkDuplicationValid(133));
	    String message = exception.getMessage();
	    assertEquals("입력한 숫자의 값에 중복된 숫자가 있습니다. 입력된 값 : [3]", message);
		
	}
	
	@Test
	public void checkLengthValidTest_success() throws Exception {		
		javaBaseball.checkLengthValid(123);
	}
	
	@Test
	public void checkLengthValidTest_throw_exception() throws Exception {	
		Exception exception = assertThrows(Exception.class, ()-> javaBaseball.checkLengthValid(1234));
	    String message = exception.getMessage();
	    assertEquals("입력한 숫자의 값이 3자리 수가 아닙니다. 입력된 값 : [1234]", message);
		
	}
	
	@Test
	public void checkStrikeAndBallTest_success() throws Exception {		
		String result1 = javaBaseball.checkStrikeAndBall("234", "2", 0);
		String result2 = javaBaseball.checkStrikeAndBall("234", "2", 1);
		String result3 = javaBaseball.checkStrikeAndBall("234", "2", 2);
		
		assertEquals("STRIKE", result1);
		assertEquals("BALL", result2);
		assertEquals("BALL", result3);
		
		String result4 = javaBaseball.checkStrikeAndBall("234", "5", 0);
		String result5 = javaBaseball.checkStrikeAndBall("234", "5", 0);
		String result6 = javaBaseball.checkStrikeAndBall("234", "5", 0);
		
		assertEquals("NOTHING", result4);
		assertEquals("NOTHING", result5);
		assertEquals("NOTHING", result6);
	}
	
	@Test
	public void countStrikeAndBallTest () throws Exception {
		Map<String, Integer> expected1 = new HashMap<String, Integer>(); 
		Map<String, Integer> result1 = javaBaseball.countStrikeAndBall(234, 678);
		expected1.put("BALL", 0);
		expected1.put("STRIKE", 0);
		expected1.put("NOTHING", 3);
		assertEquals(expected1, result1);
		
		Map<String, Integer> expected2 = new HashMap<String, Integer>(); 
		Map<String, Integer> result2 = javaBaseball.countStrikeAndBall(123, 321);
		expected2.put("BALL", 2);
		expected2.put("STRIKE", 1);
		expected2.put("NOTHING", 0);
		assertEquals(expected2, result2);
		
		Map<String, Integer> expected3 = new HashMap<String, Integer>(); 
		Map<String, Integer> result3 = javaBaseball.countStrikeAndBall(123, 312);
		expected3.put("BALL", 3);
		expected3.put("STRIKE", 0);
		expected3.put("NOTHING", 0);
		assertEquals(expected3, result3);
		
		Map<String, Integer> expected4 = new HashMap<String, Integer>(); 
		Map<String, Integer> result4 = javaBaseball.countStrikeAndBall(123, 123);
		expected4.put("BALL", 0);
		expected4.put("STRIKE", 3);
		expected4.put("NOTHING", 0);
		assertEquals(expected4, result4);
	}
	
	@Test
	public void makeRandomNumberTest () throws Exception {
		Integer result = javaBaseball.makeRandomNumber();
		javaBaseball.checkDuplicationValid(result);
		javaBaseball.checkLengthValid(result);
	} 
	
	@Test
	public void splitInputStringIntoOneDigitTest () {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("1");
		expected.add("2");
		expected.add("3");
		ArrayList<String> result = javaBaseball.splitInputStringIntoOneDigit(123);
		assertEquals(expected, result);
	}
	
	@Test
	public void showMessageTest () throws Exception {
		Map<String, Integer> result1 = new HashMap<String, Integer>();
		result1.put("STRIKE", 1);
		result1.put("BALL", 1);
		result1.put("NOTHING", 1);
		javaBaseball.showMessage(result1);
		
		Map<String, Integer> result2 = new HashMap<String, Integer>();
		result2.put("STRIKE", 0);
		result2.put("BALL", 0);
		result2.put("NOTHING", 3);
		javaBaseball.showMessage(result2);
	} 
/*
    @Test
    public void mainTest () throws Exception {
    	String args[] = {};
    	javaBaseball.main(args);
    }
	*/

}
