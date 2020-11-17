# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항

- 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 맞추는 게임
- 같은 수가 같은 자리에 있으면 스트라이크, 다른자리에 있으면 볼, 같은 수가 전혀 없으면 '낫싱'이란 힌트를 얻고 힌트를 이용해서 상대방(컴퓨터)의 3자리 수를 맞추면 승리한다.
- 컴퓨터는 1에서 9까지 서로 다른 3자리 수를 생성하고 사용자는 컴퓨터가 생성한 3개의 숫자를 입력하고, 컴퓨터 입력한 숫자에 대한 결과를 받는다.
- 이 과정을 반복해서 컴퓨터가 선택한 3개의 숫자를 맞추면 게임이 종료된다.
- 게임 종료 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

## 프로그래밍 요구사항

- 자바 코드 컨벤션을 지킨다.
- indent(인덴트, 들여쓰기) depth를 2이 넘지 않도록 구현한다.
- 자바 8 Stream API를 사용하지 않고 구현한다. 람다는 사용가능.
- else 예약어를 쓰지 않는다.
- 함수(메소드)가 한가지 일만 하도록 최대한 작게 만든다. 10라인을 넘어가지 않도록 구현한다.

## 기능 목록

- [X] 야구게임에 필요한 숫자 구현
- [X] STRIKE 구현
- [X] BALL 구현
- [X] Random 숫자 생성기 구현
- [X] Player 숫자 생성기 구현
- [X] Player 숫자 구현
- [X] Computer 숫자 구현
- [X] 숫자 매칭 결과 구현
- [X] 야구게임 숫자 매칭 계산 및 실행

## 객체 역할

### [ number ]
##### BaseBallNumber
- 야구게임에서 사용하는 숫자 하나를 의미하는 객체
    - 1~9 까지 숫자를 검증한다.
    
##### BaseBallNumbers
- 야구게임 숫자들을 가지고 있는 일급 컬렉션
    - STRIKE, BALL 매칭 계산
       
##### ComputerBallNumber
- Computer 숫자를 의미하는 객체
    - RandomNumberGenerator를 이용하여 Computer 숫자 생성
       
##### PlayerBallNumber
- Player 숫자를 의미하는 객체
    - PlayerNumberGenerator를 이용하여 Player 숫자 생성


### [ hint ]
##### STRIKE
- STRIKE 힌트 객체
    - STRIKE 갯수와 매칭 여부를 판단한다.
    
##### BALL
- BALL 힌트 객체
    - BALL 갯수와 매칭 여부를 판단한다.


### [ generator ]
##### SourceNumbers
- 숫자 생성기에서 사용할 숫자 객체
    - 사용할 1~9의 숫자를 생성하고 캐싱

##### RandomNumberGenerator
- Random 숫자 생성기
    - SourceNumbers를 사용하여 랜덤한 3자리 숫자를 생성
    
##### PlayerNumberGenerator
- Player 입력한 숫자 생성기
    - Player가 입력값으로 야구게임 숫자를 생성
    
    
### [ exception ]
##### BaseBallException
- 야구게임 예외 처리

##### ExceptionMessage
- 야구게임 예외 메시지 관리


### [ view ]
##### InputView
- 입력 관련 처리

##### OutputView
- 출력 관련 처리
