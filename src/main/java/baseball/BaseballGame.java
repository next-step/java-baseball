package baseball;

import java.util.*;

public class BaseballGame {

	private String randomBall;

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

	public boolean checkRule(String input){
		if(!checkNum(input))
			return false;
		if(!checkLength(input))
			return false;
		if (!checkOverlap(input))
			return false;
		return true;
	}
	private boolean checkNum(String input){
		try {
			Integer.parseInt(input);
		}catch (NumberFormatException e){
			return false;
		}
		return true;
	}
	private boolean checkLength(String input){
		if (input.length() == 3){
			return true;
		}
		return false;
	}
	private boolean checkOverlap(String input){
		char first = input.charAt(0);
		char second =input.charAt(1);
		char third =input.charAt(2);

		if(first != second && second != third && first != third ) {
			return true;
		}
		return false;
	}

}
