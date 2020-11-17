package pre.baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private Player player;

    public PlayerTest() {
	this.player = new Player(new Scanner(System.in));
    }

    @Test
    void 제로포함() throws Exception {
	Method method;
	method = player.getClass().getDeclaredMethod("hasZero", int.class);
	method.setAccessible(true);

	// given
	int input = 340;

	// when
	boolean result = (boolean) method.invoke(player, input);

	// then
	assertThat(result).as("0이 포함되어 있는지 체크한다").isTrue();
    }

    @Test
    void 자릿수불일치() throws Exception {
	Method method;
	method = player.getClass().getDeclaredMethod("hasNotMatchDigit", int.class);
	method.setAccessible(true);

	// given
	int input = 1234;

	// when
	boolean result = (boolean) method.invoke(player, input);

	// then
	assertThat(result).as("자릿수가 일치하지 않는지 체크한다.").isTrue();

    }

    @Test
    @DisplayName("0이 포함되면 예외가 발생한다.")
    void 유효성_제로포함예외() throws NoSuchMethodException, SecurityException {
	Method method;
	method = player.getClass().getDeclaredMethod("validateInput", int.class);
	method.setAccessible(true);
	// given
	int input = 350;

	// when
	Throwable thrown = catchThrowable(() -> System.out.println((int) method.invoke(player, input)));

	// then
	try {
	    assertThat(thrown.getCause()).isInstanceOf(IllegalArgumentException.class)
		    .hasMessageContaining("0은 포함할 수 없습니다.");
	} catch (AssertionError e) {
	    fail(e.getMessage());
	}

    }

    @Test
    @DisplayName("자릿수가 3자리가 아니면 예외가 발생한다.")
    void 유효성_자릿수불일치예외() throws Exception {
	Method method;
	method = player.getClass().getDeclaredMethod("validateInput", int.class);
	method.setAccessible(true);
	// given
	int input = 1456;

	// when
	Throwable thrown = catchThrowable(() -> System.out.println((int) method.invoke(player, input)));

	// then
	try {
	    assertThat(thrown.getCause()).isInstanceOf(IllegalArgumentException.class)
		    .hasMessageContaining("자리의 숫자만 입력할 수 있습니다.");
	} catch (AssertionError e) {
	    fail(e.getMessage());
	}

    }

}
