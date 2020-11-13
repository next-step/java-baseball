package domain.enums;

/**
 * @author : byungkyu
 * @date : 2020/11/13
 * @description : 종료시 재시도여부를 묻고 반환받는 답변타입
 **/
public enum RetryType {
	NEW_GAME("1"),
	EXIT("2");

	private String code;

	RetryType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
