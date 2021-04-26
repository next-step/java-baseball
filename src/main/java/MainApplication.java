import kr.nais.baseball.BaseBallService;

public class MainApplication {
  public static void main(String[] args) {
    BaseBallService baseBallService = new BaseBallService();

    boolean isContinue;
    do {
      // 랜덤으로 정답 값을 생성한다.
      baseBallService.createAnswer();
      //게임을 시작 한다.
      baseBallService.play();;
      //Replay 할 것 인지 확인한다.
      isContinue = baseBallService.isReplay();
    } while (isContinue);
  }
}
