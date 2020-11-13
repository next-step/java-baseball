package utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.BaseballNumber;
import domain.BaseballNumbers;

/**
 * @author : byungkyu
 * @date : 2020/11/12
 * @description : 야구게임 숫자 생성 테스트케이스
 **/
class BaseballNumberFactoryTest {
	private BaseballNumberFactory baseballNumberFactory;

	@BeforeEach
	void init() {
		baseballNumberFactory = new BaseballNumberFactory();
	}

	@Test
	@DisplayName("1.1.야구게임_숫자_생성/생성확인")
	void createBaseballNumbers() {
		BaseballNumbers baseballNumbers = baseballNumberFactory.generateNumbers();
		assertThat(!baseballNumbers.isEmpty());
	}

	@Test
	@DisplayName("1.2.야구게임_숫자_생성/생성된_숫자가_1부터_9사이에_존재")
	void createBaseballNumbersAndCheckNumberBoundary() {
		BaseballNumbers baseballNumbers = baseballNumberFactory.generateNumbers();
		for (BaseballNumber baseballNumber : baseballNumbers.getValues()) {
			assertTrue(baseballNumber.getValue() >= BaseballNumbers.MINIMUM_NUMBER_OF_BASEBALL_GAME);
			assertTrue(baseballNumber.getValue() <= BaseballNumbers.MAXIMUM_NUMBER_OF_BASEBALL_GAME);
		}
	}

	@Test
	@DisplayName("1.3.야구게임_숫자_생성/3자리의 수 생성")
	void createBaseballNumbersAndCheckNumbersDifferent() {
		BaseballNumbers baseballNumbers = baseballNumberFactory.generateNumbers();
		assertEquals(baseballNumbers.size(), BaseballNumbers.NUMBER_OF_BASEBALL_GAME);
	}

	@Test
	@DisplayName("1.4.야구게임_숫자_생성/중복되지 않은 숫자")
	void createBaseballNumbersAndCheckNotDuplicate() {
		BaseballNumbers baseballNumbers = baseballNumberFactory.generateNumbers();
		Set<BaseballNumber> tempBaseballNumbers = new HashSet<>(baseballNumbers.getValues());
		assertEquals(baseballNumbers.size(), tempBaseballNumbers.size());
	}

}