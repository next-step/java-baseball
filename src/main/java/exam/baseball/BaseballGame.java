package exam.baseball;

import java.util.function.Supplier;

public class BaseballGame implements Game {

	private final Supplier<String> userCommandSupplier;

	public BaseballGame(Supplier<String> userCommandSupplier) {
		this.userCommandSupplier = userCommandSupplier;
	}

	@Override
	public void start() {
		String pitchingCommand = getPitchingCommand(userCommandSupplier);
		System.out.println("3 스트라이크");
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	@Override
	public void exit() {
		System.out.println("게임이 완전히 종료되었습니다.");
	}

	@Override
	public boolean restart() {
		String input = getRestartCommand(userCommandSupplier);
		if (input.equals("1")) {
			return true;
		}
		return false;
	}

	private String getPitchingCommand(Supplier<String> userCommandSupplier) {
		String input;
		do {
			System.out.print("숫자를 입력해주세요 : ");
			input = userCommandSupplier.get();
			System.out.println(input);
		} while (isIncorrectPitchingCommand(input));
		return input;
	}

	boolean isIncorrectPitchingCommand(String hitterCommand) {
		if (hitterCommand == null) {
			return true;
		}
		String pattern = "[1-9]{3}";
		return !hitterCommand.matches(pattern);
	}

	private String getRestartCommand(Supplier<String> userCommandSupplier) {
		String input;
		do {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			input = userCommandSupplier.get();
		} while (isIncorrectRestartCommand(input));
		return input;
	}

	boolean isIncorrectRestartCommand(String restartCommand) {
		if (restartCommand == null) {
			return true;
		}
		if (restartCommand.equals("1") || restartCommand.equals("2")) {
			return false;
		}
		return true;
	}
}
