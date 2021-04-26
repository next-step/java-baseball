package com.baseballgame.domain;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseballgame.domain.User;

class UserTest {

	@DisplayName("입력값 유효성 체크 : 문자 입력")
	@Test
	void isValidateInputCase1() {
		User user = new User();
		try {
			Method isValidateInput = user.getClass().getDeclaredMethod("isValidateInput", String.class);
			isValidateInput.setAccessible(true);
			assertThat((boolean)isValidateInput.invoke(user, "1a3")).isFalse();

		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@DisplayName("입력값 유효성 체크 : 숫자만 입력")
	@Test
	void isValidateInputCase2() {
		User user = new User();
		try {
			Method isValidateInput = user.getClass().getDeclaredMethod("isValidateInput", String.class);
			isValidateInput.setAccessible(true);
			assertThat((boolean)isValidateInput.invoke(user, "312")).isTrue();

		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}