package com.nextstep.baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidationCheckTest {
	
	@Test
	void testCheckRule() {
		assertTrue(ValidationCheck.checkRule("135"));
		assertTrue(ValidationCheck.checkRule("248"));
		assertTrue(ValidationCheck.checkRule("579"));
	}
	
	@Test
	void testNumCheck() {
		assertTrue(ValidationCheck.numCheck("135"));
		assertTrue(ValidationCheck.numCheck("248"));
		assertTrue(ValidationCheck.numCheck("579"));
	}

	@Test
	void testLengthCheck() {
		assertTrue(ValidationCheck.lengthCheck("135",3));
		assertTrue(ValidationCheck.lengthCheck("248",3));
		assertTrue(ValidationCheck.lengthCheck("579",3));
	}

	@Test
	void testOverlapCheck() {
		assertTrue(ValidationCheck.overlapCheck("135"));
		assertTrue(ValidationCheck.overlapCheck("248"));
		assertTrue(ValidationCheck.overlapCheck("579"));
	}
	
	@Test
	void testCompareString() {
		assertEquals(1, ValidationCheck.compareString("123", "123"));
		assertEquals(1, ValidationCheck.compareString("248", "248"));
		assertEquals(1, ValidationCheck.compareString("579", "579"));
	}
}
