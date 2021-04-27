package imjeong.precourse.baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 학습테스트 진행 방식<br/>
 * Set Collection에 대한 학습 테스트
 * @author In Mook, Jeong
 * @since 2021.04.26
 */
public class SetTest {
 private Set<Integer> numbers;
 
 @BeforeEach
 void setUp() {
  numbers = new HashSet<Integer>();
  numbers.add(1);
  numbers.add(1);
  numbers.add(2);
  numbers.add(3);
 }
 
 @Test
 @DisplayName("Check set collection size: 요구사항1")
 void checkSetSizeTest() {
  assertEquals(numbers.size(), 3);
  assertEquals(numbers.size(), 4);
 }
 
 @ParameterizedTest
 @ValueSource(ints = {1,2,3})
 @DisplayName("Check set Contains: 요구사항2")
 void setContainsTest(int number) {
  assertTrue(numbers.contains(number));
 }
 
 @ParameterizedTest
 @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
 @DisplayName("Check set Contains: 요구사항3")
 void setContains2Test(int input, boolean expected) {
  assertEquals(numbers.contains(input), expected);
 }
}
