# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

##[Flow]
1. Computer로부터 3개의 숫자(랜덤)를 고른다.  
2. Player가 추측하는 숫자를 입력한다.
3. Computer가 Player가 입력한 숫자를 보고 스트라이크,볼 판별(숫자맞추기 기능)
4. 3스트라이크가 된다면 다시 할건(1)지 그만 둘건지(2) 결정한다.다시 한다면 1번으로 돌아간다. 
 


##[Class and Method 목록]
###1. class Game 
    //game을 play하는 method
    void play()
###2. class Player
    //추측하는 숫자 입력
    void inputGuessableNumber() throws IOException;

    //입력된 숫자를 배열에 저장하는 메서드
    void saveInputNumberArr(int inputNumber);

###3. class Ball
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
    
###4. class Computer
    //3개의 랜덤 볼을 고르는 method(중복제외)
    void selectGameBall();
    
    //사용자가 입력한 숫자와 컴퓨터가 고른 숫자를 비교해서 결과를 내보내는 method
    void guessNumberResult(int inputNumber);
    
    //사용자가 입력한 숫자 저장
    void savePlayerNumberArr(int inputNumber);
    
    //사용자가 입력한 숫자와 컴퓨터가 랜덤으로 선택한 숫자 비교
    void comparePlayerNumberAndComputerNumber(int computerOneNum,int computerOneNumIndex);
    
    //사용자 숫자 1개와 컴퓨터 숫자 1개를 비교하는 method
    void compareOneNumber(int playerOneNum,int playerOneNumIndex,int computerOneNum,int computerOneNumIndex);
    
    //computer 숫자 배열에 저장
    void saveComputerNumberArr(int inputNumber);
