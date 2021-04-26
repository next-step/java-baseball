package exam.baseball;

import java.util.function.Supplier;

public class BaseballGame implements Game {

	private final Supplier<String> userCommandSupplier;
	public BaseballGame(Supplier<String> userCommandSupplier) {
		this.userCommandSupplier = userCommandSupplier;
	}

	@Override
	public void start() {
		System.out.println("숫자를 입력해주세요: ...");
		System.out.println("1 볼");
		System.out.println("3 스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	@Override
	public void exit() {
		System.out.println("게임이 완전히 종료되었습니다.");
	}

	@Override
	public boolean restart() {
		String input = getRestartUserCommand(userCommandSupplier);
		if (input.equals("1")) {
			return true;
		}
		return false;
	}

	private String getRestartUserCommand(Supplier<String> checkRestart) {
		String input;
		do {
			input = checkRestart.get();
		} while (isIncorrectCommand(input));
		return input;
	}

	private boolean isIncorrectCommand(String restartCommand) {
		if (restartCommand.equals("1") || restartCommand.equals("2")) {
			return false;
		}
		return true;
	}
}
