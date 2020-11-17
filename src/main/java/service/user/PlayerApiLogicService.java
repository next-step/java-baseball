package service.user;

import java.util.*;

import model.entity.Player;

public class PlayerApiLogicService {
	Scanner scan = new Scanner(System.in);
    Player player = new Player();

    public String getInputNumber() {
    	return player.getInputNumber();
    }

    public void inputNumber() {
    	System.out.print("숫자를 입력해주세요 : ");

		player.setInputNumber(scan.nextLine().trim());

		String inputNumber = player.getInputNumber();
		inputNumberLengthException(inputNumber);
		duplicateNumberException(inputNumber);
    }

    public void inputNumberLengthException(String inputNumber) {
		if(inputNumber.length() != 3) {
			throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
		}
	}

	public void duplicateNumberException(String inputNumber) {
		numberFormatException(inputNumber);

		ComputerApiLogicService computerApi = new ComputerApiLogicService();
		List<Integer> numberList = computerApi.stringToList(inputNumber);

		if(numberList.get(0).intValue() == numberList.get(1).intValue() || numberList.get(0).intValue() == numberList.get(2).intValue()
				|| numberList.get(1).intValue() == numberList.get(2).intValue())
			throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
	}

	public void numberFormatException(String inputNumber) {
    	try {
    		Integer.parseInt(inputNumber);
		} catch (NumberFormatException e) {
    		throw new NumberFormatException("숫자만 입력이 가능합니다.");
		}
	}

    public boolean willPlay() {
    	System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
		System.out.print("게임을 새로 시작하려면 1, 종료하려면 2을 입력하세요 : ");
    	String stoppedYn = scan.nextLine().substring(0,1).trim().toUpperCase();
    	
    	if(stoppedYn.equals("2")) {
    		System.out.println("종료 되었습니다.");
    		return false;
    	}
    	return true;
    }
}
