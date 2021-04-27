package imjeong.precourse.baseball;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 학습테스트 진행 방식<br/>
 * String 클래스에 대한 학습 테스트
 * @author In Mook, Jeong
 * @since 2021.04.26
 */
public class StringTest {
 
 @Test
 @DisplayName("String split test: 요구사항1-1")
 void splitTest() {
  String sampleStr = "1,2";
  String[] sampleStrArray = sampleStr.split(",");
  String [] resultString = {"1","2"};
  assertArrayEquals(sampleStrArray, resultString);
 }
 
 @Test
 @DisplayName("String split and contain test: 요구사항1-2")
 void splitAndContainTest() {
  String sampleStr = "1,2";
  String[] sampleStrArray = sampleStr.split(",");
  Assertions.assertThat(sampleStrArray).contains("1");
 }
 
 @Test
 @DisplayName("Substring test: 요구사항2")
 void substringTest() {
  String sampleStr = "(1,2)";
  sampleStr = sampleStr.substring(sampleStr.indexOf("(")+1, sampleStr.indexOf(")"));
  assertEquals(sampleStr, "1,2");
 }
 
 int index = 0;
 @Test
 @DisplayName("String charAt method test: 요구사항3")
 void stringCharAtTest() {
  String sampleStr = "abc";
  int size = sampleStr.length();
  index = 0;
  Assertions.assertThatThrownBy(() -> {
   for(int i=0; i<=size; i++) {
    this.index = i;
    sampleStr.charAt(i);
   }
  }).isInstanceOf(IndexOutOfBoundsException.class)
    .hasMessageContaining("Index: " + index + ", Size : " + size);
 }
}
