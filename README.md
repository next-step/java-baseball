# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
* 컴퓨터의 BaseBallNumber 생성 기능
  * BaseBallNumber 의 각 숫자는 1 부터 9 까지 랜덤이다.
  * BaseBallNumber 의 숫자는 총 3개로 이루어져 있다.
  * BaseBallNumber 의 각 숫자들은 서로 중복되지 않는다.
* 사용자가 예상하는 BaseBallNumber 입력 기능
  * 사용자가 입력한 숫자는 총 3개로 이루어져 있어야 한다.
  * 사용자가 입력한 숫자는 서로 중복되지 않아야 한다.
  * 위 조건을 만족하지 않는다면 에러 메시지를 출력하고, 다시 입력 받는다.
  * BaseBallNumber 입력 기능은 컴퓨터가 생성한 BaseBallNumber 를 맞출 때까지 진행된다.
* BaseBallNumber 비교 기능 (두 개의 BaseBallNumber 를 각각 a, b 라고 명명한다.)
  * a와 b의 숫자를 비교해서 같은 자리에 같은 숫자가 있으면 스트라이크이다.
  * a와 b의 숫자를 비교해서 다른 자리에 같은 숫자가 존재하면 볼이다.
  * a와 b의 숫자를 비교해서 같은 숫자가 없다면 낫싱이다.
* 게임 종료 기능
  * 사용자가 컴퓨터가 생성한 BaseBallNumber 을 맞췄다면 게임을 종료할 지, 다시 시작할 지 선택할 수 있다.
