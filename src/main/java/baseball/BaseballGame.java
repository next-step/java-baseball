package baseball;

import java.util.*;

public class BaseballGame extends BaseballValidationChecker{

	private String randomBall;
	private BaseballScore baseballScore;

	public BaseballGame(){
		Set<Integer> tmp = new HashSet();
		Random random = new Random();
		for(; tmp.size() < 3 ;){
			tmp.add(random.nextInt(8)+1);
		}
		setRandomBall(setNumber(shuffleNumber(tmp)));
	}

	private String setNumber(List list) {
		String result = "";
		for(int i = 0 ; i < list.size() ; i++){
			result += list.get(i);
		}
		return result;

	}

	private List shuffleNumber(Set hashSet) {
		List list = new ArrayList();
		Iterator<Integer>  iter = hashSet.iterator();
		while (iter.hasNext()){
			list.add(iter.next());
		}
		Collections.shuffle(list);

		return list;
	}

	private void setRandomBall(String randomBall) {
		this.randomBall = randomBall;
	}

	public String getRandomBall() {
		return randomBall;
	}

	public String checkResult(String input){
		baseballScore = new BaseballScore();

		for ( int i = 0 ; i < input.length() ; i++){
			checkStrike(input.charAt(i)+"",i);
			checkBall(input.charAt(i)+"",i);
		}
		return baseballScore.getResult();

	}
	private void checkStrike(String ball , int position){
		//System.out.println(randomBall.charAt(position) + " " + ball);
		if(randomBall.contains(ball) && ball.equals(randomBall.charAt(position)+"")){
			baseballScore.countUpStrike();
		}

	}
	private void checkBall(String ball , int position){
		//System.out.println(randomBall.charAt(position) + " " + ball);
		if(randomBall.contains(ball) && !ball.equals(randomBall.charAt(position)+"")){
			baseballScore.countUpBall();
		}

	}

}
