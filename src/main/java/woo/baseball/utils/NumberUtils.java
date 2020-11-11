package woo.baseball.utils;

import java.util.Random;
import java.util.Scanner;

/**
 * @author : chano
 * @Date : 2020. 11. 11.
 * @Description : BaseBall에대한 Util 기능들을 개발.
 */
public class BaseBallUtils {

	/**
	 * @Description : 숫자를 생성할 NUMBER이며 여기서는 야구게임의 MAX값인 999 이다.
	 * @Field : MAX_NUMBER
	 */
	private final static int MAX_NUMBER = 999;
	/**
	 * @Description : 숫자를 생성할 NUMBER이며 여기서는 야구게임의 MIN값인 100 이다.
	 * @Field : MIN_NUMBER
	 */
	private final static int MIN_NUMBER = 100;

	/**
	 * @Description : 게임플레이어(Human)이 사용할 입력받을 숫자.
	 * @Field : inputnumber
	 */
	private static int inputnumber;
	/**
	 * @Description : 숫자 입력받을 스캐너객체 선언.
	 * @Field : sc
	 */
	private static Scanner sc;

	/**
	 * @author : chano
	 * @Date : 2020. 11. 11.
	 * @Description : 게임을위한 랜덤 숫자 생성기다.
	 * @Method Name : ballNumberGenerator
	 * @return : int
	 */
	public static int ballNumberGenerator() {
		return new Random().nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
	}

	
	/**
	 * @author : chano
	 * @Date   : 2020. 11. 11.
	 * @Description : 게임플레이어(Human)을 위한 입력받는 메소드.
	 * @Method Name : inputNumber
	 * @return : int
	 */
	public static int inputNumber() {
	    sc = new Scanner(System.in);
		inputnumber=sc.nextInt();
		sc.close();
		return inputnumber;
	}

}
