package me.nimkoes.baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.nimkoes.baseball.view.CommandLine;

class BaseballControllerTest {

    BaseballController baseballController;

    @BeforeEach
    void setUp() {
        baseballController = new BaseballController(CommandLine.getInstance());
    }

    @Test
    @DisplayName("난수 생성 기능 테스트")
    void generateRandomNumber() {

        try {

            // given
            Method testPrivateMethod = BaseballController.class.getDeclaredMethod("generateRandomNumber");
            testPrivateMethod.setAccessible(true);

            // when
            String generatedValue = (String) testPrivateMethod.invoke(baseballController);

            // then
            assertThat(generatedValue)
                    .isNotEmpty()
                    .isNotBlank()
                    .isInstanceOf(String.class)
                    .matches("^[0-9]+$");

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            // 테스트 도중 예외가 발생하면 실패한 테스트로 판단
            fail();
        }
    }

}
