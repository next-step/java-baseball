# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 클래스 구성
* BaseballApp : main method 가 위치한 진입 클래스
* BaseballGame : executeGame method를 통해 게임을 진행
* Player(플레이어) : 숫자입력, 입력숫자 검증 기능을 가짐
* Opponent(상대방) : 숫자를 입력받아 매칭 결과값을 출력
 
## Process
1. 상대방 숫자생성
    - Opponent 클래스 초기화
    - random 함수 활용해 1~9 사이의 서로다른 숫자로 이루어진 3자리 수 생성
2. Player 숫자 입력
    - Player 클래스 초기화
    - 숫자 입력
    - 입력숫자 검증
        - 3자리 입력여부
        - 숫자 입력여부
        - 숫자 0 입력여부
        - 중복문자 입력여부
4. 숫자계산 (야구게임)
    - Opponent 클래스의 calulateStrike method 호출
    - Opponent 클래스의 getMessage method 호출해 메시지 출력
5. 게임종료여부 판별
    - Opponent 클래스의 isLose method 호출
    - return 값 true 인 경우 게임종료 메시지 출력 -> loop End
7. 게임진행여부 입력
    - 게임시작 여부 질문
    - 2 입력 시 break
    - 1 입력 시 Opponent strikeNumber reset