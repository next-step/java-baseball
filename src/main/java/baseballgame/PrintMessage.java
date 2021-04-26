package baseballgame;

public class PrintMessage {

	public String getResultString(BaseBallResult result) {
		StringBuilder stringBuilder = new StringBuilder();

		if(result.getErrorMessage() != null){
			return result.getErrorMessage();
		}

		if(result.isNothing()){
			return getNothingString();
		}

		stringBuilder.append(getStrikeString(result.getStrikeCount()));
		stringBuilder.append(getBallString(result.getBallCount()));

		return stringBuilder.toString();
	}

	private String getNothingString(){
		return PrintMessageEnum.NOTHING.getMessage();
	}

	private String getStrikeString(int strikeCount){
		String strikeString = "";
		if (strikeCount > 0) {
			strikeString = String.format(PrintMessageEnum.STRIKE.getMessage(), strikeCount);
		}
		return strikeString;
	}

	private String getBallString(int ballCount){
		String ballString = "";
		if (ballCount > 0) {
			ballString = String.format(PrintMessageEnum.BALL.getMessage(), ballCount);
		}
		return ballString;
	}
}
