package numberBaseBallGame.view;

import numberBaseBallGame.domain.BallNumberMatchResult;

public class HintMessage {
	public static String setHintMessage(BallNumberMatchResult matchResult){
		String message = "";

		if(matchResult.isNothing()){
			return BaseBallStatus.NOTHING.getMessage();
		}

		if (matchResult.getBallCount() == matchResult.GAMENUMBERS_LENGTH){
			return "3개의숫자를모두맞히셨습니다!게임종료";
		}

		if(matchResult.getStrikeCount()>0){
			message += (BaseBallStatus.STRIKE.getMessage()+matchResult.getStrikeCount() + "볼");
		}

		if(matchResult.getBallCount()>0){
			message += (matchResult.getBallCount()+BaseBallStatus.BALL.getMessage());
		}

		return message;
	}
}
