# 숫자 야구 게임

## 요구사항
### 코드 컨벤션 준수 
### 특히 기능을 구현하기 전에 기능 목록을 생성, 기능별로 commit
### 단일책임의 원칙을 준수 
### 코드 depth 2미만으로 코드 작성
### jUnit5 AssertJ로 핵심 기능 단위 테스트 구현

## 기능 목록

1. 3자리 숫자를 int형 배열로 가지고 있는 클래스 생성
    -> Baseball class
    1. 1부터 9 사이의 서로 다른 난수 3개
    2. 컴퓨터가 랜덤으로 생성
    3. 사용자가 입력으로 생성

2. 서로 다른 난수 3자리를 생성하기 위한 클래스
    -> BaseballNumberGenerator class
    * 서로 다른 난수 3자리를 생성

3. 사용자 입력값 유효성 검사
    -> InputValidate class
    * 사용자의 입력이 1~9로 이루어진 서로 다른 숫자가 입력되었는지 유효성 검사를 하기 위한 클래스
    * 예외 처리 목록
        1. 입력한 자릿수가 맞는지 여부
        2. 숫자 여부
        3. 중복된 숫자는 없는지 여부
        4. 0이 포함되어 있는지 여부 
        -> 에러 이유 메세지가 담긴 IllegalArgumentException 에러를 발생시킨다.

3.  배열에 해당 숫자가 포함되어있는지 여부 검사
    -> ContainsChecker class
    * 숫자가 해당 배열에 포함되어 있는지 판별하는 클래스
        * 사용처
        1. MatchChecker 에서 ball을 판별할 떄
        2. BaseballNumberGenerator 에서 숫자를 생성할때 서로 다른 숫자를 생성핫기 위해서

4.  컴퓨터의 수와 사용자의 수 비교
    -> MatchCheker class
    * 컴퓨터의 난수 3자리와 사용자 숫자 3자리를 비교해서 매칭 여부를 판단하고 결과를 리턴하는 클래스
    * 인스턴스 멤버로 strike, ball을 가지고 있는 객체
        1. checkStrike
        2. checkBall
    * 사용자의 입력에 대해서 정답 여부를 return한다. (isAnswer)
 
