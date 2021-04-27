package view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrintStreamOutputViewTest {

	@Test
	@DisplayName("사용자가 숫자를 입력 할때는 '숫자를 입력해주세요 : ' 라는 메시지가 프린트 된다.")
	public void printInputNumberMessageTest() {
		// given
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStreamOutputView printStreamOutputView = generatePrintStreamOutputView(byteArrayOutputStream);

		// when
		printStreamOutputView.printInputNumberMessage();

		// then[
		assertThat(byteArrayOutputStream.toString()).isEqualTo("숫자를 입력해주세요 : ");
	}

	@Test
	@DisplayName("사용자가 게임을 종료 할때는 'N개의 숫자를 모두 맞히셨습니다! 게임 종료\n' 라는 메시지가 프린트 된다.'")
	public void printEndGameMessageTest() {
		// given
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStreamOutputView printStreamOutputView = generatePrintStreamOutputView(byteArrayOutputStream);
		int numberLength = 3;
		// when
		printStreamOutputView.printEndGameMessage(numberLength);

		// then[
		assertThat(byteArrayOutputStream.toString()).isEqualTo(
			String.format("%s개의 숫자를 모두 맞히셨습니다! 게임 종료\n", numberLength));
	}

	@Test
	@DisplayName("사용자가 게임을 종료 후 재시작 유무를 물을때 '게임을 새로 시작하려면 X, 종료하려면 X를 입력하세요.\n' 라는 메시지가 프린트 된다.'")
	public void printNewGameMessageTest() {
		// given
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStreamOutputView printStreamOutputView = generatePrintStreamOutputView(byteArrayOutputStream);
		String restartCommand = "Y";
		String endCommand = "N";
		// when
		printStreamOutputView.printNewGameMessage(restartCommand, endCommand);

		// then[
		assertThat(byteArrayOutputStream.toString()).isEqualTo(
			String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n", restartCommand, endCommand));
	}

	private PrintStreamOutputView generatePrintStreamOutputView(ByteArrayOutputStream byteArrayOutputStream) {
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		return new PrintStreamOutputView(printStream);
	}

}
