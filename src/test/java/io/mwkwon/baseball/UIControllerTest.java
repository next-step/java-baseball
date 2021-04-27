package io.mwkwon.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class UIControllerTest {

    private UIController uiController;

    @BeforeEach
    void setUp() {
        uiController = new UIController(new Scanner(System.in), new BaseBallGame());
    }

    @ParameterizedTest
    @DisplayName("validInputString method 사용자 입력 값 정상 데이터 여부 판단 테스트")
    @CsvSource(value = {
            "'':[1-9]{3}:3:false"
            , "333:[1-9]{3}:3:false"
            , "123:[1-9]{3}:3:true"
            , "1243:[1-9]{3}:3:false"
            , "가3:[1-9]{3}:3:false"
            , "023:[1-9]{3}:3:false"
            , "1:[1-2]{1}:1:true"
            , "2:[1-2]{1}:1:true"
            , "가나아ㅏ:[1-2]{1}:1:false"
            , "3:[1-2]{1}:1:false"
    }, delimiter = ':')
    void validInputStringTest(String inputString, String regex, int strLength, boolean expected) {
        boolean valid = uiController.validInputString(inputString, regex, strLength);
        assertThat(valid).isEqualTo(expected);
    }
}