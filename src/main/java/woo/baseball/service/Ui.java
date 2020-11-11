package woo.baseball.service;

import woo.baseball.utils.UiEnum;

/**
 * @author : chano
 * @Date   : 2020. 11. 11.
 * @Description : 
 */
public class Ui {
	public  static void inputText(String number) {
		System.out.println(UiEnum.INPUTTEXT.text()+number);
	}
	public static void strike(int strike) {
		System.out.println(strike+UiEnum.STRIKE.text());
	}
	public static void ball(String ball) {
		System.out.println(ball+UiEnum.BALL.text());
	}
	public static void success() {
		System.out.println(UiEnum.SUCCESSTEXT.text());
	}
}
