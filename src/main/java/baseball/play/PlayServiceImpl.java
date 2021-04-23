package baseball.play;

import java.util.List;

import baseball.answer.AnswerService;

public class PlayServiceImpl implements PlayService {

	private final AnswerService answerService;

	public PlayServiceImpl(AnswerService answerService) {
		this.answerService = answerService;
	}

	@Override
	public void playBall() {
		List answer = answerService.buildAnswer();

		// todo 질문 입력 메소드
		// todo 입력값 검증 객체 생성. 성공여부, 메세지 파라미터는 입력값
		// todo 입력값 검증 및 결과메세지 출력
		// todo 성공시 retry?
		if (false) {
			playBall();
		}
	}
}
