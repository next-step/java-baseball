import java.util.Random;

public class BaseballGame {

	final static Random r = new Random();

	public String generateNumbers(){
		return generateNumbers(null,3);
	}

	public String guess(String answerNumbers, String guessNumbers){

		int ball = 0;
		int strike = 0;

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

		return (strike==0 && ball==0?"낫싱":(strike>0?strike + "스트라이크 ":"")+(ball>0?ball + "볼":""));
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
}
