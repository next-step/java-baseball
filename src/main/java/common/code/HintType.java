package common.code;


/**
 * @brief
 * HintType enum
 * @details HintType을 enum 으로 관리할 수 있도록합니다.
 * @author SUNJU
 * @since 2021. 4. 27.
 * @version 1.0
 * @see
 * <pre>
 *     since          author              description
 *  ===========    =============    ===========================
 *  2021. 4. 27.     SUNJU         최초 생성
 * </pre>

 */
public enum HintType {
	STRIKE("STRIKE","스트라이크"),
	BALL("BALL","볼"),
	NOTHING("NOTHING","낫싱");
	
	String hintCode;
	String hintValue;
	
	private HintType(String hintCode, String hintValue) {
		this.hintCode = hintCode;
		this.hintValue = hintValue;
	}

	
	public String getHintCode() {
		return hintCode;
	}
	
	public String getHintValue() {
		return hintValue;
	}
	

}
