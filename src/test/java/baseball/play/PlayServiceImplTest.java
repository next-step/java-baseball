package baseball.play;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.AppConfig;

class PlayServiceImplTest {

	PlayService playService;

	@BeforeEach
	void beforeEach() {
		AppConfig appConfig = new AppConfig();
		playService = appConfig.playService();
	}

	@Test
	@DisplayName("게임이 종료된 이후 재시도 의사를 묻기위한 입력값을 받는 기능 테스트. 예외상황일 경우 0을 리턴한다.")
	void getSelectNumberTest() {
		Method selectNumber;
		try {
			selectNumber = playService.getClass()
				.getDeclaredMethod("getSelectNumber");
			selectNumber.setAccessible(true);

			InputStream in1 = new ByteArrayInputStream("1".getBytes());
			System.setIn(in1);
			Object result1 = selectNumber.invoke(playService);
			Assertions.assertTrue(result1.equals(1));

			InputStream in2 = new ByteArrayInputStream("2".getBytes());
			System.setIn(in2);
			Object result2 = selectNumber.invoke(playService);
			Assertions.assertTrue(result2.equals(2));

			InputStream in3 = new ByteArrayInputStream("aa".getBytes());
			System.setIn(in3);
			Object result3 = selectNumber.invoke(playService);
			Assertions.assertTrue(result3.equals(0));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
