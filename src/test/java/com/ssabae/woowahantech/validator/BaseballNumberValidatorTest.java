package com.ssabae.woowahantech.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-13
 */
@DisplayName("야구 게임 번호 유효성 테스트 클래스")
class BaseballNumberValidatorTest {

    private final BaseballNumberValidator validator = new BaseballNumberValidator();

    @Test
    @DisplayName("야구 게임 번호 유효성 테스트 (valid)")
    void baseballNumberTestByValidList() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 9);
        // when
        boolean expectValid = validator.validate(numbers);
        // then
        assertThat(expectValid).isTrue();
    }


    @ParameterizedTest
    @ValueSource(strings = {"0,2,9", "1,10,11", "1,2,2", "1,2", "1,2,3,4"})
    @EmptySource
    @NullSource
    @DisplayName("야구 게임 번호 유효성 테스트 (invalid)")
    void numberRangeTestByInvalidList(String messege) {
        System.out.println("messege = " + messege);
        // given
        List<Integer> collect = CommonValidatorHelper.convertStringToNumberList(messege);
        // when
        boolean expectInvalid = validator.validate(collect);
        // then
        assertThat(expectInvalid).isFalse();
    }

}