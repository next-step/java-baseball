package com.ssabae.woowahantech.presentation;

import com.ssabae.woowahantech.domain.baseballnumber.BaseballNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-16
 */
@DisplayName("사용자 입력값 파싱 테스트 클래스")
class UserInputNumberParserTest {

    private final UserInputNumberParser parser = new UserInputNumberParser();

    @Test
    @DisplayName("사용자 입력값 파싱 테스트 (valid)")
    void userInputNumberParseTest() {
        // given
        String str = "123";
        // when
        BaseballNumbers parse = parser.parse(str);
        List<Integer> baseballNumberList = parse.getBaseballNumberList();
        // then
        assertThat(baseballNumberList).hasSize(3);
        assertThat(baseballNumberList).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("사용자 입력값 파싱 테스트 (less than size)")
    void userInputNumberParseByLessThanSizeTest() {
        // given
        String str = "12";
        // when
        BaseballNumbers parse = parser.parse(str);
        List<Integer> baseballNumberList = parse.getBaseballNumberList();
        // then
        assertThat(baseballNumberList).hasSize(2);
        assertThat(baseballNumberList).containsExactly(1, 2);
    }

    @Test
    @DisplayName("사용자 입력값 파싱 테스트 (larger than size)")
    void userInputNumberParseByLargerThanSizeTest() {
        // given
        String str = "1234";
        // when
        BaseballNumbers parse = parser.parse(str);
        List<Integer> baseballNumberList = parse.getBaseballNumberList();
        // then
        assertThat(baseballNumberList).hasSize(4);
        assertThat(baseballNumberList).containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("사용자 입력값 파싱 테스트 (with alphabet)")
    void userInputNumberParseByWithAlphabet() {
        // given
        String str = "1bc";
        // when
        BaseballNumbers parse = parser.parse(str);
        List<Integer> baseballNumberList = parse.getBaseballNumberList();
        // then
        assertThat(baseballNumberList).hasSize(1);
        assertThat(baseballNumberList).containsExactly(1);
    }

}