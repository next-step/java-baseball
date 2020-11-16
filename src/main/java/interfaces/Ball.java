package interfaces;

public interface Ball {
    //1~9까지의 ball을 세팅한다.
    void initBallArr();


    //볼을 섞는다.
    void shuffleBall();
    //1~9 중 중복되지 않는 3개의 볼을 고른다.
    int selectThreeBalls();

    //100,10,1의 자리 숫자를 배열에 저장한다.
    void saveShuffleBall();

    //각각의 숫자를 3자리숫자로 만들어주는 method
    int mergeNumber();
}
