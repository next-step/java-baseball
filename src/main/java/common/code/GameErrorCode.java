package common.code;


/**
 * @brief
 * Game 공통 에러 코드
 * @details Game에서 사용할 공통 에러 코드를 서술합니다.
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
public enum GameErrorCode {
	
	NUMBER_RANGE_ERROR("0001","Range of number is wrong."),
	NUMBER_NON_UNIQUE_ERROR("0002", "The number must be unique."),
	INPUT_INVALID_FORMAT_ERROR("0003", "Invalid input format");
	
	private String errorCode;
	private String errorMessage;
	
	private GameErrorCode(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
