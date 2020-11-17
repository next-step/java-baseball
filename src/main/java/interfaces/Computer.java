package interfaces;

public interface Computer {

    //3개의 랜덤 볼을 고르는 method(중복제외)
    void selectGameBall();
    //사용자가 입력한 숫자와 컴퓨터가 고른 숫자를 비교해서 결과를 내보내는 method
    void guessNumberResult(int inputNumber);

    //사용자가 입력한 숫자 저
    void savePlayerNumberArr(int inputNumber);
    //사용자가 입력한 숫자와 컴퓨터가 랜덤으로 선택한 숫자 비교
    void comparePlayerNumberAndComputerNumber(int computerOneNum,int computerOneNumIndex);
    //사용자 숫자 1개와 컴퓨터 숫자 1개를 비교하는 method
    void compareOneNumber(int playerOneNum,int playerOneNumIndex,int computerOneNum,int computerOneNumIndex);
    //computer 숫자 배열에 저장
    void saveComputerNumberArr(int inputNumber);
}
