
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class InputNumTest {
	private String inputStr;
	private Set<Integer> testNumSet;
	
	@BeforeEach
	void setUp() {
		testNumSet = new LinkedHashSet<Integer>();
		testNumSet.add(1);
		testNumSet.add(2);
		testNumSet.add(3);
		inputStr = "123";
	}
	
	@Test
	void validateGameNum() {
		assertEquals(testNumSet.size(), inputStr.length());
	}
	
	@Test
	void checkPatternNum() {
		Pattern numPattern = Pattern.compile("([1-9]{3})");
		Matcher matcher = numPattern.matcher(inputStr);
		assertTrue(matcher.matches());
	}
	
	@Test
	void convertNumSet(){
		Set<Character> distinctCharSet = new LinkedHashSet<>();
		for (char a : inputStr.toCharArray()) {
			distinctCharSet.add(a);
		}
		assertEquals(distinctCharSet.size(), inputStr.length());
	}
}
