package com.baseball.rule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BallGenerator {
	static int LENGTH = 3;

	public int generateRandomDigit(){
		return new Random().nextInt(9)+1;
	}

	public List<Integer> generateNumber(){
		Set<Integer> randomNumberSet = new LinkedHashSet<>();
		for (int i = 0; i < LENGTH; i++){
			int randomDigit = generateRandomDigit();
			if(!randomNumberSet.contains(randomDigit)){
				randomNumberSet.add(randomDigit);
			} else {
				i--;
			}
		}
		return new ArrayList<>(randomNumberSet);
	}
}
