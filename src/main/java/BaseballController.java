package main.java;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("resource")
public class BaseballController {
	LinkedHashSet<Integer> lhs = null;
	ArrayList<Integer> list = null;
	Object[] arr = {}; 
	int strike, ball;
	
	public static void main(String[] args) {
		BaseballController c = new BaseballController();
		do {
			c.getRandomList();
			
			c.insertInputList();
			
		} while (c.showResult());
	}
	
	private void getRandomList() {
		lhs = new LinkedHashSet<Integer>();
		do {
			Random rd = new Random();
			int a = rd.nextInt(8)+1;
			lhs.add(a);
		} while (lhs.size() < 3);
	}
	
	private void insertInputList() {
		do {
			strike = 0; ball = 0;
			printMsg("숫자를 입력해주세요 : ");
	
			getInputList();
			
			forRandomList();
			
			calcPoint();
		} while (strike < 3);
	}
	
	private void getInputList() {
		list = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		String input = in.next();
		for(int i = 0; i < input.length(); i++) {
			list.add(Integer.parseInt(String.valueOf(input.charAt(i))));
		}
		
		if(list.size() != 3) {
			printMsg("잘못 입력하셨습니다.\n");
		}
	}
	
	private void printMsg(String msg) {
		System.out.print(msg);
	}
	
	private void forRandomList() {
		arr = lhs.toArray();
		for(int i = 0; i < arr.length; i++) {
			forInputList(i);
		}
	}
	
	private void forInputList(int i) {
		for(int j = 0; j < list.size(); j++) {
			compareList(i, j);
		}
	}
	
	private void compareList(int i, int j) {
		if (arr[i] == list.get(j)) {
			checkPoint(i, j);
		}
	}
	
	private void checkPoint(int i, int j) {
		if (i == j) {
			strike++;
		}
		if (i != j) {
			ball++;
		}
	}
	
	private void calcPoint() {
		StringBuffer msg = new StringBuffer();
		if(strike > 0) {
			msg.append(strike).append(" 스트라이크 ");
		}
		if(ball > 0){
			msg.append(ball).append(" 볼");
		}
		printMsg(msg.append("\n").toString());
	}
	
	private boolean showResult() {
		boolean flag = true;
		
		printMsg("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
		printMsg("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
		
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		if(input != 1) {
			flag = false;
		}
		
		return flag;
	}
}
