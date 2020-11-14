import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseballNumberFactoryTest {

	@Test
	void 랜덤숫자생성시_각자리가_null_이거나_0이_아니여야함() {
		BaseballNumberFactory baseballNumberFactory = new BaseballNumberFactory();
		BaseballNumber baseballNumber = baseballNumberFactory.generateRandomBaseballNumber();
		System.out.println(baseballNumber);
		assertAll("baseballNumber",
			() -> assertNotEquals(baseballNumber.getUnits(), 0),
			() -> assertNotEquals(baseballNumber.getTens(), 0),
			() -> assertNotEquals(baseballNumber.getHundreds(), 0)
		);
	}

	@Test
	void 랜덤숫자생성시_중복이있으면안됨() {
		BaseballNumberFactory baseballNumberFactory = new BaseballNumberFactory();
		BaseballNumber baseballNumber = baseballNumberFactory.generateRandomBaseballNumber();
		System.out.println(baseballNumber);
		assertAll("baseballNumber",
			() -> assertNotEquals(baseballNumber.getUnits(), baseballNumber.getTens()),
			() -> assertNotEquals(baseballNumber.getTens(), baseballNumber.getHundreds()),
			() -> assertNotEquals(baseballNumber.getHundreds(), baseballNumber.getUnits())
		);
	}
}
