package roles;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PitcherTest {

	Pitcher pitcher = new Pitcher();
	
	@Test
	void convertStringToIntegerList() {
		try {
			// given
			Method method = pitcher.getClass().getDeclaredMethod("convertStringToIntegerList", String.class);
			method.setAccessible(true);

			String validText = "123";
			List<Integer> result = new ArrayList<>();
			result.add(1);
			result.add(2);
			result.add(3);

			// when
			List<Integer> integers = (List<Integer>)method.invoke(pitcher, validText);

			// then
			assertThat(integers).isEqualTo(result);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	void validInputNumber() {
		try {
			// given
			Method method = pitcher.getClass().getDeclaredMethod("validInputNumber", String.class);
			method.setAccessible(true);

			String validText = "123";
			String invalidLengthText = "12";
			String invalidNumberTypeText = "a12";
			String invalidDuplicateNumbersText = "122";

			// when
			boolean valid = (boolean)method.invoke(pitcher, validText);
			boolean invalidLength = (boolean)method.invoke(pitcher, invalidLengthText);
			boolean invalidNumberType = (boolean)method.invoke(pitcher, invalidNumberTypeText);
			boolean invalidDuplicateNumbers = (boolean)method.invoke(pitcher, invalidDuplicateNumbersText);

			// then
			assertThat(valid).isEqualTo(true);
			assertThat(invalidLength).isEqualTo(false);
			assertThat(invalidNumberType).isEqualTo(false);
			assertThat(invalidDuplicateNumbers).isEqualTo(false);

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}