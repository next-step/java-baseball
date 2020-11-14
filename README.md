# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
- Number 생성
    - 1~9 사이의 숫자

- BaseballNumber 생성
    - 1~3 사이의 index + Number
    - 다른 BaseballNumber 매칭 후 결과 상태 반환 (STRIKE, BALL, NOTHING) 

- BaseballNumbers 생성
    - 3자리 숫자
    - 유효하지 않은 숫자 입력 시
    - BaseballNumbers 매칭 후 상태들 반환
    
- Computer 생성 (랜덤한 서로 다른 숫자 생성) 
    - 1~9 사이의 중복되지 않은 숫자 생성 (캐싱)
    - BaseballNumbers 반환 

- 어플리케이션 요구사항
    - 3개 숫자를 모두 맞히면 게임 종료
    - 게임 종료 후 게임을 다시 시작하거나 종료할 수 있다.
    - 1 입력시 새로 시작, 2 입력 시 종료 
