package controller;

import service.user.ComputerApiLogicService;
import service.user.PlayerApiLogicService;
import util.GameUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseballGameController {
	final int OUT = 3;
	List<Integer> randomNumberList = new ArrayList<>();
	List<Integer> inputNumberList = new ArrayList<>();

	GameUtils utils = new GameUtils();
	PlayerApiLogicService playerApi;
	ComputerApiLogicService computerApi;

	public void play() {
		while(true) {
			computerApi = new ComputerApiLogicService();

            randomNumberList = computerApi.setToList(computerApi.makeRandomNumber());

			gameRule(randomNumberList);
		}
	}

	public void gameRule(List<Integer> randomNumberList) {
		int strike = 0;
		Map<String, Integer> resultMap;

		while(strike < OUT) {
			try {
				playerApi = new PlayerApiLogicService();
				playerApi.inputNumber();

				String inputNumber = playerApi.getInputNumber();
				inputNumberList = computerApi.stringToList(inputNumber);

				resultMap = computerApi.returnResultBaseballGame(inputNumberList, randomNumberList);
				strike = resultMap.get("strike");
				int ball = resultMap.get("ball");

				utils.printHintMessage(strike, ball);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		restartGame(strike);
	}

	public void restartGame(int strike) {
		boolean playFlag = true;
		if(strike == OUT)
			playFlag = playerApi.willPlay();

		if(!playFlag)
			utils.endGame();
	}
}