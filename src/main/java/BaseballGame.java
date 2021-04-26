import java.util.Random;

public class BaseballGame {

	final static Random r = new Random();

	public String generateNumbers(){
		return generateNumbers(null,3);
	}

	public String guess(String answerNumbers, String guessNumbers){

		int strike = 0;
		int ball = 0;

		String[] splitedAnswerNumbers = answerNumbers.split("");
		String[] splitedGuessNumbers = guessNumbers.split("");

		int i = -1;
		for(String guessNumber : splitedGuessNumbers){
			i++;
			if(answerNumbers.indexOf(guessNumber) < 0){
				continue;
			}

			if(guessNumber.equals(splitedAnswerNumbers[i])){
				strike+=1;
				continue;
			}
			ball+=1;
		}

		return output(strike,ball);
	}

	private String generateNumbers(String all,int length){
		if(all==null) all="";
		if(all.length() == length){
			return all;
		}
		String number = generateNumberNotZero();
		return  generateNumbers(all+(all.indexOf(number) < 0?number:""),length);
	}

	private String generateNumberNotZero(){
		int number = r.nextInt(10);
		if(number==0) return generateNumberNotZero();
		return number+"";
	}

	private String output(int strike, int ball){

		if(strike==0 && ball==0){
			return "낫싱";
		}


		if(strike==3){
			return "3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
		}

		String strikeOutput = strike>0? strike + "스트라이크":"";
		String ballOutput = ball>0?ball + "볼":"";

		return strikeOutput + ballOutput;
	}
}
