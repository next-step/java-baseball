package main.java;

import java.util.HashSet;
import java.util.Set;

public class Computer {
	
	private String numbers;
	
	public Computer() {
		this.setNumbers();
	}
	
	public String getNumbers(){
		return this.numbers;
	}
	
	public void setNumbers() {
		StringBuilder numbers = new StringBuilder();
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<3;i++) {
			addValidNumberToList(numbers, set);
		}
		this.numbers = numbers.toString();
		
	}

	private void addValidNumberToList(StringBuilder numbers, Set<Integer> set) {
		int number = 0;
		
		do {
			number=(int)(Math.random()*9+1);
		}while(set.contains(number));	
		numbers.append((char)(number+'0'));
		set.add(number);
	}

}
