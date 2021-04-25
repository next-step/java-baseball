package com.woowahan.precource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Play {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Integer> randomBall = new ArrayList<>();
		BaseBall ball;
		Scanner in = new Scanner(System.in);
		randomBall = initBall(randomBall);
		
		while(true) {
			ball = new BaseBall();
			
			System.out.printf("숫자를 입력해주세요 : ");
			
			String[] st = in.next().split("");
			int[] num;
			num = stringToInt(st);
			
			ball.situation.add(num[0]);
			ball.situation.add(num[1]);
			ball.situation.add(num[2]);
			
			if(duplicateCheck(ball.situation, num)) {
				System.out.printf("서로 다른 숫자를 입력바랍니다.\n");
				continue;
			}
			
			ball.findStrikeCount(ball, randomBall);

			if(ball.strikeCount != 0) {
				System.out.printf("%d 스트라이크 ", ball.strikeCount);
			}
			
			ball.findBallCount(ball, randomBall);
			
			if(ball.ballCount != 0) {
				System.out.printf("%d볼", ball.ballCount);
			}
			
			if(ball.strikeCount == 0 && ball.ballCount == 0) {
				System.out.printf("낫싱\n");
				continue;
			}
			
			if(ball.strikeCount != 3) {
				System.out.printf("\n");
				continue;
			}
			
			if(ball.strikeCount == 3) {
				System.out.printf("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				System.out.printf("\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
				int restart = in.nextInt();
				if(restart == 1) {
					randomBall = initBall(randomBall);
					continue;
				}
				if(restart == 2){
					break;
				}
			}
		}
	}

	public static ArrayList<Integer> initBall(ArrayList<Integer> randomBall) {
		while(true) {
			int[] number = new int[3];
			randomBall.clear();
			number = random(number);
			if(!duplicateCheck(randomBall, number)) {
				break;
			}
		}
		return randomBall;
	}
	public static boolean duplicateCheck(ArrayList<Integer> init, int[] index) {
		int[] checkedNumber = new int[10];
		checkedNumber[0] = -1;
		for(int i = 0; i < 3; i++) {
			if(checkedNumber[index[i]] == -1) {
				return true;
			}
			checkedNumber[index[i]] = -1;
			init.add(index[i]);
		}
		return false;
	}
	public static int[] random(int[] number) {
		for(int i = 0; i < 3; i++) {
			number[i] = (int)(Math.random() * 10);
		}
		return number;
	}
	public static int[] stringToInt(String[] str) {
		int[] temp = new int[3];
		for(int i = 0; i < 3; i++) {
			temp[i] = Integer.parseInt(str[i]);
		}
		return temp; 
	}

}
