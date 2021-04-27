package exam.baseball;

import java.util.function.Supplier;

public class BaseballGame implements Game {

	private final Supplier<String> userCommandSupplier;
	private final MessagePrinter printer = new MessagePrinter();

	public BaseballGame(Supplier<String> userCommandSupplier) {
		this.userCommandSupplier = userCommandSupplier;
	}

	private String getRandomNumbers() {
		return "123";
	}

	@Override
	public void start() {
		BaseballRule rule = new BaseballRule(getRandomNumbers());
		String command = null;
		while (rule.isNotThreeStrike(command)) {
			command = getPitchingCommand(userCommandSupplier);
			Score score = rule.checkPitching(command);
			printer.printMessage(makeHint(score));
		}
		printer.printMessage("3개의 숫자를 모두 맞히셨습니다! 게임종료");
	}

	@Override
	public void exit() {
		printer.printMessage("게임이 완전히 종료되었습니다.");
	}

	@Override
	public boolean restart() {
		String input = getRestartCommand(userCommandSupplier);
		if (input.equals("1")) {
			return true;
		}
		return false;
	}

	String makeHint(Score score) {
		if (score.getStrike() == 0 && score.getBall() == 0) {
			return "낫싱";
		}
		if (score.getStrike() > 0 && score.getBall() > 0) {
			return String.format("%d 스트라이크 %d 볼", score.getStrike(), score.getBall());
		}
		if (score.getBall() > 0) {
			return String.format("%d 볼", score.getBall());
		}
		return String.format("%d 스트라이크", score.getStrike());
	}

	private String getPitchingCommand(Supplier<String> userCommandSupplier) {
		String input;
		do {
			printer.printForInput("숫자를 입력해주세요 : ");
			input = userCommandSupplier.get();
			printer.printMessage(input);
		} while (isIncorrectPitchingCommand(input));
		return input;
	}

	boolean isIncorrectPitchingCommand(String hitterCommand) {
		String pattern = "[1-9]{3}";
		if (hitterCommand == null || !hitterCommand.matches(pattern)) {
			String errMsg = "잘못된 값을 입력하셨습니다. 세자리 수를 입력해야 합니다. 입력값: " + hitterCommand;
			printer.printMessage(errMsg);
			return true;
		}
		return false;
	}

	private String getRestartCommand(Supplier<String> userCommandSupplier) {
		String input = null;
		do {
			printer.printMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			input = userCommandSupplier.get();
		} while (isIncorrectRestartCommand(input));
		return input;
	}

	boolean isIncorrectRestartCommand(String restartCommand) {
		if (restartCommand != null
			&& (restartCommand.equals("1") || restartCommand.equals("2"))) {
			return false;
		}
		printer.printMessage("잘못된 값을 입력하셨습니다. 입력값: " + restartCommand);
		return true;
	}

}
