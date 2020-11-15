package com.ssabae.woowahantech.domain.baseballnumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-16
 */
@DisplayName("야구 번호 객체 테스트 클래스")
class BaseballNumbersTest {

    @Test
    @DisplayName("야구 번호 리턴 객체 불변성 테스트")
    void getBaseballNumberListTest() {
        // given
        List<Integer> gameNumberList = Arrays.asList(1, 2, 3);
        BaseballNumbers baseballNumbers = new BaseballNumbers(gameNumberList);
        // when
        List<Integer> immutableList = baseballNumbers.getBaseballNumberList();
        // then
        assertThrows(UnsupportedOperationException.class, () -> immutableList.add(1));
    }

}