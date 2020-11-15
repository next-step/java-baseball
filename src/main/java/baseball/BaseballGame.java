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
}
