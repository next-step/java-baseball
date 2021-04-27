import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

	final static Random r = new Random();

	final String CONTINUE = "1";
	final String EXIT = "2";

	boolean running = true;
	boolean exit = false;

	public void run(){
		Scanner sc = new Scanner(System.in);
		while(!exit){
			play(sc);
			continueOrExit(sc.next());
		}
		sc.close();
	}

	public void continueOrExit(String continuePlay){
		if(CONTINUE.equals(continuePlay)){
			running = true;
		}
		if(EXIT.equals(continuePlay)){
			exit = true;
		}
	}

	private void play(Scanner sc){
		String answer = generateNumbers();
		String guess = "";
		while(running){
			print("숫자를 입력해주세요:");
			guess = getGuessAndPrint(sc);
			println(guess(answer,guess));
		}
	}

	public void print(String output){
		System.out.print(output);
	}

	public void println(String output){
		System.out.println(output);
	}

	private String getGuessAndPrint(Scanner sc){
		String guess = sc.next();
		println(guess);
		return guess;
	}

	public String generateNumbers(){
		return generateNumbers(null,3);
	}

	public String guess(String guessNumbers,String answerNumbers){
		int[] count = {0,0};
		return output(guess(guessNumbers,answerNumbers,count));
	}

	private int[] guess(String guessNumbers,String answerNumbers,int[] count){
		int index = 0;

		String[] splitedGuessNumbers = guessNumbers.split("");

		for(String guessNumber : splitedGuessNumbers){
			count = checkNumbers(guessNumber, answerNumbers, index++, count);
		}
		return count;
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


	private String output(int[] count){

		int strike = count[0];
		int ball = count[1];

		return output(strike, ball);
	}

	private String output(int strike, int ball){
		return isNothing(strike,ball)?"낫싱":(isStrike(strike,ball)?outputContinueOrExit():outputStrikeOrBall(strike,ball));
	}

	private boolean isStrike(int strike,int ball){
		return strike==3;
	}

	private boolean isNothing(int strike,int ball){
		return strike==0 && ball==0;
	}

	private String outputContinueOrExit(){
		running = false;
		return "3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	}


	private String outputStrikeOrBall(int strike, int ball){
		String strikeOutput = strike>0? strike + "스트라이크":"";
		String ballOutput = ball>0?ball + "볼":"";
		return strikeOutput + (strikeOutput.length()>0 && ballOutput.length()>0 ? " ":"") + ballOutput;
	}


	private int[] checkNumbers(String guessNumber,String answerNumbers, int index, int[] count) {
		String answerNumber = answerNumbers.substring(index,index+1) ;
		if(isNothing(guessNumber, answerNumbers)){
			return count;
		}
		return checkNumber(guessNumber, answerNumber, count);
	}

	private boolean isNothing(String guessNumber, String answerNumbers){
		return answerNumbers.indexOf(guessNumber) < 0;
	}


	private int[] checkNumber(String guessNumber, String answerNumber,int[] count){
		if(guessNumber.equals(answerNumber)){
			count[0]+=1;
			return count;
		}
		count[1]+=1;
		return count;
	}

}
