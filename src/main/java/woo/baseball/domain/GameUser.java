package woo.baseball.domain;

/**
 * @author : chano
 * @Date   : 2020. 11. 11.
 * @Description : 게임을 진행할 유저에대한 필요한 공통필드
 */
public class GameUser {
	
	/**
	 * @Description : 야구게임을 하기위한 digit 이며 3자리수이다.
	 * @Field : baseBallNumberSize
	 */
	private final static int baseBallNumberSize = 3;
	
	/**
	 * @Description : 게임을 즐기기위한 번호이다. 예를들어 231 or 233 or 924...
	 * @Field : baseBallNumber
	 */
	private int baseBallNumber;
	
	/**
	 * @Description : 실질적으로 비즈니스로직에 사용될 유저의 번호이다. split기능을 위해 String형으로 선언되었다.
	 * @Field : strNumber 
	 */
	private String[] strNumber = new String[baseBallNumberSize];

	public int getBaseBallNumber() {
		return baseBallNumber;
	}

	public void setBaseBallNumber(int baseBallNumber) {
		this.baseBallNumber = baseBallNumber;
	}

	public String[] getStrNumber() {
		return strNumber;
	}

	public void setStrNumber(String[] strNumber) {
		this.strNumber = strNumber;
	}

	public static int getBaseballnumbersize() {
		return baseBallNumberSize;
	}

}
