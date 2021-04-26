package play.service;

import play.dto.GameResult;
import ui.dto.InputDataDto;
import util.GenerateRandomNumber;

import java.util.List;

public class BaseBallGamePlayService implements GamePlayService {

	private List<Integer> targetNumberArray;

	@Override
	public void init() {
		// 목표 숫자 초기화
		this.targetNumberArray = generateTargetNumber();
	}

	@Override
	public GameResult play(InputDataDto inputDataDto) {
		GameResult gameResult = new GameResult();
		check(inputDataDto.getNumberWithDigit(InputDataDto.Digit.HUNDRED), InputDataDto.Digit.HUNDRED, gameResult);
		check(inputDataDto.getNumberWithDigit(InputDataDto.Digit.TEN), InputDataDto.Digit.TEN, gameResult);
		check(inputDataDto.getNumberWithDigit(InputDataDto.Digit.ONE), InputDataDto.Digit.ONE, gameResult);
		return gameResult;
	}

	private void check(int value, InputDataDto.Digit index, GameResult gameResult){
		// 스트라이크
		if(targetNumberArray.get(index.getIndex()) == value){
			gameResult.strike();
			return;
		}

		// 볼
		if(targetNumberArray.contains(value)){
			gameResult.ball();
		}
	}

	private List<Integer> generateTargetNumber(){
		// 목표 숫자 생성
		return GenerateRandomNumber.generate(10, 3);
	}

	public List<Integer> getTargetNumberArray(){
		return this.targetNumberArray;
	}
}
