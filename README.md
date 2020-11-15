# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
- BaseballGame, Computer, Player 클래스 생성
- BaseballGame 클래스
    1. 게임 반복 진행 로직
    1. 게임 진행중 여부에 따른 Player 의 반복 입력
    1. Computer 가 생성한 숫자와 Player 가 입력한 숫자 비교
    1. Player 의 스트라이크, 볼 카운트
    1. 카운트 한 스트라이크, 볼, 낫싱에 대한 문자열 출력
- Computer 클래스
    1. 숫자 목록(1~9)에서 랜덤한 index 의 숫자 선택 및 목록에서 제거
    1. 선택한 숫자로 각 자리가 서로 다른 3자리 숫자 생성
- Player 클래스
    1. 숫자 반복 입력
    1. 입력 문자열 검증
        - 입력된 문자가 3자리 정수로만 이루어져 있는가
    1. 입력된 숫자를 각 자리수로 이루어진 배열로 변환
---

# String Class에 대한 학습 테스트
## 요구사항 1
- "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
- "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

## 요구사항 2
- "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환하도록 구현한다.

## 요구사항 3
- "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현한다.
- String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
- JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
---

# Set Collection에 대한 학습 테스트
## 요구사항 1
- Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
## 요구사항 2
- Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
- 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
- JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.

## 요구사항 3
- 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
- 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.