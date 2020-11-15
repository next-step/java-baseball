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
@DisplayName("야구 게임 번호 범위 유효성 테스트 클래스")
class NumberRangeValidatorTest {

    private final NumberRangeValidator validator = new NumberRangeValidator(1, 9);

    @Test
    @DisplayName("리스트 내 번호 범위 유효성 테스트 (valid)")
    void numberRangeTestByValidList() {
        // given
        List<Integer> baseballNumbers = Arrays.asList(1, 2, 3);
        // when
        boolean expectValid = validator.validate(baseballNumbers);
        // then
        assertThat(expectValid).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,2,3", "1,2,11"})
    @EmptySource
    @NullSource
    @DisplayName("리스트 내 번호 범위 유효성 테스트 (invalid)")
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