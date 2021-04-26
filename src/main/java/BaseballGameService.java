import org.springframework.stereotype.Component;

/**
 * <pre>
 * com.techcamp
 * ㄴ BaseballGameService.java
 * </pre>
 * @date : 2021-04-26 오후 5:03
 * @author : 김재범
 * @version : 1.0.0
 * @desc : 숫자야구 게임
 **/
@Component
public class BaseballGameService {
    private String answer;
    private boolean isContinue;
    private String input;

    /**
     * <pre>
     * 숫자 야구 시작 전 초기화
     * 정답 clear, 진행여부값 초기화, 정답 설정
     * </pre>
     * @author 김재범
     **/
    private void reset() {
        //TODO 초기화 로직 구현
    }

    /**
     * <pre>
     * 숫자야구 정답 3자리 숫자 생성
     * 0~9 숫자 3자리. 중복허용X
     * </pre>
     * @author 김재범
     **/
    private void init() {
        //TODO 숫자야구 정답 3자리 숫자 생성
    }
}
