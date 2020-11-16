package interfaces;

public interface Computer {

    //3개의 랜덤 볼을 고르는 method(중복제외)
    void selectGameBall();
    //사용자가 입력한 숫자와 컴퓨터가 고른 숫자를 비교해서 결과를 내보내는 method
    void guessNumberResult(int inputNumber);

}
