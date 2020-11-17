package service.user;

import java.util.*;

public class ComputerApiLogicService {
	private final int PERMIT_LENGTH = 3;

	public List<Integer> setToList(Set<Integer> randomNumber) {
		return new ArrayList<>(randomNumber);
	}

	public List<Integer> stringToList(String inputNumber) {
		List<Integer> inputNumberList = new ArrayList<>();

		for(int i=0; i<inputNumber.length(); i++) {
			inputNumberList.add(Integer.parseInt(inputNumber.substring(i,i+1)));
		}

		return inputNumberList;
	}

	public Set<Integer> makeRandomNumber() {
		Set<Integer> numberSet = new HashSet<>();

		while (numberSet.size() < PERMIT_LENGTH) {
			numberSet.add((int) (Math.random() * 9 + 1));
		}

		return numberSet;
	}

	public int calcStrike(List<Integer> inputNumberList, List<Integer> randomNumberList) {
		int strike = 0;
		for(int i = 0; i < PERMIT_LENGTH; i++) {
			if(inputNumberList.get(i).intValue() == randomNumberList.get(i).intValue())
				strike++;
		}
		
		return strike;
	}

	public int calcBall(List<Integer> inputNumberList, List<Integer> randomNumberList) {
		int ball = 0;
		int i = 0;
		int j = 0;
		
		while(i < PERMIT_LENGTH) {
			if(i != j && inputNumberList.get(i).intValue() == randomNumberList.get(j).intValue())
				ball++;
			
			j++;
			if(j==3) {
				i++;
				j=0;
			}
		}
		
		return ball;
	}
	
	public Map<String, Integer> returnResultBaseballGame(List<Integer> inputNumberList, List<Integer> randomNumberList) {
		Map<String, Integer> resultMap = new HashMap<>();

		int strike = calcStrike(inputNumberList, randomNumberList);
		int ball = calcBall(inputNumberList, randomNumberList);

		resultMap.put("strike",strike);
		resultMap.put("ball",ball);

		return resultMap;
	}
}