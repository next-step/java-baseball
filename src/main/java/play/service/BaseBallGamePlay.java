package play.service;

import ui.dto.InputDataDto;
import util.GenerateRandomNumber;

import java.util.List;

public class BaseBallGamePlay implements GamePlay{

	private List<Integer> targetNumberArray;

	@Override
	public void init() {
		// 목표 숫자 초기화
		this.targetNumberArray = generateTargetNumber();
	}

	@Override
	public boolean play(InputDataDto inputDataDto) {
		return true;
	}

	private List<Integer> generateTargetNumber(){
		// 목표 숫자 생성
		return GenerateRandomNumber.generate(10, 3);
	}
}
