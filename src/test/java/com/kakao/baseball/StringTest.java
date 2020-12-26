package com.kakao.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class StringTest {

    @Test
    public void splitTest1(){
        String str = "1,2";
        assertThat(str.split(",")).containsOnly("1","2");
    }

    @Test
    public void splitTest2(){
        String str="1";
        assertThat(str.split(",")).containsExactly("1");
    }

    @Test
    public void substringTest(){
        String str = "(1,2)";
        assertThat(str.substring(1,str.length()-1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAtTest")
    public void charAtTest(){
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> {
            assertThat(str.charAt(3)).isEqualTo('d');
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}
