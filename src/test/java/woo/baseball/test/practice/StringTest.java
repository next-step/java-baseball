package woo.baseball.test.practice;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * @author : chano
 * @Date : 2020. 11. 11.
 * @Description : String Class에 대한 테스트
 */
public class StringTest {

  @Test
  @DisplayName("StringSplit1Test")
    void splitTest1() {
    String strArray = "1,2";
    assertThat("[1, 2]").contains(Arrays.asList(strArray.split(",")));
    strArray = "1";
    assertThat("[1]").contains(Arrays.asList(strArray.split(",")));
  }
 
  @Test
  @DisplayName("StringSplit2Test")
    void splitTest2() {
    String strArray = "(1,2)";
    assertThat("1,2").contains(strArray.substring(1, strArray.length()-1));
  }
  
  @Test
  @DisplayName("StringIndexOutOfBoundsExceptionTest")
    void StringIndexOutOfBoundsExceptionTest() {
    String strArray = "abc";
    int size = 4;
    assertThatThrownBy(() ->{
    strArray.charAt(size);
    }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: "+size);
  }
  
}
