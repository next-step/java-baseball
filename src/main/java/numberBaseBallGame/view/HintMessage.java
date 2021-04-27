package numberBaseBallGame.view;

import numberBaseBallGame.domain.BallNumberMatchResult;

public class HintMessage {
	public static String setHintMessage(BallNumberMatchResult matchResult){
		String message = "";

		if(matchResult.isNothing()){
			return BaseBallStatus.NOTHING.getMessage();
		}

		if(matchResult.getStrikeCount()>0){
			message += (BaseBallStatus.STRIKE.getMessage()+matchResult.getStrikeCount()+"볼");
		}

		if(matchResult.getBallCount()>0){
			message += (matchResult.getBallCount()+BaseBallStatus.BALL.getMessage());
		}

		return message;
	}
}
