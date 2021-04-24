package view;

import domain.Numbers;

public class OutputMessage {

	public static final OutputMessage outputMessage = new OutputMessage();
	private OutputMessage(){ }

	public static void printMessage(Message message){
		System.out.print(message.getText());
	}

	public static void printResult(int strike, int ball){
		StringBuilder result = new StringBuilder();
		buildStrikeResult(strike, result);
		if(strike < Numbers.MAX_SIZE){
			buildBallResult(ball, result);
		}
		if(strike == 0 && ball == 0) {
			result.append(Message.NOTHING.getText());
		}
		System.out.println(result.toString());
	}

	private static void buildBallResult(int ball, StringBuilder result) {
		if(ball>0) result.append(ball).append(Message.BALL.getText() + " ");
	}

	private static void buildStrikeResult(int strike, StringBuilder result) {
		if(strike>0) result.append(strike).append(Message.STRIKE.getText() + " ");
	}

}
