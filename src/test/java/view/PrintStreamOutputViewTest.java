package view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import number.Numbers;

public class PrintStreamOutputViewTest {

	@Test
	@DisplayName("사용자가 숫자를 입력 할때는 '숫자를 입력해주세요 : ' 라는 메시지가 프린트 된다.")
	public void printInputNumberMessageTest() {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		PrintStreamOutputView printStreamOutputView = new PrintStreamOutputView(printStream);

		// when
		printStreamOutputView.printInputNumberMessage();

		// then[
		assertThat(byteArrayOutputStream.toString()).isEqualTo("숫자를 입력해주세요 : ");
	}

	@Test
	@DisplayName("사용자가 게임을 종료 할때는 '3개의 숫자를 모두 맞히셨습니다! 게임 종료\n' 라는 메시지가 프린트 된다.'")
	public void printEndGameMessageTest() {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		PrintStreamOutputView printStreamOutputView = new PrintStreamOutputView(printStream);

		// when
		printStreamOutputView.printEndGameMessage(Numbers.LENGTH);

		// then[
		assertThat(byteArrayOutputStream.toString()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
	}

}
