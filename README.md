# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

[flow ]

1. 3개의 숫자 랜덤 기능
2. 스트라이크 볼 판별(숫자맞추기 기능)
3. 다시 할건지 그만둘건지 기능 

[class 목록]

1) class Game 

-void play()
      → game을 play하는 method

-boolean playGameAgain()

      →  다시 게임할건지 물어보는 method

2) class Player

    -void inputGuessableNumebr(int inputNumber);

   → 추측한 ball을 입력

    - void saveInputNumberArr(int inputnumber)

3) class Ball

     -int shuffleBall();

         → 1~9중에 중복되지 않는 3개의 숫자를 고른다. 

-void saveShuffleBall(int shuffleBallNumber)

  → 100,10,1의 자리의 숫자를 배열에 저장한다. 

4) class Computer

     -void selectGameBall()

→ 3개의 랜덤 볼을 고르는 method(중복제외)

 -void guessNumber(Ball[] ballArr);
    → Ball을 맞추는 method(결과는 print로 한다.)
