package baseball;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
class NextStepInputConverter {

	private NextStepInputConverter() {

	}

	static NextStepType convert(String input) {
		int code;
		try {
			code = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new WrongNextStepInputException();
		}

		return NextStepType.findBy(code);
	}
}
