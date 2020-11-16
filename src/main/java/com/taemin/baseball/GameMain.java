package com.taemin.baseball;

public class GameMain {
	
	public static void main(String[] args) {
		try {
			BaseballGameManager.getInstance().GameStart();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
