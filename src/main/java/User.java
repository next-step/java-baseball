package main.java;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class User {
	
	private String numbers; 
	private static final int LEN = 3;
	private static final String numPattern = "^[1-9]*$";
	
	public String getNumbers(){
		return this.numbers;
	}
	
	public void setNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		Scanner sc = new Scanner(System.in);		
		String input = sc.nextLine();
		if(checkValidInput(input))
			this.numbers = new String(input);
	}
	
	public boolean checkValidInput(String input) {
		if(!input.matches(numPattern))
			throw new IllegalArgumentException("ERROR: 입력 값이 잘못 되었습니다.");
		if(input.length() != LEN)
			throw new IllegalArgumentException("ERROR: 3자리가 아닙니다.");
		
		Set<Character> set = new HashSet<>();
		for(int i=0;i<input.length();i++) {
			checkDuplicate(input,i, set);
			set.add(input.charAt(i));
		}
		return true;	
	}
	
	private void checkDuplicate(String input, int idx, Set<Character> set) {
		if(set.contains(input.charAt(idx)))
			throw new IllegalArgumentException("ERROR 중복된 숫자가 있습니다.");
		
	}
}
