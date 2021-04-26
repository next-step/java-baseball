# 숫자 야구 게임 - 백성락
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 미션 요구사항

<details>
<summary>자세히</summary>

<br>

> ### 기능 요구사항
>
> 1. 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다. <br><br>
>
> 2. 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌드를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
     <br> [예] 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1 스트라이크, 456을 제시한 경우 : 1 스트라이크 1볼, 789를 제시한 경우 : 낫싱
><br><br>
> 3. 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
><br><br>
> 4. 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
><br><br>
> 5. 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

> ### 프로그래밍 요구사항 (메소드 분리)
>
> 1. 자바 코드 컨벤션을 지키면서 프로그래밍한다. <br>
     [캠퍼스 핵데이 Java 코딩 컨벤션](https://naver.github.io/hackday-conventions-java)
><br><br>
> 2. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다. <br><br>
>
> 3. 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다. <br><br>
>
> 4. else 예약어를 쓰지 않는다. <br><br>
> 
> 5. 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.

</details>

<br>

## 기능 구현 목록

1. (BaseballRandomNumber) **1부터 9까지 서로 다른 수**로 이루어진 **3자리의 수**를 생성하는 기능.
    - (구현) 숫자 생성시 **1~9**까지 번호를 골라서 섞음
    
    - (구현) 숫자 생성시 **0**이 포함되지 않도록 생성.

    - (구현) 섞은 값 중에 첫번째 번호부터 세번째 번호까지 출력
<br><br>
2. (BaseballNumbers) 사용자로부터 **3자리 수를 입력**받는 기능.

    - (예외) **1부터 9까지의** 3자리 수가 입력되지 **않은** 경우 (문자 또는 3자리 미만, 초과의 경우, **0이 들어올 경우**).

    - (예외) 3자리 수 중에서 **같은 수가 입력**된 경우.
      
    - (구현) 3개의 번호로 볼, 스트라이크 개수 계산
<br><br>

3. (BaseballNumber) 야구번호 **1부터 9까지 입력** 받는 기능.

   - (예외) **1부터 9까지의** 숫자를 벗어난 경우.

   - (예외) 3자리 수 중에서 **Null**이 입력될 경우.
<br><br>      

4. (Strike) **스트라이크**의 개수를 구하는 기능.

    - (예외) 스트라이크 범위를 벗어날 경우
<br><br>
5. (Ball) **볼**의 개수를 구하는 기능.

    - (예외) 볼 범위를 벗어날 경우
<br><br>
6. (BaseballResult) 야구게임 결과를 보여주는 기능.

    - (에외) 볼, 스트라이크 점수가 null이면 requireNonNull 리턴.
<br><br>
7. (OutputView) 스트라이크, 볼, 또는 포볼(낫싱)에 대한 결과를 **출력**.
   - (구현) 스트라이크와 볼의 개수를 출력. 
   
   - (구현) 결과값이 없으면 낫싱 출력.

   - (구현) 3개를 모두 맞출경우 "3개의 숫자를 모두 맞히셨습니다! 게임 종료." 메시지 출력
<br><br>

8. (InputView) 답과 일치하면 게임을 **종료**하는 기능.
    - (구현) 게임을 종료한 후 **다시 시작**하거나 완전히 **종료**하는 기능.    

    - (구현) **1번**을 입력 받으면 게임을 **다시 시작** ([구현 기능 목록](#구현-기능-목록) 처음부터 다시 진행).

    - (구현) **2번**을 입력 받으면 게임(프로그램) **종료**.
       
    - (구현) **스트라이크의 개수가 3개**이면 답과 일치하므로 게임 종료 ("야구게임 완전히 종료" 출력문도 함께 출력).

    - (예외) **Null**이 들어올 경우.

    - (예외) **문자**가 들어올 경우.

    - (예외) **3자리**가 아닌 경우.
   
<br>

