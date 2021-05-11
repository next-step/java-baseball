import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputReader {

	BufferedReader bufferedReader;

	public UserInputReader() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * 사용자 값 입력 받아서 저장
	 * @return 입력받은 사용자 숫자 리스트
	 */
	public String makeUserNumbers() throws Exception {
		String result;
		System.out.print("숫자를 입력해 주세요 : ");
		result = bufferedReader.readLine();
		return result;
	}

	public boolean requestReGame() throws IOException {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		String input = bufferedReader.readLine();
		if ("1".equals(input)) {
			return true;
		}
		return false;
	}

	public void closeBuffer() throws IOException {
		bufferedReader.close();
	}
}
