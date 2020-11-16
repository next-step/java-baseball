package woo.baseball.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import woo.baseball.business.InputBusiness;
import woo.baseball.domain.GameStatus;
import woo.baseball.domain.GameUser;
import woo.baseball.type.InputType;

/**
 * @author : chano
 * @Date : 2020. 11. 11.
 * @Description : BaseBall에대한 Util 기능들을 개발.
 */
public class InputService {
  
  private static Random random =  new Random();



	/**
	 * @author : chano
	 * @Date : 2020. 11. 11.
	 * @Description : 게임을위한 랜덤 숫자 생성기다.
	 * @Method Name : ballNumberGenerator
	 * @return : int
	 */
	public static int ballNumberGenerator() {
	 int number = 0 ;
	  while(!validDistinctNumber(number)) {
	    number =  random.nextInt(GameStatus.MAX_NUMBER - GameStatus.MIN_NUMBER + 1) + GameStatus.MIN_NUMBER;
	  }
		return number;
	}
	
	
	 /**
	 * @author : chano
	 * @Date   : 2020. 11. 16.
	 * @Description : 입력을받는데 3개의 숫자중 중복된 숫자가 있는지 확인한다.
	 * @Method Name : validDistinctNumber
	 * @return : boolean
	 */
	public static boolean validDistinctNumber(int baseBallNumber) {
	    String [] strNumbers= String.valueOf(baseBallNumber).split("");
	    HashSet<String> checkbaseBallNumber = new HashSet<String>();
	    for (int i = 0; i < strNumbers.length; i++) {
	      checkbaseBallNumber.add(strNumbers[i]);
	    }
	    if(checkbaseBallNumber.size()==GameUser.baseBallNumberSize) {
	      return true;
	    }
	    return false;
	  }

	/**
	 * @author : chano
	 * @Date   : 2020. 11. 11.
	 * @Description : 입력받을 타입을 받아 넘긴다.
	 * @Method Name : inputNumber
	 * @return : int
	 */
	public static GameUser inputNumber(InputType type) {
	   Scanner sc=new Scanner(System.in);
	  if(type.equals(InputType.BALL_NUMBER)) {
	    return InputBusiness.checkBaseBallNumber(sc);
	  }
	  if(type.equals(InputType.GAME_NUMBER)) {
	    return InputBusiness.checkGameRunNumber(sc);
	  }
	  sc.close();
    return new GameUser(GameStatus.GAME_GO);
  }
	
	  
}
