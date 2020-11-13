package com.woowahan.camp.util;

import java.util.Random;

public class RandomUtil {
	public static int randomNum(int num) {
		Random generator = new Random();
		num = generator.nextInt(num);
		return num;
	}
}
